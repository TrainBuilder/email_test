package com.company;

public class UserInfo {
        String date;
        String email;
        String Address;
        String product;
        String quantity;
        public UserInfo(String dat, String mail,String Address, String product, String quantity){
            this.date = dat;
            this.email = mail;
            this.Address = Address;
            this.product = product;
            this.quantity = quantity;
        }
        void print(){
            System.out.printf("Date: %s",date);
            System.out.printf("\nUser email: %s",email);
            System.out.printf("\nUser address: %s",Address);
            System.out.printf("\nProduct ordered: %s",product);
            System.out.printf("\nQuantity ordered: %s",quantity);

            //System.out.println(email);
        }

}



