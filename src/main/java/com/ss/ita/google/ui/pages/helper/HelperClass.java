package com.ss.ita.google.ui.pages.helper;

import org.openqa.selenium.JavascriptExecutor;

import static com.ss.ita.google.ui.pages.runnerAndProperties.TestRunner.driver;

public class HelperClass {

    public static JavascriptExecutor javascriptExecutor(String whatToDo){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(whatToDo);
        return js;
    }

}
