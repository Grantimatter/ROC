package sync_eg;

public class Pages implements Runnable{

    private String page1;
    private String page2;
    private String page3;

    public Pages(String page1, String page2, String page3) {
        this.page1 = page1;
        this.page2 = page2;
        this.page3 = page3;
        Thread thread = new Thread(this);
        thread.start();
    }

    public Pages(){

    }

    public String getPage1() {
        return page1;
    }

    public void setPage1(String page1) {
        this.page1 = page1;
    }

    public String getPage2() {
        return page2;
    }

    public void setPage2(String page2) {
        this.page2 = page2;
    }

    public String getPage3() {
        return page3;
    }

    public void setPage3(String page3) {
        this.page3 = page3;
    }

    @Override
    public void run() {
        Printer.printPages(this);
    }
}
