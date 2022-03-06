package dvduy.javaadvanced.threadBT;

import java.util.Random;

public class Thread1 extends Thread{
    SharedData sharedData;



    public Thread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        synchronized (sharedData){
            System.out.println(sharedData.getTotal());
            while (sharedData.checkTotal()){
                int rd=random.nextInt(100)+1;
                sharedData.setRandom(rd);
                sharedData.plus(rd);
                System.out.println("T1 >>>Random: "+rd);

                if(rd % 3 ==0)
                    sharedData.setThreadIndex(2);
                else
                    sharedData.setThreadIndex(3);

                sharedData.notifyAll();
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //sync thread
            }
        }
        System.out.println("T1 stop");

        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
