package dvduy.javaadvanced.qldc;

public class Thread1  extends Thread{
    SharedData sharedData;

    public Thread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < sharedData.nameList.length; i++) {
            synchronized (sharedData){
                sharedData.notifyAll();

                try {
                    sharedData.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Name: "+ sharedData.nameList[i]);
            }
        }
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
