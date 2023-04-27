import lombok.SneakyThrows;

public class Restroom {

    private boolean isDirty = true;

    @SneakyThrows
    public synchronized void doNumber1() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " knocking the door");
        System.out.println(name + " enter the restroom");

        while (isDirty) {
            waitOutside(name);
            System.out.println(name + " knocking the door");
            System.out.println(name + " enter the restroom");
        }
        System.out.println(name + " doing something fast");

        Thread.sleep(5000);
        this.isDirty = true;

        System.out.println(name + " flushing");
        System.out.println(name + " washing hands");
        System.out.println(name + " leaving the restroom");
    }

    @SneakyThrows
    public synchronized void doNumber2() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " knocking the door");
        System.out.println(name + " enter the restroom");

        while (isDirty) {
            waitOutside(name);
            System.out.println(name + " knocking the door");
            System.out.println(name + " enter the restroom");
        }
        System.out.println(name + " doing something slow");

        Thread.sleep(10000);
        this.isDirty = true;

        System.out.println(name + " flushing");
        System.out.println(name + " washing hands");
        System.out.println(name + " leaving the restroom");
    }

    @SneakyThrows
    public synchronized void doCleaning() {
        String name = Thread.currentThread().getName();

        System.out.println(name + " knocking the door");

        System.out.println(name + " enter the restroom");

        if (!isDirty) {
            System.out.println(name + " its not dirty, im leaving");
            return;
        }
        System.out.println(name + " its really dirty");
        System.out.println(name + " cleaning the restroom");

        Thread.sleep(15000);

        this.notifyAll();
        this.isDirty = false;

        System.out.println(name + " leaving the restroom");
    }

    @SneakyThrows
    private void waitOutside(String name) {
        if (isDirty) {
            System.out.println(name + " ew, its dirty");
            System.out.println(name + " leaving the restroom");
        }
        this.wait();
    }
}
