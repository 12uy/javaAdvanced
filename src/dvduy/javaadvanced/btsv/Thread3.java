package dvduy.javaadvanced.btsv;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Thread3 extends Thread{
    SharedData sharedData;

    public Thread3(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        FileOutputStream fos = null ;
        try {
            fos = new FileOutputStream("invalid.txt");
            while (sharedData.isAlive()){
                synchronized (sharedData){
                    sharedData.notifyAll();
                    try {
                        while ((sharedData.getCurrentThread() != SharedData.Thread_3) && sharedData.isAlive()){
                            sharedData.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int length = sharedData.getUnvalidRollNumber().size();

                    String rollNo = sharedData.getUnvalidRollNumber().get(length-1);

                    System.out.println("Unvalid roll number: "+ rollNo);

                    //ghi unvalidRollNo vao file

                    rollNo += "\n";
                    byte[] b = rollNo.getBytes();
                    fos.write(b);

                    sharedData.setCurrentThread(SharedData.Thread_1);

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println("T3 die");
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
