package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheapSpoons {

//    private WebDriver driver;
//
//    @Test
//    public void test() {
//        driver.get("https://amazon.com");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
//        driver.findElement(By.linkText("Under $25")).click();
//
//        //we collect only dollar values from the price of every item
//        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));
//        //we convert collection of web elements into collection of strings
//        List<String> pricesText = new ArrayList<>();
//        for (WebElement price:prices) {
//            pricesText.add(price.getText());
//        }
//
//        System.out.println(pricesText);
//        for (String price : pricesText) {
//
//            //we convert every price as a string into integer
//            int priceConverted = Integer.parseInt(price);
//
//            //checking if the price of every item is under 25
//            Assert.assertTrue(priceConverted < 25);
//        }
//        driver.quit();
//    }

}
