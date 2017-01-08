package javaBaseCourse.task4_3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by User on 08.01.2017.
 */
public class Spy implements MailProcessor.MailService {
    private Logger logger;
    private MailProcessor.RealMailService realMailService;

    public Spy(Logger logger) {
        this.logger = logger;
        realMailService = new MailProcessor.RealMailService();
    }

    @Override
    public MailProcessor.Sendable processMail(MailProcessor.Sendable mail) {
        if (mail instanceof MailProcessor.MailMessage) {
            MailProcessor.MailMessage message = (MailProcessor.MailMessage) mail;
            if ("Austin Powers".equals(message.getFrom()) || "Austin Powers".equals(message.getTo())) {
                Object[] args = new Object[]{message.getFrom(), message.getTo(), message.getMessage()};
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"", args);
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{message.getFrom(), message.getTo()});
            }
        }
        return realMailService.processMail(mail);
    }
}
