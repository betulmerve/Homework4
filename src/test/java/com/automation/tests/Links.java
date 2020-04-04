package com.automation.tests;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Links {

    private WebDriver driver;

    @Test
    public void verifyLink(){
        List<WebElement> links=driver.findElements(By.tagName("a"));


        for (WebElement link:links) {
            if (link.isDisplayed()) {
                System.out.println(link.getText());
                System.out.println(link.getAttribute("href"));

            }
        }


    }

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
