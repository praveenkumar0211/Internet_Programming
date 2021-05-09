package MVCexam.Controller;

import javax.servlet.http.*;

public class SessionCounter implements HttpSessionListener {
    private static int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        System.out.println("\nNew session created");
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        sessionCount--;
    }

    public static int getSessionCount() {
        return sessionCount;
    }

}