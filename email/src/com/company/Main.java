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
        UserInfo u1 = Email_read.check();
        u1.print();
    }

}


