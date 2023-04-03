package ex2;

public abstract class AbstractNode implements Node{

    protected final Node next;
    protected final int label;

    public AbstractNode(int label, Node next) {
        this.label = label;
        this.next = next;
    }

    public int getLabel(){
        return label;
    }

    public Node getNext(){
        return next;
    }
    
    public Node nextDifferentNode(){
        Node currentNode = getNext(); 
        while (currentNode != null){
            Node prevNode = currentNode;
            if (prevNode.getClass() != getClass()){
                return prevNode;
            }
            currentNode = prevNode.getNext();
        }
             return null;
    }

    public int redSum() {
        int sum = 0;
        Node currentNode = this;
        while (currentNode != null) {
            if (currentNode instanceof RedNode) {
                sum += currentNode.getLabel();
            }
            currentNode = currentNode.getNext();
        }
        return sum;
    }
}

