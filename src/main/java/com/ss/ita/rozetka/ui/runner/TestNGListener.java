package com.ss.ita.rozetka.ui.runner;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Base64;

public class TestNGListener implements ITestListener {
    @Attachment(value = "pageScreenshot", type = "image/png")
    public static byte[] capturePNG() {
        String screenshot = Selenide.screenshot(OutputType.BASE64);
        System.out.println("332423");
        return Base64.getDecoder().decode(screenshot);
    }

    @Override
    public void onTestFailure(ITestResult result){
        capturePNG();
    }
}
