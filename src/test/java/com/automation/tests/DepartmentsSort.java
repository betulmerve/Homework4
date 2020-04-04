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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsSort {

    private WebDriver driver;

    @Test
    public void verifyDefaultValue(){
        WebElement displayed=driver.findElement(By.xpath("//select//option[@selected='selected']"));
        String actual=displayed.getText();
        String expected="All";
        Assert.assertTrue(actual.startsWith(expected));
    }

    @Test
    public void verifyDepNotSorted(){
        List<WebElement> departments=driver.findElements(By.tagName("option"));
        List<String > depInString=new ArrayList<>();

        for (WebElement department:departments) {
            depInString.add(department.getText());
        }

        for (int i = 0; i < depInString.size() - 1; i++) {
            String first=depInString.get(i);
            System.out.println(first);
            String second=depInString.get(i+1);
            System.out.println(second);

            Assert.assertTrue(first.compareTo(second)>=0);

        }
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
