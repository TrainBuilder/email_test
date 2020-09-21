package com.company;

import javax.mail.MessagingException;

public class Main {

                /////Email credentials
    public static void main(String[] args) {
        try{
        String email = "cmh.howard1@gmail.com";
        String quantity = "20";
        String product = "dfghsrfgjdfgj";
        String Address = "123 mulberry lane";

        // UserInfo u1 =
        Email_read.check();
        Thread.sleep(100000);
        UserInfo u1 = new UserInfo();
        u1.setDate("09/21/2020");
        u1.setEmail("chowar37@msudenver.edu");
        u1.setAddress("123 Mulberry Dr");
        u1.setProduct("2FT57YS7CM97");
        u1.setQuantity("20");

        u1.print();
       Email_send.SMTP_setup();
        //u1.EmailReply();


       try {
        Email_send.createEmail(email, "Event driven reply test2", "test3");
        Email_send.sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

}


