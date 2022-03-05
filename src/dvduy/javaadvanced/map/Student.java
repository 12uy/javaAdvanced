package dvduy.javaadvanced.map;

public class Student {
    String rollNo,fullName;

    public Student(String rollNo, String fullName) {
        this.rollNo = rollNo;
        this.fullName = fullName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
