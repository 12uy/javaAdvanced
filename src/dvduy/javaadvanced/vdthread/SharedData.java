package dvduy.javaadvanced.vdthread;

public class SharedData {
    int random;

    public SharedData() {
    }

    public SharedData(int random) {
        this.random = random;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }
}
