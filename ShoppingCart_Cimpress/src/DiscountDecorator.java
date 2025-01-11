public abstract class DiscountDecorator implements CartItem {
    protected CartItem item;
    protected double discountPercentage;
    protected String discountName;

    public DiscountDecorator(CartItem item, double discountPercentage, String discountName) {
        this.item = item;
        this.discountPercentage = discountPercentage;
        this.discountName = discountName;
    }

    @Override
    public String getName() {
        return item.getName() + " [" + discountName + " " + discountPercentage + "%]";
    }

    @Override
    public ProductType getType() {
        return item.getType();
    }

    @Override
    public int getQuantity() {
        return item.getQuantity();
    }

    protected double applyDiscount(double price) {
        return price * (1 - discountPercentage / 100);
    }
}