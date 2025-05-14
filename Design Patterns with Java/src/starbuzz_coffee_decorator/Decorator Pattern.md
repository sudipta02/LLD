1. The Decorator Pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
2. Decorator pattern is great example of Open-Closed Principle. Because it allows to extend our classes with any new behaviour/functionality you like, without altering/modifying the existing code.
3. Inheritance is one form of extension, but not necessarily the best way to achieve flexibility in our designs.
4. Composition and delegation can be used to add new behaviours at runtime.
5. The Decorator Pattern involves a set of decorator classes that are used to wrap concrete components.
6. Decorator classes mirror the type of the components they decorate. (In fact, they are the same type as the components they decorate, either through inheritance or interface implementation.)
7. Decorators change the behavior of their components by adding new functionality before and/or after (or even in place of) method calls to the component.
8. Decorators can result in many small objects in our design, and overuse can be complex.