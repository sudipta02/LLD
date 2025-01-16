**Definition:**
The Liskov Substitution Principle (LSP) is one of the SOLID principles in object-oriented design. It states that subtypes must be substitutable for their base types without altering the correctness of the program. In simpler terms, if class B is a subclass of class A, you should be able to replace A with B without affecting the functionality of your application.

**Scenario: Shape Example**  
Imagine you are designing a hierarchy for shapes, where you calculate the area of each shape. Let's apply the LSP principle.

**Correct Implementation of LSP**  
Step 1: Define a base class Shape.
```java
abstract class Shape {
    public abstract double getArea();
}
```
Step 2: Implement concrete classes for Rectangle and Square.
```java
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
```
Step 3: Write a utility function that works with any Shape.
```java
public class ShapeAreaCalculator {
    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }
}
```
Step 4: Test the program.
```java
public class LiskovExample {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        Shape square = new Square(4);

        ShapeAreaCalculator.printArea(rectangle); // Output: Area: 50.0
        ShapeAreaCalculator.printArea(square);    // Output: Area: 16.0
    }
}
```
**Explanation of LSP Compliance**
- Both Rectangle and Square are subtypes of Shape and can be used interchangeably wherever a Shape is required.
- The printArea method works seamlessly with both subtypes (Rectangle and Square) because the getArea implementation in each subclass correctly fulfills the contract defined in the Shape base class.


**Violation of LSP**
Now, consider if we incorrectly designed Square as a subclass of Rectangle:
```java
class Rectangle {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }

    @Override
    public void setHeight(double side) {
        super.setWidth(side);
        super.setHeight(side);
    }
}
```
In this case:
1. Square overrides setWidth and setHeight to ensure both width and height are always equal.
2. This breaks the LSP because now, substituting a Square in place of a Rectangle might lead to unexpected behavior.

Problematic Test Case:
```java
public class LiskovViolationExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Square();
        rectangle.setWidth(5);
        rectangle.setHeight(10); // Unexpected! Square sides are now inconsistent.
        System.out.println("Area: " + rectangle.getArea()); // Incorrect result!
    }
}
```

**Key Takeaways**
1. Follow the Contract: Subclasses must adhere to the behavior expected by the base class.
2. Avoid Excessive Overrides: Overriding methods to alter base functionality can lead to LSP violations.
3. Design Hierarchies Thoughtfully: Use inheritance only when it makes sense, and avoid "is-a" relationships that don't fit naturally.

By designing Rectangle and Square as independent classes, we followed the Liskov Substitution Principle correctly.
