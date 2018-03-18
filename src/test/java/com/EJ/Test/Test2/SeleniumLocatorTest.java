package com.EJ.Test.Test2;

import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLocatorTest {
    public  WebDriver driver;

    public void test() {
        driver = getDriver();

        //a.The title text
        WebElement elementTitle = driver.findElement(By.id("ttl"));
        String title= elementTitle.getText();
        System.out.println("Title is "+title);

        //b. The link to the google site
        WebElement linkElement = driver.findElement(By.linkText("google"));
        String hrefValue=linkElement.getAttribute("href");
        System.out.println(" Link to Google site is is "+hrefValue);
        driver.quit();
    }


    private WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\AutomationProjects\\Drivers\\geckodriver.exe");
        WebDriver localdriver = new FirefoxDriver();
        return localdriver;
    }
}
