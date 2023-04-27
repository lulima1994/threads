
public class Number1 implements Runnable {

    private Restroom restroom;

    public Number1(Restroom restroom) {
        this.restroom = restroom;
    }

    @Override
    public void run() {
        restroom.doNumber1();
    }
}
