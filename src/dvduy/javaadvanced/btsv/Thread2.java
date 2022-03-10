package dvduy.javaadvanced.btsv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Thread2 extends Thread{
    SharedData sharedData;

    public Thread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (sharedData.isAlive()){
            synchronized ((sharedData)) {
                sharedData.notifyAll();
                try {
                    while ((sharedData.getCurrentThread() != SharedData.Thread_2) && sharedData.isAlive()){
                        sharedData.wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int length = sharedData.getValidRollNumber().size(); ///Do dai cua ValidRollNumber
                    Student std = sharedData.getValidRollNumber().get(length-1); //lay phan tu cuoi cua ValidRollNumber
                    System.out.println("Welcome student has roll number is : "+std.getStudRollNo());
                    System.out.println("Valid collection has length : "+length);

                    //Ghi file
                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;
                    try {
                        fos= new FileOutputStream(std.getStudRollNo()+".dat");
                        oos = new ObjectOutputStream(fos);

                        oos.writeObject(std);
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
                        if (oos != null){
                            try {
                                oos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                sharedData.setCurrentThread(SharedData.Thread_1);
            }
        }
//        System.out.println("T2 die");
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
