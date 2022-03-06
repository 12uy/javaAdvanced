package dvduy.javaadvanced.thread;

public class Thread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("t3>>>>>>"+i);
        }
    }
}
