package dvduy.javaadvanced.qlsv;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    String name,address;
    int age,id;
    float gpa;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }

    public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id: ");
        id=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap name: ");
        name=sc.nextLine();
        System.out.println("Nhap address: ");
        address= sc.nextLine();
        System.out.println("Nhap age: ");
        age=Integer.parseInt(sc.nextLine());
        System.out.println("Nhap gpa: ");
        gpa=Float.parseFloat(sc.nextLine());
    }

    public void display(){
        System.out.println(this);
    }
}
