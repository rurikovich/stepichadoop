package javaBaseCourse.task4_3;

/**
 * Created by User on 08.01.2017.
 */
public class Inspector  implements MailProcessor.MailService {

    private MailProcessor.RealMailService realMailService;

    public Inspector() {
        realMailService = new MailProcessor.RealMailService();
    }

    @Override
    public MailProcessor.Sendable processMail(MailProcessor.Sendable mail) {
        if(mail instanceof MailProcessor.MailPackage){
            MailProcessor.MailPackage mailPackage=(MailProcessor.MailPackage)mail;
            String content = mailPackage.getContent().getContent();
            if(content.contains("weapons") || content.contains("banned substance")){
                throw  new IllegalPackageException();
            }
            if(content.contains("stones")){
                throw  new StolenPackageException();
            }
        }
        return realMailService.processMail(mail);
    }
}
