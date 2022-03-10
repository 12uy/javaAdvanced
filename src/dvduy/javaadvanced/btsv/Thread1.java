package dvduy.javaadvanced.btsv;

import java.io.*;

public class Thread1 extends Thread{
    //Đọc file students
    SharedData sharedData;

    public Thread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("students.txt");
            br = new BufferedReader(fr);
            String line = null;

            while (sharedData.isAlive()){

                //synchronized lay du lieu o day
                synchronized (sharedData){
                    line = br.readLine();
                    if (line == null){
                        sharedData.setAlive(false);
                        break;
                    }

                    boolean isValid = Student.checkValidRollNo(line);
                    if (isValid){
                        Student std = new Student(line);
                        sharedData.getValidRollNumber().add(std);
                        sharedData.setCurrentThread(SharedData.Thread_2);
                    }
                    else {
                        sharedData.getUnvalidRollNumber().add(line);
                        sharedData.setCurrentThread(SharedData.Thread_3);
                    }
                    sharedData.notifyAll();
                    sharedData.wait();
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("T1 die");
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
