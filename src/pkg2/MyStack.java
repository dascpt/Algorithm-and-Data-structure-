package pkg2;

public class MyStack {
	Node head;

	public MyStack() {
	
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public void push(Product data){
		Node newNOde = new Node(data);
		if(head == null){
			head = newNOde;
		}else {
			Node temp = head;
			head = newNOde;
			newNOde.setNextNode(temp);
		}
	}

	public Product pop(){
		Product popped = null;
		if (head == null){
			System.out.println("Stack is Empty");
		}else {
			popped = head.getData();
			head = head.getNextNode();
		}
		return popped;
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
