package logger;

import java.time.LocalDateTime;

public class SimpleLogger implements Logger {

    @Override
    public void log(String msg) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[" + now + "] " + msg);
    }
}
