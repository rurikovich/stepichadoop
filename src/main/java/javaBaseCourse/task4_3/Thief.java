package javaBaseCourse.task4_3;

import static javaBaseCourse.task4_3.MailProcessor.*;

/**
 * Created by User on 08.01.2017.
 */
public class Thief implements MailService {
    private RealMailService realMailService;
    private int minPrice;
    private int sum;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
        realMailService = new RealMailService();
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage aPackage = (MailPackage) mail;
            int price = aPackage.getContent().getPrice();
            if (price >= minPrice) {
                sum += price;
                String parcel = "stones instead of "+((MailPackage) mail).getContent().getContent();
                MailProcessor.Package newPackage = new MailProcessor.Package(parcel, 0);
                MailPackage newMailPackage = new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
                return newMailPackage;
            }
            return realMailService.processMail(mail);
        }
        return realMailService.processMail(mail);
    }

    public int getStolenValue() {
        return sum;
    }
}
