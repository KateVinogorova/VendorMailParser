package com.vinogorova.mailparser;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailReader {


    public void readEmails() throws IOException, MessagingException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/config.properties"));

        Session session = Session.getInstance(props);
        Store store = session.getStore(props.getProperty("mail.store.protocol"));
        store.connect(props.getProperty("mail.imap.host"),
                Integer.parseInt(props.getProperty("mail.imap.port")),
                props.getProperty("mail.user"),
                props.getProperty("mail.password"));
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        for (Message m : messages) {
            if (m.getFrom()[0].toString().contains("katarina_1710@mail.ru")) {
                Multipart multipart = (Multipart) m.getContent();
                for (int i = 0; i < multipart.getCount(); i++) {
                    MimeBodyPart bp = (MimeBodyPart) multipart.getBodyPart(i);
                    if (Part.ATTACHMENT.equalsIgnoreCase(bp.getDisposition())) {
                        String fileName = bp.getFileName();
                        if (fileName.endsWith(".csv")) {
                            bp.saveFile("storage/" + fileName);
                        }
                    }
                }
            }
            System.out.println(m.getSubject());
        }
        inbox.close();
        store.close();
    }
}
