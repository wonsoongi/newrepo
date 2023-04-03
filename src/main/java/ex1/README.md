# Exercise 1: Implementing an interface, overriding of methods

### Part A

Create a `Point` class that implements the `IPoint` interface.

The class must fulfil the following requirements.

- The constructor accepts `double` values as specified in the interface.

- Printing a point with coordinates x, y gives the output `(x,y)`.

    ```java
    IPoint p = new Point(1,2);
    System.out.println(p);
    // output: (1.0,2.0)
    ```

- `boolean equals(Object o)` returns true if two points are equal, that is, if they share the same coordinates.

    ```java
    IPoint p1 = new Point(1,2);
    IPoint p2 = new Point(1,2);
    System.out.println(p1.equals(p2))
    // output: true
    ```

- `double getDistance(IPoint p)` returns the Euclidean distance between two points with a precision of 2 decimal places.

    ```java
    IPoint p1 = new Point(1,1);
    IPoint p2 = new Point(4,5);
    System.out.println(p1.getDistance(p2))
    // output: 5
    ```

  To round up doubles, use the static method in `IPoint`.


- `int compareTo(IPoint p)` compares the current point `c` with point `p`. The method returns:
    - 0 if the points have the same coordinates,
    - a negative integer if `c.x < p.x` or `c.x = p.x` and `c.y < p.y`,
    - a positive integer otherwise.

    ```java
    IPoint p1 = new Point(1,1);
    IPoint p2 = new Point(4,5);
    System.out.println(p1.compareTo(p2))
    // output: -3
    IPoint p2 = new Point(1,2);
    System.out.println(p1.compareTo(p2))
    // output: -1
    IPoint p2 = new Point(2,1);
    System.out.println(p1.compareTo(p2))
    // output: 1
    ```

    Once you have created the `Point`class, go to `src/test/java/ex1/PointTest.java` and uncomment the indicated code blocks, setting up proper tests.

### Part B

Create a `Triangle` class that implements the `ITriangle` interface representing a triangle in a two-dimensional Euclidean space, using `IPoint` as basic building block.

The implementation must fulfil the following requirements.

- The constructor of `Triangle` checks whether the given points form a proper triangle, ruling out the case where
    - "The points lie on the same line." and
    - the more specific case where "Some points coincide."

    In both cases, the constructor must throw an `IllegalArgumentException` with the messages in quotes above.

    ```java
    IPoint p1 = new Point(1,1);
    IPoint p2 = new Point(1,1);
    IPoint p3 = new Point(1,2);
    ITriangle t = new Triangle(p1,p2,p3);
    //output: throws an IllegalArgumentException
    ```

- `double getPerimeter()` returns the perimeter of the triangle by summing up the length of the three sides of the triangle. Your perimeter should have a precision of 3 decimal places.

    ```java
    IPoint p1 = new Point(0,0);
    IPoint p2 = new Point(3,0);
    IPoint p3 = new Point(3,4);
    ITriangle t = new Triangle(p1,p2,p3);
    System.out.println(t.getPerimiter())
    // output: 12
    ```

    To round up the returned value, use the static method in `IPoint`.

- Two triangles are equal if they have the same coordinates. Note that the order of coordinates may differ between the two compared triangles.

    ```java
    IPoint p1 = new Point(0,0);
    IPoint p2 = new Point(3,0);
    IPoint p3 = new Point(3,4);
    ITriangle t1 = new Triangle(p1,p2,p3);
    ITriangle t2 = new Triangle(p2,p3,p1);
    System.out.println(t1.equals(t2))
    // output: true
    ```

    **Hint:** recall that points can be compared!


### Part C

Create the `EquilateralTriangle` class that extends the`Triangle`.

The class must fulfil the following requirements.

- The constructor does the additional check that all sides of the triangle have the same length. If this is not the case, an `IllegalArgumentException` is thrown with the message "Not an equilateral triangle.".

- `double getPerimeter()` overrides the implementation of the parent class, computing the perimeter by multiplying the length of one side by three.

Once you have created the `Triangle` and `EquilateralTriangle` classes, go to `src/test/java/ex1/TriangleTest.java` and `src/test/java/ex1/EquilateeralTriangleTest.java` and uncomment the indicated code blocks, setting up proper tests.
