package dvduy.javaadvanced.synchronizedthread;

public class RutTienThread extends Thread{
    MyBank myBank ;
    String nameThread;

    public RutTienThread(MyBank myBank,String nameThread) {
        this.myBank = myBank;
        this.nameThread = nameThread;
    }



    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            myBank.rutTien(100,nameThread);
        }
    }
}
