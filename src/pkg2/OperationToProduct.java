package pkg2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationToProduct {
	public Scanner input = new Scanner(System.in);
	FileInputStream in = null;
//	FileWriter in = null;
//	FileReader out = null;
	FileOutputStream out = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	public void swap(Product[] arr, int i, int j) {
		Product temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int partition(Product[] arr, int start, int end) {
		//pivot
		Product pivot = arr[end];
		int i = start - 1;
		for(int j = start; j <= end - 1;j++) {
			if(arr[j].getId().compareTo(pivot.getId()) < 0) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, end);
		return i + 1;
	}
	
	public void quickSort(Product[] arr,int start,int end) {
		if(start < end) {
			int pivotValue = partition(arr, start, end);
			quickSort(arr, start, pivotValue - 1);
			quickSort(arr, pivotValue + 1, end);
		}
	}
	
//	public void printArr(int[] arr, int n) {
//		for(int i = 0; i < n; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//	}
	// Tim va tra lai chi so cua san pham trong danh sach.
	// Neu khong tim thay tra ve -1.	
	public int imdex(Product p, MyList list) {
		int index = 0;
		Node curr = list.head;
		while(curr != null) {
			index++;
			curr = curr.getNextNode();
			if(curr.getData().getId().equals(p.getId())) {
				return index;
			}
		}
		return -1;
		
	}
	//	Tao va tra lai mot san pham, thong tin nhap tu ban phim
	public Product createProduct() {
		Product newPro = new Product();
		System.out.print("Nhập Id sản phẩm: ");
		newPro.setId(input.next());
		System.out.print("Nhập tên sản phẩm: ");
		newPro.setTitle(input.next());
		System.out.print("Nhập số lượng sản phẩm: ");
		newPro.setQuantity(input.nextInt());
		System.out.print("Nhập giá sản phẩm: ");
		newPro.setPrice(input.nextDouble());
		return newPro;
	}
	//	Doc tat ca san pham tu tep va chen vao cuoi danh sach
	public void getAllItemsFromFile(String fileName, MyList list) throws IOException {
		boolean completed =true;
		try {
			in = new FileInputStream(fileName);
			ois = new ObjectInputStream(in);
			while (completed){
				Object obj = ois.readObject();
				if (obj != null){
					list.insertAtTail((Product) obj);
				}else {
					break;
				}
			}
			ois.close();
		}catch(EOFException | ClassNotFoundException e){
			completed = false;
		}finally {
			if(in != null) {
				in.close();
			}
		}
	}
	//	Doc tat ca san pham tu tep va chen vao Stack
	public void getAllItemsFromFile(String fileName, MyStack stack) throws IOException {
		boolean completed = true;
		try {
			in = new FileInputStream(fileName);
			ois = new ObjectInputStream(in);
//			ArrayList<Product> arr = new ArrayList<>();
//			int i = 0;
//			Product readPro;
			while(completed) {
//				readPro = (Product) ois.readObject();
//				stack.push(readPro);
				Object obj = ois.readObject();
				if (obj != null){
//					arr.add(i,(Product) obj);
					stack.push((Product) obj);
//					i++;
				}else {
					break;
				}
			}
//			Collections.sort(arr);
//			in.close();
		}catch(EOFException | ClassNotFoundException e) {
			completed = false;
		}finally {
			if(in != null) {
				in.close();
			}
		}
	}
	//	Doc tat ca san pham tu tep va chen vao Queue
	public void getAllItemsFromFile(String fileName, MyQueue queue) throws IOException {
		boolean completed = true;
		try {
			in = new FileInputStream(fileName);
			ois = new ObjectInputStream(in);
//			Product readPro;
			while(completed) {
//				readPro = (Product) ois.readObject();
//				queue.push(readPro);
				Object obj = ois.readObject();
				if (obj != null){
					queue.push((Product) obj);
				}else {
					break;
				}
			}
		}catch(EOFException | ClassNotFoundException e) {
			completed = false;
		}finally {
			if(in != null) {
				in.close();
			}
		}
	}
	// Them mot san pham vao danh sach, 
	// Thong tin cua san pham nhap tu ban phim	
	public void addLast(MyList list) {
		Product newPro = createProduct();
		list.insertAtTail(newPro);
	}
	// In tat ca san pham ra man hinh Console
	public void displayAll(MyList list) {
		Node curr = list.head;
		String s = "";
		while(curr != null) {
			s += curr.toString() + "\r\n";
			curr = curr.getNextNode();
		}
		System.out.print(s);
	}
	// Ghi tat san pham tu danh sach vao tep
	public void writeAllItemsToFile(String fileName, MyList list) throws IOException {
		try {
			out = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(out);
			Node curr = list.head;
			ArrayList<Product> arr =  new ArrayList<>();
			int i = 0;
			while(curr != null) {
				arr.add(i, curr.getData());
				curr = curr.getNextNode();
				i++;
			}
			for (Product pro : arr){
				oos.writeObject(pro);
			}
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(out != null) {
				out.close();
			}
		}
	}
	// Tim kiem san pham theo ID
	public void searchById(MyList list) {
		System.out.print("Nhập Id sản phẩm cần tìm kiếm: ");
		String id = input.next();
		Node curr = list.head;
		ArrayList<Product> arr =  new ArrayList<>();
		int i = 0;
		while(curr != null) {
			arr.add(i, curr.getData());
			curr = curr.getNextNode();
			i++;
		}
		boolean find = false;
		for (Product pro : arr){
			if (pro.Id.equals(id)){
				System.out.println("result: " + pro.toString());
				find = true;
			}
		}
		if (!find){
			System.out.println("ID không tồn tại");
		}
	}
	// Xoa san pham dau tien theo ID nhap tu ban phim
	public void deleteById(MyList list) {
		System.out.print("Nhập Id sản phẩm cần xóa: ");
		String id = input.next();
		list.deleteElement(id);
	}
	// Sap xep danh sach san pham theo Id
	public void sortById(MyList list) {
		Node curr = list.head;
		Product[] arr =  new Product[list.length()];
		int i = 0;
		while(i < list.length()) {
			arr[i] = curr.getData();
			curr = curr.getNextNode();
			i++;
		}
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		list.clear();
		for (Product product : arr) {
			list.insertAtHead(product);
			System.out.println(product.toString());
		}
	}
	// Them san pham vao dau danh sach
	// Thong tin nhap tu ban phim	
	public void addFirst(MyList list) {
		Product newPro = createProduct();
		list.insertAtHead(newPro);
	}
	// Chuyen doi so tu he thap phan san nhi phan
	public void convertToBinary(int i) {
		if(i > 0){
			int number = i % 2;
			System.out.print(number);
			convertToBinary(i/2);
		}
	}
	// Xoa san pham tai vi tri
	public void deleteAtPosition(MyList list, int pos) {
		Node curr = list.head;
		int count = 0;
		while(curr != null && count != pos) {
			curr = curr.getNextNode();
			count++;
		}
		list.deleteElement(curr.getData().getId());
	}
	
//	public void writeAllItemsToFile(String fileName, MyList list) throws IOException {
//		try {
//			out = new FileOutputStream(fileName);
//			oos = new ObjectOutputStream(out);
////			Node curr = list.head;
//			Product pro1 = new Product();
//			pro1.Id = "P03";
//			pro1.title = "Sugar";
//			pro1.quantity = 12;
//			pro1.price = 25.1;
//			oos.writeObject(pro1);
//			Product pro2 = new Product();
//			pro2.Id = "P01";
//			pro2.title = "Miliket";
//			pro2.quantity = 10;
//			pro2.price = 5.2;
//			oos.writeObject(pro2);
//			Product pro3 = new Product();
//			pro3.Id = "P02";
//			pro3.title = "Apple";
//			pro3.quantity = 5;
//			pro3.price = 4.3;
//			oos.writeObject(pro3);
//			Product pro4 = new Product();
//			pro4.Id = "P05";
//			pro4.title = "Rose";
//			pro4.quantity = 7;
//			pro4.price = 15.4;
//			oos.writeObject(pro4);
//			Product pro5 = new Product();
//			pro5.Id = "P07";
//			pro5.title = "Beer";
//			pro5.quantity = 11;
//			pro5.price = 12.2;
//			oos.writeObject(pro5);
//			Product pro6 = new Product();
//			pro6.Id = "P04";
//			pro6.title = "Book";
//			pro6.quantity = 9;
//			pro6.price = 5.2;
//			oos.writeObject(pro6);
//			Product pro7 = new Product();
//			pro7.Id = "3";
//			pro7.title = "3";
//			pro7.quantity = 3;
//			pro7.price = 3;
//			oos.writeObject(pro7);
//			Product pro8 = new Product();
//			pro8.Id = "4";
//			pro8.title = "4";
//			pro8.quantity = 4;
//			pro8.price = 4;
//			oos.writeObject(pro8);
//			out.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(out != null) {
//				out.close();
//			}
//		}
//	}
}
