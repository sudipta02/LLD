class AllItemDiscount extends DiscountDecorator {
    public AllItemDiscount(CartItem item, double discountPercentage) {
        super(item, discountPercentage, "All Items Discount");
    }

    @Override
    public double getPrice() {
        return applyDiscount(item.getPrice());
    }
}