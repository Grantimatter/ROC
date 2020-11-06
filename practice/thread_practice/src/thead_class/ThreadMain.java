package thead_class;

public class ThreadMain {
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        m1.setName("my-1");
        m1.setPriority(8);
        MyThread m2 = new MyThread();
        m2.setName("my-2");
        MyThread m3 = new MyThread();
        m3.setName("my-3");
        MyThread m4 = new MyThread();
        m4.setName("my-4");
        MyThread m5 = new MyThread();
        m5.setName("my-5");

        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
    }
}
