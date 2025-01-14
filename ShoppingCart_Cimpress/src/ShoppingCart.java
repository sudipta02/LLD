import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    private List<DiscountInfo> pendingDiscounts = new ArrayList<>();
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
        CartItem decoratedItem = applyPendingDiscounts(item);

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
            pendingDiscounts.add(new DiscountInfo(percentage, type, targetType));
        }
    }

    private void applyGlobalDiscountToExistingItems(double percentage) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            items.set(i, new AllItemDiscount(item, percentage));
        }
    }

    private CartItem applyPendingDiscounts(CartItem item) {
        if (!(item instanceof BaseProduct)) {
            return item;
        }

        CartItem decoratedItem = item;
        Iterator<DiscountInfo> iterator = pendingDiscounts.iterator();
        while (iterator.hasNext()) {
            DiscountInfo discount = iterator.next();
            if (discount.targetType == item.getType() || discount.type.equals("NEXT")) {
                decoratedItem = applyDiscount(decoratedItem, discount);
                iterator.remove(); // Safely remove the item using the iterator
            }
        }
        return decoratedItem;
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
