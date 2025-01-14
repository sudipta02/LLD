import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();
    private List<Coupon> coupons = new ArrayList<>();

    public void addItem(CartItem item) {
        // First apply any pending discounts specific to this item
        CartItem decoratedItem = applyPendingDiscounts(item);
        items.add(decoratedItem);
    }

    public void addItem(Coupon coupon) {
        if (coupon.type.equals("ALL")) {
            coupons.add(coupon);
            applyGlobalDiscountToExistingItems(coupon.percentage);
        } else if (coupon.type.equals("TYPE")) {
            coupons.add(coupon);
            applyDiscountToNthItemOfType(coupon);
        } else if (coupon.type.equals("NEXT")) {
            coupons.add(coupon);
        }
    }

    private void applyDiscountToNthItemOfType(Coupon coupon) {
        int n = 0;
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.getType() == coupon.targetType) {
                n++;
                if (n == coupon.nthItemIndex) {
                    items.set(i,
                            new TypeSpecificDiscount(item, coupon.percentage, coupon.targetType, coupon.nthItemIndex));
                }
            }
        }
    }

    private void applyGlobalDiscountToExistingItems(double percentage) {
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            items.set(i, new AllItemDiscount(item, percentage));
        }
    }

    private CartItem checkItemEligibleForTypeSpecificDiscount(CartItem decoratedItem) {
        int n = 0;
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.getType().equals(decoratedItem.getType())) {
                n++;
            }
        }
        n++;
        for (int i = 0; i < coupons.size(); i++) {
            Coupon coupon = coupons.get(i);
            if (coupon.targetType != null && coupon.targetType.equals(decoratedItem.getType())
                    && coupon.nthItemIndex == n) {
                decoratedItem = applyDiscount(decoratedItem, coupon);
            }
        }
        return decoratedItem;
    }

    private CartItem applyPendingDiscounts(CartItem item) {
        CartItem decoratedItem = item;
        decoratedItem = checkItemEligibleForTypeSpecificDiscount(decoratedItem);
        Iterator<Coupon> iterator = coupons.iterator();
        while (iterator.hasNext()) {
            Coupon coupon = iterator.next();
            if (coupon.type.equals("NEXT") || coupon.type.equals("ALL")) {
                decoratedItem = applyDiscount(decoratedItem, coupon);
                if (coupon.type.equals("NEXT")) {
                    iterator.remove();
                }
            }
        }
        return decoratedItem;
    }

    private CartItem applyDiscount(CartItem item, Coupon coupon) {
        switch (coupon.type) {
            case "ALL":
                return new AllItemDiscount(item, coupon.percentage);
            case "NEXT":
                return new NextItemDiscount(item, coupon.percentage);
            case "TYPE":
                return new TypeSpecificDiscount(item, coupon.percentage, coupon.targetType, coupon.nthItemIndex);
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
