package dvduy.javaadvanced.vdthread;

import java.util.Random;

public class Threadrandom extends Thread{
    SharedData sharedData;

    public Threadrandom(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        synchronized (sharedData){
            for (int i = 0; i < 10; i++) {
                Random random = new Random();
                int rd = random.nextInt(100);
                sharedData.setRandom(rd);
                System.out.println("Random: "+rd);
                //wait
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sharedData.notifyAll();
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sharedData.notifyAll();
        }
    }
}
