package dvduy.javaadvanced.qlsach;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static List<Book> bookList;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        bookList = new ArrayList<>();
        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    input();
                    break;
                case 2:
                    display();
                    break;
                case  3:
                    sortByAuthorName();
                    break;
                case  4:
                    saveFileOBJ();
                    break;
                case  5:
                    saveFileTXT();
                    
                    break;
                case 6:
                    readFile();
                    break;
                case 7:
                    System.out.println("Thoat!!!!!!");
                    break;
                default:
                    System.out.println("Nhap sai!!");
                    break;

            }

        }while (choose!=7);

    }

    private static void readFile() {
        FileInputStream fis=null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("data.obj");
            ois = new ObjectInputStream(fis);

            List<Book> dataList = (List<Book>) ois.readObject();

            dataList.forEach(book -> book.display());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void saveFileTXT() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("data.txt");

            for (Book book:bookList){
                String line = book.getFormatFile() +"\n";
                byte[] data = line.getBytes(StandardCharsets.UTF_8);

                fos.write(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void saveFileOBJ() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos= new FileOutputStream("data.obj");

            oos = new ObjectOutputStream(fos);

            oos.writeObject(bookList);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void display() {
        System.out.println("++++Hien thi thong tin sach+++");
        bookList.forEach(book -> book.display());
    }

    private static void input() {
        System.out.println("So luong sach can nhap");
        int n = Integer.parseInt(sc.nextLine());
        Book book = null;
        for (int i = 0; i < n; i++) {
            book = new Book();
            book.input();
            bookList.add(book);
        }
        System.out.println("nhap xong "+n+" quyen sach:");
    }

    private static void sortByAuthorName() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthorName().compareToIgnoreCase(o2.getAuthorName());
            }
        });
        display();
    }

    static void showMenu(){
        System.out.println("1. Nhap thong tin n cuon sach");
        System.out.println("2. Hien thong tin sach");
        System.out.println("3. Sap xep theo ten tac gia");
        System.out.println("4. Luu thong tin sach vào file data.obj");
        System.out.println("5. Luu thong tin moi quyen sach vao file data.txt");
        System.out.println("6. Doc du lieu data.obj!!");
        System.out.println("7. Thoat!!");
        System.out.println("Moi chon");
    }
}
