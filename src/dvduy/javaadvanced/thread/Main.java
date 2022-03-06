package dvduy.javaadvanced.thread;

public class Main {
    public static void main(String[] args) {
        //main laf 1 thread main duoc khoi tao khi goi
        //Cac cach khai bao
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t1 >>>"+i);
                }
            }
        });
        t1.start();

        // taji thoi diem nay cos 2 luong la t1 va main
        ///Cach 2
        Thread t2 = new TestThread("t2");
        t2.start();

        //Cach 3
        Thread3 thread3 = new Thread3();
        Thread t3 = new Thread(thread3);

        t3.start();
    }
}
