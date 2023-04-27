public class Untitled {

    public static void main(String[] args) {

        Restroom restroom = new Restroom();

        Thread guest1 = new Thread(new Number1(restroom), "lucas");
        Thread guest2 = new Thread(new Number2(restroom), "luana");
        Thread cleaning = new Thread(new CleaningTask(restroom), "cleaning");
        cleaning.setDaemon(true);

        guest1.start();
        guest2.start();
        cleaning.start();

    }
}
