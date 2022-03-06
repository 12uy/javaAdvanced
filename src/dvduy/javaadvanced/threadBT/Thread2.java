package dvduy.javaadvanced.threadBT;

public class Thread2 extends Thread{
    SharedData sharedData;

    public Thread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
            while (sharedData.checkTotal()){
                synchronized (sharedData){
                    sharedData.notifyAll();
                    System.out.println(sharedData.getTotal());
                    while (sharedData.checkTotal()&&sharedData.getThreadIndex()!=2){
                        try {
                            sharedData.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int rd = sharedData.getRandom();
                    if (rd%3==0){
                        rd*=rd;
                        System.out.println("T2>>>Binh phuong: "+rd);
                    }
                    sharedData.setThreadIndex(1);
                }
            }
        System.out.println("T2 stop");

        synchronized (sharedData){
            sharedData.notifyAll();
        }

    }
}
