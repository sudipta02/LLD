class BaseProduct implements CartItem {
    private String name;
    private double price;
    private ProductType type;
    private int quantity;

    public BaseProduct(String name, double price, ProductType type, int quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price * quantity;
    }

    @Override
    public ProductType getType() {
        return type;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}