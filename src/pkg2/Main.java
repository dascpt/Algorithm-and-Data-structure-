package pkg2;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static MyList list = new MyList();
    public static void main(String[] args) throws IOException {
    	OperationToProduct syntax = new OperationToProduct();
//        Product newPro2 = new Product("P07", "Suger", 12, 15.01);
//        Product newPro3 = new Product("P05", "Suger", 12, 15.01);
//        Product newPro4 = new Product("P04", "Suger", 12, 15.01);
//
//        list.insertAtTail(newPro2);
//        list.insertAtTail(newPro3);
//        list.insertAtTail(newPro4);
//        list.traverse();
        Scanner input = new Scanner(System.in);
        System.out.println("*****Menu*****");
        showMenu();
        int choice;
        // lựa chọn chức năng
        do {
            System.out.print("Choose one of this options (0-10): ");
            choice = input.nextInt();
            switch (choice){
                // đọc dữ liệu từ file và chèn vào cuối liên kết
                case 1 -> {
                    System.out.println("1. Load data from file and display.");
                    syntax.getAllItemsFromFile("data.txt", list);
                    System.out.println("Successfully!");
                }
                // thêm sản phẩm mới
                case 2 -> {
                    System.out.println("2. Input & add to the end.");
                    Product newPro = syntax.createProduct();
                    System.out.println(newPro.toString());
                    list.insertAtTail(newPro);
                }
                // hiển thị danh sách sản phẩm
                case 3 -> {
                    System.out.println("3.Display data");
                    if (!(list.isEmpty())){
                        syntax.displayAll(list);
                    }
                }
                // lưu tất cả sản phẩm vào tệp 'data.txt'
                case 4 -> {
                    System.out.println("4.Save product list to file.");
                    syntax.writeAllItemsToFile("data.txt", list);
                    System.out.println("Successfully!");
                }
                // tìm kiếm sản phẩm theo ID
                case 5 -> {
                    System.out.println("5. Search by ID.");
                    syntax.searchById(list);
                }
                // xóa sản phẩm theo ID
                case 6 -> {
                    System.out.println("6.Delete by ID.");
                    syntax.deleteById(list);
                    System.out.println("Deleted!");
                }
                // sắp xếp danh sách sản phẩm theo ID( dùng quickSort)
                case 7 -> {
                    System.out.println("7.Sort by ID.");
                    syntax.sortById(list);
//                    syntax.writeAllItemsToFile("data.txt", list);
                    System.out.println("Successfully!");

                }
                // chuyển số lượng sản phẩm bất kỳ sang nhị phân
                case 8 -> {
                    System.out.println("8. Convert to Binary.");
                    System.out.print("Quantity: ");
                    syntax.convertToBinary(input.nextInt());
                    System.out.println();
                }
                // đọc dữ liệu từ tệp 'data.txt' và lưu vào Stack
                // hiển thị danh sách sản phẩm
                case 9 -> {
                    System.out.println("9. Load to stack and display.");
                    MyStack stack = new MyStack();
                    syntax.getAllItemsFromFile("data.txt", stack);
                    System.out.println(stack.toString());
                }
                // đọc dữ liệu từ tệp 'data.txt' và lưu vào Queue
                // hiển thị danh sách sản phẩm
                case 10 -> {
                    System.out.println("10. Load to queue and display.");
                    MyQueue queue = new MyQueue();
                    syntax.getAllItemsFromFile("data.txt", queue);
                    System.out.println(queue.toString());

                }
                case 0 -> System.out.println("0.Exit");
            }

        }while (choice != 0);

    }
    // danh sách các chức năng yêu cầu
    public static void showMenu(){
        System.out.println("1. Load data from file and display.");
        System.out.println("2. Input & add to the end.");
        System.out.println("3.Display data");
        System.out.println("4.Save product list to file.");
        System.out.println("5. Search by ID.");
        System.out.println("6.Delete by ID.");
        System.out.println("7.Sort by ID.");
        System.out.println("8. Convert to Binary.");
        System.out.println("9. Load to stack and display.");
        System.out.println("10. Load to queue and display.");
        System.out.println("0.Exit");

    }
}

