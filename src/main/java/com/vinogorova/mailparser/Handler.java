package com.vinogorova.mailparser;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

public class Handler {
    private static final File DIR = new File("src/main/resources/10953.csv");

    public static void main(String[] args) {

        new MyCSVParser().parseToList(DIR);
        MailReader mailReader = new MailReader();
        try {
            mailReader.readEmails();
        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
    }
}
