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

public class TodaysDate {

    private WebDriver driver;

    @Test
    public void verifyTodayDate(){

        String expectedYear=LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
        WebElement actualYear=driver.findElement(By.xpath("//select[@id='year']//option[@value='"+expectedYear+"']"));
        String expectedMonth= LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM"));
        WebElement actualMonth=driver.findElement(By.xpath("//select[@id='month']//option[text()='"+expectedMonth+"']"));
        String expectedDay=LocalDate.now().format(DateTimeFormatter.ofPattern("dd"));
        WebElement actualDay=driver.findElement(By.xpath("//select[@id='day']//option[text()='"+expectedDay+"']"));

        Assert.assertTrue(actualYear.isSelected());
        Assert.assertTrue(actualMonth.isSelected());
        Assert.assertTrue(actualDay.isSelected());

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
