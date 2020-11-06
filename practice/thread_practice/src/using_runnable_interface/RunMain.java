package using_runnable_interface;

public class RunMain {
    public static void main(String[] args) {

        // Setup Runnable objects
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        MyRunnable r3 = new MyRunnable();
        MyRunnable r4 = new MyRunnable();

        // Create Threads
        Thread t1 = new Thread(r1, "run-1");
        Thread t2 = new Thread(r2, "run-2");
        Thread t3 = new Thread(r3, "run-3");
        Thread t4 = new Thread(r4, "run-4");

        // Start each Thread using Runnable
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish before continuing
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Main ends here");
    }
}
