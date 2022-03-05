package dvduy.javaadvanced.file;

import java.io.Serializable;

public class Student implements Serializable {
    String fullname,address;

    public Student(String fullname, String address) {
        this.fullname = fullname;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFile(){
        return fullname+","+address;
    }
}
