public class Coupon {
    double percentage;
    String type;
    ProductType targetType;
    int nthItemIndex;

    Coupon(double percentage, String type) {
        this.percentage = percentage;
        this.type = type;
    }

    Coupon(double percentage, String type, ProductType targetType, int nthItemIndex) {
        this(percentage, type);
        this.targetType = targetType;
        this.nthItemIndex = nthItemIndex;
    }
}
