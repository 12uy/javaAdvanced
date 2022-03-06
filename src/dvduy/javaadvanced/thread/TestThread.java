package dvduy.javaadvanced.thread;

public class TestThread extends Thread{
    String name;

    public TestThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+">>>>>>>"+i);
        }
    }
}
