package com.company;
//test

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import java.io.IOException;
import javax.mail.Multipart;
import javax.mail.Part;



public class Main {
                /////Email credentials
    public static void main(String[] args) {
        String host = "pop.gmail.com";
        String mailStoreType = "pop3";
        String username = "teammoxieRus@gmail.com";
        String password = "mox1e4u5";
        check(host, mailStoreType, username, password);
    }
    //methode to connect to email server, read and store emails
    public static void check(String host, String storeType, String user, String password) {
        boolean empty = true;
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
                UserInfo x1;//user object
                for (int i = 0, n = messages.length; i < n; i++) {//for each message in the inbox
                    Message message = messages[i];
                    System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("From: " + message.getFrom()[0]);
                    String line = getMessageContent(message);//read contents of email, return as string
                    String[] userData = line.split(",");//separate sting by commas
                    if (userData.length == 5) {//five subjects required
                        x1 = new UserInfo(userData[0],userData[1],userData[2],userData[3],userData[4]);//create new user with information from email
                        x1.print();
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


