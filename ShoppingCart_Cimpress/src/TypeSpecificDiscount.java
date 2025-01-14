class TypeSpecificDiscount extends DiscountDecorator {
    private ProductType targetType;

    public TypeSpecificDiscount(CartItem item, double discountPercentage, ProductType targetType, int nthItemIndex) {
        super(item, discountPercentage, "Type Specific Discount for " + targetType + " (" + nthItemIndex + ")");
        this.targetType = targetType;
    }
}