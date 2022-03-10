package dvduy.javaadvanced.btsv;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Student implements Serializable {
    String studRollNo;

    public Student(String studRollNo) {
        this.studRollNo = studRollNo;
    }

    public String getStudRollNo() {
        return studRollNo;
    }

    public void setStudRollNo(String studRollNo) {
        this.studRollNo = studRollNo;
    }

    public static boolean checkValidRollNo(String studRollNo){
        String pattern = "[CTN][0-9]{4}[G-M][V]?[0-9]{4}";
        return Pattern.matches(pattern, studRollNo);
    }

}
