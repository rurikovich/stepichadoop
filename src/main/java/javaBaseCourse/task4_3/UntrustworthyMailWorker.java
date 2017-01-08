package javaBaseCourse.task4_3;

/**
 * Created by User on 08.01.2017.
 */
public class UntrustworthyMailWorker implements MailProcessor.MailService {

    private MailProcessor.RealMailService realMailService;

    private MailProcessor.MailService[] mailServices;

    public UntrustworthyMailWorker(MailProcessor.MailService[] mailServices) {
        this.mailServices = mailServices;
        realMailService = new MailProcessor.RealMailService();
    }

    @Override
    public MailProcessor.Sendable processMail(MailProcessor.Sendable mail) {
        if (mailServices.length > 0) {
            MailProcessor.Sendable processedMail = mailServices[0].processMail(mail);
            for (int i = 1; i < mailServices.length; i++) {
                processedMail = mailServices[i].processMail(processedMail);
            }
            return getRealMailService().processMail(processedMail);
        }
        return getRealMailService().processMail(mail);
    }


    public MailProcessor.RealMailService getRealMailService() {
        return realMailService;
    }

}
