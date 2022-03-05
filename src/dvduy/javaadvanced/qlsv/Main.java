package dvduy.javaadvanced.qlsv;

import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Integer,Student> studentList = null;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        studentList = new HashMap<>();
        int choose;
        do {
            showMenu();
            choose =Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    addStudent();
                    break;
                case 2:
                    editByID();
                    break;
                case 3:
                    deleteByID();
                    break;
                case 4:
                    sortByGPA();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    showStudent();
                    break;
                case 7:
                    saveFileOBJ();
                    break;
                case 8:
                    readFileOBJ();
                    break;
                case 0:
                    System.out.println("Thoat!!!");
                    break;
                default:
                    System.out.println("Nhap sai");
                    break;
            }
        }while (choose!=8);
    }

    private static void readFileOBJ() {
        FileInputStream fis =null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("student.obj");
            ois = new ObjectInputStream(fis);

            List<Student> studentList = (List<Student>) ois.readObject();

            studentList.forEach(student -> student.display());

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
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void saveFileOBJ() {
        Collection<Student> values = studentList.values();
        List<Student> list = new ArrayList<>(values);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("student.obj");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Ghi file xong!!!");

    }

    private static void showStudent() {
        Iterator<Integer> itr = studentList.keySet().iterator();
        while (itr.hasNext()){
            studentList.get(itr.next()).display();
        }
    }

    private static void sortByName() {
        Set<Map.Entry<Integer,Student>> entrySet = studentList.entrySet();

        Comparator<Map.Entry<Integer,Student>> comparator = new Comparator<Map.Entry<Integer, Student>>() {
            @Override
            public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {
                String name1=o1.getValue().getName();
                String name2 = o2.getValue().getName();
                return name1.compareToIgnoreCase(name2);
            }

        };

        //convert set thanh list
        List<Map.Entry<Integer,Student>> entryList = new ArrayList<>(entrySet);
        Collections.sort(entryList,comparator);
        //tạo 1 LinkedHashMap vì nó duy trì key và value theo thứ tự chèn
        LinkedHashMap<Integer,Student> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,Student> item: entryList){
            sortedMap.put(item.getKey(),item.getValue());
        }
        System.out.println("Danh sach sau khi sap xep");
        Iterator<Integer> itr = sortedMap.keySet().iterator();
        while (itr.hasNext()){
            System.out.println(sortedMap.get(itr.next()));
        }
    }
    //Do dùng hashSet nên không so sanh trực tiếp được nên không sắp xếp được
    private static void sortByGPA() {
        Set<Map.Entry<Integer,Student>> entrySet = studentList.entrySet();

        Comparator<Map.Entry<Integer,Student>> comparator = new Comparator<Map.Entry<Integer, Student>>() {
            @Override
            public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {
                float gpa1 =  o1.getValue().getGpa();
                float gpa2 = o2.getValue().getGpa();
                return gpa1<gpa2?1:-1;
            }

        };

        //convert set thanh list
        List<Map.Entry<Integer,Student>> entryList = new ArrayList<>(entrySet);
        Collections.sort(entryList,comparator);
        //tạo 1 LinkedHashMap vì nó duy trì key và value theo thứ tự chèn
        LinkedHashMap<Integer,Student> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,Student> item: entryList){
            sortedMap.put(item.getKey(),item.getValue());
        }
        System.out.println("Danh sach sau khi sap xep");
        Iterator<Integer> itr = sortedMap.keySet().iterator();
        while (itr.hasNext()){
            System.out.println(sortedMap.get(itr.next()));
        }
    }

    private static void deleteByID() {
        System.out.println("Nhap id sinh vien can xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        if (studentList.containsKey(id)){
            studentList.remove(id);
            System.out.println("Da xoa xong");
        }
        else {
            System.out.println("id khong hop le");
        }
    }

    private static void editByID() {
        System.out.println("Nhap id sinh vien can sua: ");
        int id = Integer.parseInt(sc.nextLine());
        if (studentList.containsKey(id)){
            Student student = new Student();
            student.add();
            studentList.replace(id,student);
            System.out.println("Da sua xong");
        }
        else {
            System.out.println("id khong hop le");
        }

    }

    private static void addStudent() {
        System.out.println("Nhap so luong hoc sinh can them");
        int n = Integer.parseInt(sc.nextLine());
        Student student = null;
        for (int i = 0; i < n; i++) {
            student = new Student();
            student.add();
            studentList.put(student.id,student);
        }
        System.out.println("Nhap xong ");
        System.out.println("+++++++++++++++++++++++++++");
    }

    static void showMenu(){
        System.out.println("***************************************");
        System.out.println("1. Add student.\n" +
                "2. Edit student by id.\n" +
                "3. Delete student by id.\n" +
                "4. Sort student by gpa.\n" +
                "5. Sort student by name.\n" +
                "6. Show student.\n" +
                "7. Lưu thông tin sv vào file student.obj\n" +
                "8. Doc thông tin sv tür file student.obj và hiến thị ra màn hinh\n" +
                "0.Exit.");

    }
}
