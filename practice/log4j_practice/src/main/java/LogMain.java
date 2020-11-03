import com.app.Service;
import org.apache.log4j.Logger;

public class LogMain {
    private static Logger log=Logger.getLogger(LogMain.class);

    public static void main(String[] args) {
        log.trace("Hello from TRACE");
        log.debug("Hello from DEBUG");
        log.info("Hello from INFO");
        log.warn("Hello from WARN");
        log.error("Hello from ERROR");
        log.fatal("Hello from FATAL");

        Service service = new Service();
        service.test("TESTING");
    }
}