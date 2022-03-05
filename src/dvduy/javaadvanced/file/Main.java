package dvduy.javaadvanced.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("A","HN"));
        studentList.add(new Student("B","NA"));

        studentList.add(new Student("C","ND"));

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        String line= null;
        byte[] bytes=null;
        try {
            fos = new FileOutputStream("student.txt");

            for(Student student: studentList){
                line = student.getFile() + "\n";
                bytes = line.getBytes();
                fos.write(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            fos = new FileOutputStream("student.dat");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(studentList);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
