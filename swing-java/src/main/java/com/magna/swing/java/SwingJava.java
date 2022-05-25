package com.magna.swing.java;

import com.magna.swing.java.swing.signup.UserLogin;
import java.net.UnknownHostException;

public class SwingJava {

    public static void main(String[] args) throws InterruptedException, UnknownHostException {
        UserLogin userLogin = new UserLogin();
        
        userLogin.setVisible(true);
    }
}