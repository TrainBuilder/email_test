package com.company;

import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args) {


            //test data
        /*String email = "cmh.howard1@gmail.com";
        String quantity = "20";
        String product = "dfghsrfgjdfgj";
        String Address = "123 mulberry lane";*/

        UserInfo u1 = Email_read.check();//creates new user
        u1.print();


     // email reply methode
        /*
       Email_send.SMTP_setup();
       u1.EmailReply();

       try {
        Email_send.createEmail(email, "Event driven reply test2", "test3");
        Email_send.sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }*/
    }

}


