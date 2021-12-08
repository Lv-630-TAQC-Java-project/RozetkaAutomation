package com.ss.ita.rozetka;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CredentialProperties {
    FileInputStream fis;
    Properties prop;

    public CredentialProperties() {
        try {
            this.fis = new FileInputStream("src/test/resources/credential.properties");
            this.prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFacebookEmail() { return prop.getProperty("facebook_email"); }
    public String getFacebookPassword() { return prop.getProperty("facebook_password"); }
}
