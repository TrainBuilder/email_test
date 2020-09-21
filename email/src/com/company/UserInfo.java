package com.company;

import javax.mail.MessagingException;

public class UserInfo {
        String date;
        String email;
        String Address;
        String product;
        String quantity;
        public UserInfo(){}

        void setDate(String dat){
            this.date = dat;
        }
        void setEmail(String mail){
            this.email = mail;
        }
        void setAddress(String Address){
            this.Address = Address;
        }
        void setProduct(String product){
            this.product = product;
        }
        void setQuantity(String quantity){
            this.quantity = quantity;
        }

        void print(){
            System.out.printf("Date: %s",date);
            System.out.printf("\nUser email: %s",email);
            System.out.printf("\nUser address: %s",Address);
            System.out.printf("\nProduct ordered: %s",product);
            System.out.printf("\nQuantity ordered: %s\n",quantity);
        }

        //auto reply methode

        void EmailReply(){
            String cx = "Hi, "+email+"! Thank you for your order of "+quantity+" of "+product +"\nYour order will be shipped to: "+ Address ;
            Email_send.SMTP_setup();
            try {
                Email_send.createEmail(email, "Event driven reply test2", cx);
                Email_send.sendEmail();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

}



