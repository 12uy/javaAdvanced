package dvduy.javaadvanced.synchronizedthread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyBank myBank = new MyBank(1000);
        List<RutTienThread> rutTienThreadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rutTienThreadList.add(new RutTienThread(myBank,"T"+i));
        }

        for (RutTienThread rutTienThread:rutTienThreadList){
            rutTienThread.start();
        }
    }

}
