package com.automation.tests;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Days {
    private WebDriver driver;

    @Test
    public void randomCheckBox(){
        List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
        List<WebElement> days=driver.findElements(By.xpath("//td//input[@type='checkbox']//following-sibling::label"));
        Random random = new Random();
        int count=0;

        do {
            int index = random.nextInt(checkBoxes.size());
            WebElement checkBox= checkBoxes.get(index);
            if (checkBox.isEnabled()){
                checkBox.click();
            } else {
                continue;
            }
            BrowserUtils.wait(1);
            String dayPrinted=days.get(index).getText();
            System.out.println(dayPrinted);
            if (dayPrinted.equals("Friday")) {
                count++;
            }
            checkBox.click();
            BrowserUtils.wait(1);
        }while (count<3);

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
