package pkg2;

public class Node {
    public Product data;
    public Node nextNode;
//    public Node preNode;


    public Node(Product data) {
        this.data = data;
    }

    public Node() {

    }

//    public void setData(Product data) {
//        this.data = data;
//    }

    public Product getData() {
        return data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

	@Override
	public String toString() {
		return " " + this.data + "\r\n";
	}

    
}
