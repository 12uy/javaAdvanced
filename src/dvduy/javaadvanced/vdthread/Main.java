package dvduy.javaadvanced.vdthread;
//Bài tập
//        - T1 > sinh ngău nhiên 1 số ty nhiên từ 1-100
//        - T2 > hiến thi binh phurong ső đã duoc sinh từ T1
//        1. Tao 2 thread thyc hiện yêu câu trên
//        2. Dông bộ luông
//        T1 thrc hiện > rad> T1 đoi T2 > hiên thi binh phuong số rad>
//        in ra màn hình > T2 wait > T1 chąy => vòng tròn nhur trên
//        3. Sinh ngàu nhiên 10 sô => stop 2 luông.
public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Threadrandom threadrandom = new Threadrandom(sharedData);
        ThreadSquare threadSquare = new ThreadSquare(sharedData);

        threadSquare.start();
        threadrandom.start();


    }

}
