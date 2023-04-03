# Exercise 2: composite hierarchies

We want to implement lists that consist of green and red nodes, where each node is labeled with an integer, and the head node is green.

### Part A

Complete the abstract class `AbstractNode` and the classes `RedNode` and
`GreenNode` so that:
- all three classes implement the interface `Node`, and
- `RedNode` and `GreenNode` extend `AbstractNode`.

In particular:
- the attribute `int label` (in class `AbstractNode`) is the label of the
node, and the method `Node getLabel()` should return it,
- the attribute `Node next` (in class `AbstractNode`) is the next node in
the list (if any), and the method `Node getNext()` should return it,
- the method `Node nextDifferentNode()` should return the next node in the
list whose color differs from the current node's (or null if there is
none),
- the method `int redSum()` should return the sum of all red node's labels
following the current node, including the current node if it is red.

You can assume that lists are acyclic, i.e., no node points to one of its
ancestors. 

**HINT** The classes `RedNode` and `GreenNode` implement interface methods
that are not implemented in the abstract class.

**HINT** It may be easier for you to implement the methods recursively. 
However, they can also be solved by using loops.

Once you have created the hierarchy and implemented the necessary methods,
go into `src/test/java/ex2/NodeTest.java` and uncomment the indicated code
blocks, setting up proper tests.

 ### Part B

Next, we want to check whether a list satisfies certain properties.
We call a list valid if:
- it does not contain two consecutive red nodes, and
- the labels of green nodes are non-decreasing.

Complete the class `HeadNode` so that it extends the class `GreenNode` and implements the interface `IHeadNode`.
In particular, the method `boolean isValid()` should check whether the list is valid, according to the above definition.

Once you have created the hierarchy and implemented the necessary methods, go into `src/test/java/ex2/ValidListTest.java` and uncomment the indicated code blocks, setting up proper tests.
