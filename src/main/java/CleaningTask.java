import lombok.SneakyThrows;

public class CleaningTask implements Runnable {

    private Restroom restroom;

    public CleaningTask(Restroom restroom) {
        this.restroom = restroom;
    }

    @Override
    @SneakyThrows
    public void run() {

        while (true) {
            restroom.doCleaning();
            Thread.sleep(15000);
        }
    }
}
