package com.automation.tests;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidLinks {

    private WebDriver driver;

    @Test
    public void verifyValidLinks(){
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println(links.size());


        for (WebElement link:links) {
            Assert.assertTrue(link.isEnabled());
        }


    }

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/en/");
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
