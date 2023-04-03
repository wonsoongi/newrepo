package ex2;

public class HeadNode extends GreenNode implements IHeadNode{

    public HeadNode(int label, Node next) {
        super(label, next);
        //TODO Auto-generated constructor stub
    }


    @Override
    public boolean validList() {
        Node currentNode = getNext();
        Node nextNode = currentNode.getNext();
            if (currentNode instanceof RedNode && nextNode instanceof RedNode) {
                return false;
            }
            
            else if (currentNode instanceof GreenNode) {
                while (nextNode.getNext() != null && !(nextNode instanceof GreenNode)) {
                    nextNode = nextNode.getNext();
                }
                if (nextNode != null && currentNode.getLabel() > nextNode.getLabel()) {
                    return false;
                }
            }
        return true;
        }   
}
