class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add regular items
        cart.addItem(new BaseProduct("Laptop", 1000.0, ProductType.ELECTRONICS, 1));
        cart.addItem(new BaseProduct("Book", 50.0, ProductType.BOOK, 2));

        // Add discounts
        cart.addDiscount(10.0, "ALL"); // 10% off all items
        cart.addDiscount(20.0, "NEXT"); // 20% off next item
        cart.addDiscount(30.0, "TYPE", ProductType.FOOD); // 30% off next food item

        // Add more items
        cart.addItem(new BaseProduct("Potato Chips", 5.0, ProductType.FOOD, 2));
        cart.addItem(new BaseProduct("T-shirt", 20.0, ProductType.CLOTHING, 2));

        // Print cart contents and total
        cart.printCart();
    }
}