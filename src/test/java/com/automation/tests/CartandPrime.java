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
import java.util.Random;

public class CartandPrime {

    private WebDriver driver;

    @Test
    public void verifyDepName(){

        List<WebElement> results=driver.findElements(By.xpath("//div[@class='a-section a-spacing-medium']"));
        Random random=new Random();
        int index=random.nextInt(results.size());
        System.out.println(index);

        String xpath_forItems= "(//div[@class='a-section a-spacing-medium'])"+"["+index+"]";
        String xpath_forItems_price ="(//div[@class='a-section a-spacing-medium'])["+index+"]//span[@class='a-price-whole']";
        String xpath_forItems_price2 ="(//div[@class='a-section a-spacing-medium'])["+index+"]//span[@class='a-price-fraction']";
        String xpath_forItems_name ="(//div[@class='a-section a-spacing-medium'])["+index+"]//span[@class='a-size-base-plus a-color-base a-text-normal']";
        String priceOfRandomItem =driver.findElement(By.xpath(xpath_forItems_price)).getText()+"."+driver.findElement(By.xpath(xpath_forItems_price2)).getText();
        String nameOfRandomItem =driver.findElement(By.xpath(xpath_forItems_name)).getText();
        System.out.println(priceOfRandomItem);
        System.out.println(nameOfRandomItem);

        WebElement randomItem=driver.findElement(By.xpath(xpath_forItems));
        randomItem.click();
        BrowserUtils.wait(2);

        WebElement quantity=driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']//span[@class='a-dropdown-prompt']"));
        System.out.println(quantity.getText());

        Assert.assertEquals(quantity.getText(),"1");

        String title7=driver.findElement(By.id("productTitle")).getText();
        System.out.println(title7);
        String price7=driver.findElement(By.xpath("//span[contains(@id,'priceblock')]")).getText();
        System.out.println(price7);
        Assert.assertEquals(nameOfRandomItem,title7);
        Assert.assertTrue(price7.contains(priceOfRandomItem));

        //add to cart is visible
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());

    }

    @Test
    public void verifyPrime(){

    }

    @Test
    public void testMoreSpoons(){
        List<WebElement> brands=driver.findElements(By.xpath("//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base']"));

        List<String> brandsString=new ArrayList<>();

        for (WebElement brand:brands) {
            brandsString.add(brand.getText());
        }

        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]")).click();



        List<WebElement> refreshedBrands=driver.findElements(By.xpath("//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base']"));

        List<String> refreshedBrandsString=new ArrayList<>();

        for (WebElement refreshedBrand:refreshedBrands) {
            refreshedBrandsString.add(refreshedBrand.getText());
        }

        Assert.assertEquals(brandsString,refreshedBrandsString);
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        driver.findElement(By.xpath("//input[@value='Go']")).click();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
