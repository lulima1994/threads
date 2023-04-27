
public class Number2 implements Runnable {

    private Restroom restroom;

    public Number2(Restroom restroom) {
        this.restroom = restroom;
    }

    @Override
    public void run() {
        restroom.doNumber2();
    }
}
