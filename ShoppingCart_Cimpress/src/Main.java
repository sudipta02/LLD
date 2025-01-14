class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // --------------------USECASE - 1--------------------------------
        // Add regular items
        // cart.addItem(new BaseProduct("Laptop", 1000.0, ProductType.ELECTRONICS, 1));
        // cart.addItem(new BaseProduct("Book", 50.0, ProductType.BOOK, 2));

        // // Add discounts
        // cart.addItem(new Coupon(10.0, "ALL")); // 10% off all items
        // cart.addItem(new Coupon(20.0, "NEXT")); // 20% off next item
        // cart.addItem(new Coupon(30.0, "TYPE", ProductType.FOOD)); // 30% off next
        // food item

        // // Add more items
        // cart.addItem(new BaseProduct("Potato Chips", 5.0, ProductType.FOOD, 2));
        // cart.addItem(new BaseProduct("T-shirt", 20.0, ProductType.CLOTHING, 2));

        // --------------------USECASE - 2---------------------------------
        cart.addItem(new BaseProduct("Laptop", 12.99, ProductType.ELECTRONICS, 3));
        // Add discounts
        cart.addItem(new Coupon(25.0, "ALL")); // 25% off all items
        cart.addItem(new BaseProduct("T-shirt", 24.99, ProductType.CLOTHING, 1));
        cart.addItem(new Coupon(10.0, "NEXT")); // 20% off next item
        cart.addItem(new Coupon(15.0, "TYPE", ProductType.FOOD)); // 30% off next food item
        cart.addItem(new BaseProduct("T-shirt", 24.99, ProductType.CLOTHING, 1));
        // Add more items
        cart.addItem(new BaseProduct("Potato Chips", 34.99, ProductType.FOOD, 1));

        // Print cart contents and total
        cart.printCart();
    }
}