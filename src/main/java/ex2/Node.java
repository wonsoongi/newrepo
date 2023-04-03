package ex2;

public interface Node {

    Node getNext();
    int getLabel();
    Node nextDifferentNode();
    int redSum();
}
