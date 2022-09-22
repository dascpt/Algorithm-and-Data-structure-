package pkg2;

public class MyList {
    public Node head;
    public Node tail;

    public MyList() {
    }

    //kiểm tra chuỗi rỗng
    public boolean isEmpty(){
        return this.head == null;
    }

    //Độ dài chuỗi
    public int length(){
        int length = 0;
        if (this.head == null){
            return length;
        }else{
            Node current = this.head;
            while (current != null){
                length += 1;
                current = current.getNextNode();
            }
            return length;
        }
    }

    //chèn vào đầu danh sách
    public void insertAtHead(Product data){
        Node newInfo = new Node(data);
        newInfo.setNextNode(this.head);
        this.head = newInfo;
    }

    // chen vao cuoi danh sach
    public void insertAtTail(Product data){
        Node  newInfor = new Node(data);
        if(this.head == null) {
            this.head = newInfor;
            this.tail = newInfor;
        }
        if(this.tail != null) {
            this.tail.setNextNode(newInfor);
            this.tail = newInfor;
        }
    }

    //Chèn vào vị trí bất kỳ
    public void ínertAfterPosition(int position, Product item){
        Node curr = this.head;
       if (position < 0){
           return;
       }
       if (position == 0){
           this.insertAtHead(item);
       }
       int i = 0;
       while (i < position && curr != null){
           curr = curr.getNextNode();
       }
       if (i != position - 1){
           return;
       }
       Node newNode = new Node(item);
       newNode.setNextNode(curr.getNextNode());
       curr.setNextNode(newNode);
    }

    //Xóa phần tử cuối danh sách
    public void deleteTail(){
        Node curr = this.head;
        while (curr.getNextNode() != null){
            curr = curr.getNextNode();
        }
        curr.setNextNode(null);
    }
    //Xóa phần tử theo ID
    public void deleteElement(String Id){
        Node curr = this.head;
        Node prev = null;
        //neu phan tu can xoa == head
        if (curr != null && curr.getData().getId().equals(Id)){
            this.head = curr.getNextNode();
            return;
        }
        //tim kiem node co Id trung vs id can xoa
        while (curr != null && !(curr.getData().getId().equals(Id))){
            prev = curr;
            curr = curr.getNextNode();
        }
        //Neu Id can xoa khong cp trong danh sach
        if (curr == null){
            return;
        }
        //xoa lien ket co Id can tim khoi danh sach lien ket
        prev.setNextNode(curr.getNextNode());

    }

    //Hoán đổi firstNode và secondNode
    public void swap(Node firstNode, Node secondNode){
        // fiestNode = secondNode
        if(firstNode == secondNode){
            return;
        }
        //tim kiem firstNode
        Node prevFirst = null;
        Node currFiest = this.head;
        while (currFiest != null && currFiest.getData() != firstNode.getData()){
            prevFirst = currFiest;
            currFiest = currFiest.getNextNode();
        }
        //tim kiem secondNode
        Node prevSecond = null;
        Node currSecond = this.head;
        while (currSecond != null && currSecond.getData() != secondNode.getData()){
            prevSecond = currSecond;
            currSecond = currSecond.getNextNode();
        }
        //firstNode hoac secondNode == null
        if(currFiest == null || currSecond == null){
            return;
        }
        //firstNode != this.head
        if (prevFirst != null){
            prevFirst.setNextNode(currSecond);
        }else {
            this.head = currSecond;
        }
        //secondNode != this.head
        if (prevSecond != null){
            prevSecond.setNextNode(currFiest);
        }else {
            this.head = currFiest;
        }
        //swap
        Node temp = currFiest.getNextNode();
        currFiest.setNextNode(currSecond.getNextNode());
        currSecond.setNextNode(temp);

    }
    //Xóa tất cả dữ liệu trong danh sách
    public void clear(){
        if(this.head == null){
            return;
        }else {
            this.head.setNextNode(null);
            this.head = null;
        }
    }

    public void traverse() {
//		MyList data = new MyList();
        Node curr = this.head;
        String s = "";
        while(curr != null) {
            s += curr.toString() + "\r\n";
            curr = curr.getNextNode();
        }
        System.out.print(s);
    }
}
