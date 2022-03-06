package dvduy.javaadvanced.threadBT;

public class Thread3 extends Thread{
    SharedData sharedData;

    public Thread3(SharedData sharedData) {
        this.sharedData = sharedData;
    }



    @Override
    public void run() {
        while (sharedData.checkTotal()){
            System.out.println(sharedData.getTotal());
            synchronized (sharedData){
                sharedData.notifyAll();
                while (sharedData.checkTotal()&&sharedData.getThreadIndex()!=3){
                    try {
                        sharedData.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int rd=sharedData.getRandom();
                if (rd%2==0){
                    if(rd%4==0){
                        System.out.println("T3>>>chia het cho 4");
                    }
                    else
                        System.out.println("T3>>>Khong chia het cho 4");
                }
                else
                    System.out.println("T3>>>Khong le");
                sharedData.setThreadIndex(1);
            }
        }
        System.out.println("T3 stop");
        synchronized (sharedData){
            sharedData.notifyAll();
        }
    }
}
