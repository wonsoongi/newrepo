package ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidListTest {

    private static final IHeadNode l1 = buildList1();
    private static final IHeadNode l2 = buildList2();
    private static final IHeadNode l3 = buildList3();
    private static final IHeadNode l4 = buildList4();
    private static final IHeadNode l5 = buildList5();

    private static IHeadNode buildList1() {
        RedNode n3 = new RedNode(3, null);
        RedNode n2 = new RedNode(1, n3);
        return new HeadNode(1, n2);
    }

    private static IHeadNode buildList2() {
        RedNode n4 = new RedNode(3, null);
        GreenNode n3 = new GreenNode(3, n4);
        RedNode n2 = new RedNode(4, n3);
        return new HeadNode(1, n2);
    }

        private static IHeadNode buildList3() {
            RedNode n4 = new RedNode(3, null);
            GreenNode n3 = new GreenNode(1, n4);
            RedNode n2 = new RedNode(4, n3);
            return new HeadNode(2, n2);
        }

    private static IHeadNode buildList4() {
        RedNode n5 = new RedNode(3, null);
        GreenNode n4 = new GreenNode(3, n5);
        GreenNode n3 = new GreenNode(3, n4);
        RedNode n2 = new RedNode(4, n3);
        return new HeadNode(0, n2);
    }

    private static IHeadNode buildList5() {
        GreenNode n4 = new GreenNode(3, null);
        RedNode n3 = new RedNode(3, n4);
        RedNode n2 = new RedNode(4, n3);
        return new HeadNode(1, n2);
    }

    @Test
    void testIsValid() {
        testIsValid(l1, false);
        testIsValid(l2, true);
        testIsValid(l3, false);
        testIsValid(l4, true);
        testIsValid(l5, false);
    }

    private void testIsValid(IHeadNode head, boolean expected) {
        assertEquals(
                expected,
                head.validList(),
                String.format(
                        "failure of isValid() for list %s",
                        NodeTest.displayList(head)
                ));
    }
}
