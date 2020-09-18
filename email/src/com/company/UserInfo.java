package com.company;

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
            System.out.printf("\nQuantity ordered: %s",quantity);
        }

}



