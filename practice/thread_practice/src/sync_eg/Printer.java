package sync_eg;

public class Printer {

    public static synchronized void printPages(Pages pages){
        System.out.print(pages.getPage1());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println( " " + pages.getPage2());
    }
}
// Thread Safe / Synchronized - The class where all the methods are synchronized

/* Inter thread communication
* wait()
* notify()
* notifyAll()
* Producer-Consumer Problem
 */