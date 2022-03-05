package dvduy.javaadvanced.qlsach;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    String bookName,authorName,publishDate,manufactureName;
    int price;

    public Book() {
    }

    public Book(String bookName, String authorName, String publishDate, String manufactureName, int price) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.manufactureName = manufactureName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", manufactureName='" + manufactureName + '\'' +
                ", price=" + price +
                '}';
    }

    public void display(){
        System.out.println(this);
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten sach: ");
        bookName = sc.nextLine();
        System.out.println("Nhap tac gia: ");
        authorName = sc.nextLine();
        System.out.println("Nhap ngay xuat ban: ");
        publishDate = sc.nextLine();
        System.out.println("Nhap nha xuat ban: ");
        manufactureName = sc.nextLine();

        System.out.println("Nhap gia: ");
        price  = Integer.parseInt(sc.nextLine());
    }
    public String getFormatFile(){
        return bookName+","+authorName+","+publishDate+","+manufactureName+","+price;
    }
}
