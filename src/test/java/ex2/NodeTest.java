package ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NodeTest {

    private static final Node l1 = buildList1();
    private static final Node l2 = buildList2();
    private static final Node l3 = buildList3();
    private static final Node l4 = buildList4();

    private static Node buildList1() {
        RedNode n3 = new RedNode(3, null);
        RedNode n2 = new RedNode(1, n3);
        return new GreenNode(1, n2);
    }

    private static Node buildList2() {
        RedNode n4 = new RedNode(3, null);
        GreenNode n3 = new GreenNode(3, n4);
        RedNode n2 = new RedNode(4, n3);
        return new GreenNode(1, n2);
    }

    private static Node buildList3() {
        GreenNode n3 = new GreenNode(3, null);
        RedNode n2 = new RedNode(1, n3);
        return new RedNode(2, n2);
    }

    private static Node buildList4() {
        RedNode n5 = new RedNode(3, null);
        GreenNode n4 = new GreenNode(2, n5);
        GreenNode n3 = new GreenNode(1, n4);
        GreenNode n2 = new GreenNode(2, n3);
        return new RedNode(1, n2);
    }


    @Test
    void testRedSum() {
        Node n = l1;
        int index = 1;
        testRedSum(l1, n, index, 4);
        n = n.getNext();
        index++;
        testRedSum(l1, n, index, 4);
        n = n.getNext();
        index++;
        testRedSum(l1, n, index, 3);

        n = l2;
        index = 1;
        testRedSum(l2, n, index, 7);
        n = n.getNext();
        index++;
        testRedSum(l2, n, index, 7);
        n = n.getNext();
        index++;
        testRedSum(l2, n, index, 3);
        n = n.getNext();
        index++;
        testRedSum(l2, n, index, 3);

        n = l3;
        index = 1;
        testRedSum(l3, n, index, 3);
        n = n.getNext();
        index++;
        testRedSum(l2, n, index, 1);
        n = n.getNext();
        index++;
        testRedSum(l2, n, index, 0);

        n = l4;
        index = 1;
        testRedSum(l4, n, index, 4);
        n = n.getNext();
        index++;
        testRedSum(l4, n, index, 3);
        n = n.getNext();
        index++;
        testRedSum(l4, n, index, 3);
        n = n.getNext();
        index++;
        testRedSum(l4, n, index, 3);
        n = n.getNext();
        index++;
        testRedSum(l4, n, index, 3);

    }

    @Test
    void testNextDifferent() {
        Node n = l1;
        int index = 1;
        testNextDifferent(l1, n, index, n.getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l1, n, index, null);
        n = n.getNext();
        index++;
        testNextDifferent(l1, n, index, null);

        n = l2;
        index = 1;
        testNextDifferent(l1, n, index, n.getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l2, n, index, n.getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l2, n, index, n.getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l2, n, index, null);

        n = l3;
        index = 1;
        testNextDifferent(l3, n, index, n.getNext().getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l3, n, index, n.getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l3, n, index, null);

        n = l4;
        index = 1;
        testNextDifferent(l4, n, index, n.getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l4, n, index, n.getNext().getNext().getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l4, n, index, n.getNext().getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l4, n, index, n.getNext());
        n = n.getNext();
        index++;
        testNextDifferent(l4, n, index, null);
    }

    private void testRedSum(Node list, Node node, int nodeIndex, int expectedValue) {
        assertEquals(
                expectedValue,
                node.redSum(),
                String.format(
                        "redSum() failed for the node at position %d (starting with index 1) in list\n %s",
                        nodeIndex,
                        displayList(list)
                ));
    }

    private void testNextDifferent(Node list, Node node, int nodeIndex, Node expected) {
        assertEquals(
                expected,
                node.nextDifferentNode(),
                String.format(
                        "nexDifferent() failed for the node at position %d (starting with index 1) in list\n %s",
                        nodeIndex,
                        displayList(list)
                ));
    }

    static String displayList(Node list) {
        if (list == null) {
            return "|";
        }
        return String.format("|%s:%s%s",
                list.getClass().equals(RedNode.class) ? "Red" : "Green",
                list.getLabel(),
                displayList(list.getNext())
        );
    }
     
}
