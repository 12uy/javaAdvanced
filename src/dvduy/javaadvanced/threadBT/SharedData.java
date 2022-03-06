package dvduy.javaadvanced.threadBT;

public class SharedData {
    int random;
    int total=0;
    int threadIndex=1;

    public int getThreadIndex() {
        return threadIndex;
    }

    public void setThreadIndex(int threadIndex) {
        this.threadIndex = threadIndex;
    }

    public SharedData() {
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public synchronized void plus(int value){
        total+=value;
    }

    public synchronized boolean checkTotal(){
        if (total<200)
            return true;
        return false;
    }
}
