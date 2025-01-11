import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    private Map<Integer, List<DiscountInfo>> pendingDiscounts = new HashMap<>();
    private List<DiscountInfo> globalDiscounts = new ArrayList<>(); // New field for ALL type discounts

    private static class DiscountInfo {
        double percentage;
        String type;
        ProductType targetType;

        DiscountInfo(double percentage, String type) {
            this.percentage = percentage;
            this.type = type;
        }

        DiscountInfo(double percentage, String type, ProductType targetType) {
            this(percentage, type);
            this.targetType = targetType;
        }
    }

    public void addItem(CartItem item) {
        // First apply any pending discounts specific to this item
        CartItem decoratedItem = applyPendingDiscounts(item, items.size());

        // Then apply all global discounts
        for (DiscountInfo discount : globalDiscounts) {
            decoratedItem = new AllItemDiscount(decoratedItem, discount.percentage);
        }

        items.add(decoratedItem);
    }

    public void addDiscount(double percentage, String type) {
        addDiscount(percentage, type, null);
    }

    public void addDiscount(double percentage, String type, ProductType targetType) {
        if ("ALL".equals(type)) {
            // For ALL type discounts, add to global discounts and apply to all existing
            // items
            globalDiscounts.add(new DiscountInfo(percentage, type));
            applyGlobalDiscountToExistingItems(percentage);
        } else {
            int nextItemIndex = getNextProductIndex();
            if (nextItemIndex == -1) {
                pendingDiscounts.computeIfAbsent(items.size(), k -> new ArrayList<>())
                        .add(new DiscountInfo(percentage, type, targetType));
            } else {
                applyDiscountToItem(nextItemIndex, percentage, type, targetType);
            }
        }
    }

    private void applyGlobalDiscountToExistingItems(double percentage) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            items.set(i, new AllItemDiscount(item, percentage));
        }
    }

    private int getNextProductIndex() {
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i) instanceof BaseProduct) {
                return i;
            }
        }
        return -1;
    }

    private CartItem applyPendingDiscounts(CartItem item, int index) {
        if (!(item instanceof BaseProduct)) {
            return item;
        }

        CartItem decoratedItem = item;
        List<DiscountInfo> discounts = pendingDiscounts.get(index);
        if (discounts != null) {
            for (DiscountInfo discount : discounts) {
                decoratedItem = applyDiscount(decoratedItem, discount);
            }
            pendingDiscounts.remove(index);
        }
        return decoratedItem;
    }

    private void applyDiscountToItem(int index, double percentage, String type, ProductType targetType) {
        CartItem item = items.get(index);
        CartItem decoratedItem = applyDiscount(item, new DiscountInfo(percentage, type, targetType));
        items.set(index, decoratedItem);
    }

    private CartItem applyDiscount(CartItem item, DiscountInfo discount) {
        switch (discount.type) {
            case "ALL":
                return new AllItemDiscount(item, discount.percentage);
            case "NEXT":
                return new NextItemDiscount(item, discount.percentage);
            case "TYPE":
                return new TypeSpecificDiscount(item, discount.percentage, discount.targetType);
            default:
                return item;
        }
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

    public void printCart() {
        System.out.println("\nShopping Cart Contents:");
        items.forEach(item -> System.out.printf("%s: $%.2f (Qty: %d)%n",
                item.getName(),
                item.getPrice(),
                item.getQuantity()));
        System.out.printf("\nTotal: $%.2f%n", calculateTotal());
    }
}
