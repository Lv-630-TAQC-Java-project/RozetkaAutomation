package com.ss.ita.google.ui.pages;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    FileInputStream fileInputStream;
    Properties properties;


    public PropertiesProvider() throws IOException {

            this.fileInputStream = new FileInputStream("src/test/resources/data.properties");
            this.properties = new Properties();
            properties.load(fileInputStream);
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public String getChromeBrowser() {
        return properties.getProperty("chromeWebdriverPath");
    }

    public String getFirefoxBrowser() {
        return properties.getProperty("geckoDriver");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }
}