class NextItemDiscount extends DiscountDecorator {
    public NextItemDiscount(CartItem item, double discountPercentage) {
        super(item, discountPercentage, "Next Item Discount");
    }
}