package dvduy.javaadvanced.map;

import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("fullname","Do Van Duy");
        map.put("age",20);
        map.put("address", "Ha Noi");

        // ví dụ quản lý dnah sách sinh viên theo trường rollNo
        HashMap<String ,Student> studentList = new HashMap<>();
        Student std = new Student("R1","4");
        studentList.put(std.getRollNo(),std);
         std = new Student("R2","8");
        studentList.put(std.getRollNo(),std);
         std = new Student("R3","2");
        studentList.put(std.getRollNo(),std);

        Student student = studentList.get("R2");
        System.out.println(student.toString());

         std = new Student("R4","5");
        studentList.put(std.getRollNo(),std);

        //duyệt các phần tử trong map
        Set<String> keys = studentList.keySet();

        keys.forEach(s -> System.out.println("key: "+s+" :"+studentList.get(s)));


    }
}
