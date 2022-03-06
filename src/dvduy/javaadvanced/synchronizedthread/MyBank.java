package dvduy.javaadvanced.synchronizedthread;
//Ví dụ: chạy nhiều luồng cùng thực hiện một câu lệnh
public class MyBank {
    int money;

    public MyBank(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public synchronized void rutTien(int money,String name){
        if (money<=this.money){
            System.out.println("so tien da rut "+ money+ "Thread: "+name);
            this.money-=money;
        }
        else
            System.out.println("So du khong du   Thread "+name);
        System.out.println("so tien con lai: "+this.money);
    }
}
