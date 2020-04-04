package com.automation.tests;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MainDepartments {

    private WebDriver driver;

    @Test
    public void verifyDepName(){
        List<WebElement> depNames=driver.findElements(By.tagName("h2"));
        List<WebElement> dropdown=driver.findElements(By.xpath("//select[@name='url']//option"));
        List<String> dropdownInString=new ArrayList<>();
        for (WebElement drop:dropdown) {
            dropdownInString.add(drop.getText());
        }


        for (String each:dropdownInString) {
            Assert.assertTrue(dropdownInString.contains(each));
        }
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/gp/site-directory");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
