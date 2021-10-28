package com.ss.ita;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    FileInputStream fileInputStream;
    Properties properties;

    final static Logger logger = Logger.getLogger(PropertiesProvider.class);

    public PropertiesProvider() {
        try {
            this.fileInputStream = new FileInputStream("src/test/resources/data.properties");
            this.properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
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