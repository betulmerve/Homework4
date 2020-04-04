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


import java.util.List;
import java.util.Random;


public class YearsMonthsDays {
    private WebDriver driver;


    @Test
    public void randomCheckBox(){

        List<WebElement> years=driver.findElements(By.xpath("//select[@id='year']//option"));
        Random random=new Random();
        int index=random.nextInt(years.size());

        years.get(index).click();
        BrowserUtils.wait(2);

        boolean leapYear=false;
        int yearSelected= Integer.parseInt(years.get(index).getAttribute("value"));

        if (yearSelected%4==0 && yearSelected%100!=0 || yearSelected%400==0) {
            leapYear=true;
        }


        for (int i = 0; i < 12; i++) {

            driver.findElement(By.xpath("//select[@id='month']//option[@value='"+i+"']")).click();
            //BrowserUtils.wait(2);
            List<WebElement> days=driver.findElements(By.xpath("//select[@id='day']//option"));
            if (i==0 || i==2 || i==4 || i==6 || i==7 || i==9 || i==11) {
                Assert.assertTrue(days.size()==31);
            } else if (i==1 && leapYear==false) {
                Assert.assertTrue(days.size()==28);
            } else if (i==1 && leapYear==true) {
                Assert.assertTrue(days.size()==29);
            } else {
                Assert.assertTrue(days.size()==30);
            }

        }

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
