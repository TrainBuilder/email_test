package com.company;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;


public class Email_read {

    static UserInfo check() {
        String host = "pop.gmail.com";
        String storeType = "pop3";
        String user = "teammoxieRus@gmail.com";
        String password = "mox1e4u5";
        //00/00/0000, email@email.com, 123 drive,2ft57ys7CM97,10

        boolean empty = true;
        UserInfo x1 = new UserInfo();;//user object
        try {
            while (empty) {
                //create properties field
                Properties properties = new Properties();

                properties.put("mail.pop3.host", host);
                properties.put("mail.pop3.port", "995");
                properties.put("mail.pop3.starttls.enable", "true");
                Session emailSession = Session.getDefaultInstance(properties);

                //create the POP3 store object and connect with the pop server
                Store store = emailSession.getStore("pop3s");

                store.connect(host, user, password);

                //create the folder object and open it
                Folder emailFolder = store.getFolder("INBOX");
                emailFolder.open(Folder.READ_ONLY);

                // retrieve the messages from the folder in an array
                Message[] messages = emailFolder.getMessages();
                System.out.println("messages in INBOX: " + messages.length);


                if (messages.length >= 1) empty = false;//new email in inbox; stop loop

                for (int i = 0, n = messages.length; i < n; i++) {//for each message in the inbox
                    Message message = messages[i];
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("From: " + message.getFrom()[0]);
                    String line = getMessageContent(message);//read contents of email, return as string
                    String[] userData = line.split(",");//separate sting by commas
                    if (userData.length == 5) {//five subjects required
                        x1.setDate(userData[0]);
                        x1.setEmail(userData[1]);
                        x1.setAddress(userData[2]);
                        x1.setProduct(userData[3]);
                        x1.setQuantity(userData[4]);//create new user with information from email
                       // x1.print();
                        //00/00/0000, email@email.com, 123 drive,2ft57ys7CM97,10
                    }
                }
                emailFolder.close(false);
                store.close();
                Thread.sleep(5000);//check email every 5 seconds for new
            }

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x1;
    }

    //methode to convert email contents to string
    public static String getMessageContent(Message message) throws MessagingException {
        try {
            Object content = message.getContent();
            if (content instanceof Multipart) {
                StringBuffer messageContent = new StringBuffer();
                Multipart multipart = (Multipart) content;
                for (int i = 0; i < multipart.getCount(); i++) {
                    Part part = multipart.getBodyPart(i);
                    if (part.isMimeType("text/plain")) {
                        messageContent.append(part.getContent().toString());
                    }
                }
                return messageContent.toString();
            }
            return content.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
