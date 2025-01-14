public class Coupon {
    double percentage;
    String type;
    ProductType targetType;

    Coupon(double percentage, String type) {
        this.percentage = percentage;
        this.type = type;
    }

    Coupon(double percentage, String type, ProductType targetType) {
        this(percentage, type);
        this.targetType = targetType;
    }
}
