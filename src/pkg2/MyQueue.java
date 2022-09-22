package pkg2;

public class MyQueue {
	Node head;
	Node tail;
	
	public MyQueue() {
		
	}

	public void push(Product data){
		Node newNode = new Node(data);
		if(tail == null){
			head = newNode;
			tail = newNode;
		} else {
			tail.setNextNode(newNode);
			tail = newNode;
		}
	}

	public Product pop(){
		if (head == null){
			System.out.println("Queue isEmpty");
		}
		Product temp = this.head.getData();
		head = head.getNextNode();
		if (this.head == null){
			this.tail = null;
		}


		return temp;
	}
	@Override
	public String toString() {
		String result = "";
		Node curr = head;
		while (curr != null){
			result += curr.toString();
			curr = curr.getNextNode();
		}
		return result;
	}
}
