package dvduy.javaadvanced.vdthread;

public class ThreadSquare extends Thread{
    SharedData sharedData;

    public ThreadSquare(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        synchronized (sharedData){

            for (int i = 0; i < 10; i++) {
                sharedData.notifyAll();

                int rd = sharedData.getRandom();
                rd*=rd;
                System.out.println("BP "+ rd);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
