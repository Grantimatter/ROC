package thead_class;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Printing from " + Thread.currentThread().getName() + " Value of i = " + i);
            try{
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
