package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;


public class LoginTest extends Utility {


    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter the username into username field
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter password into password field
        sendTextToElement(By.id("password"), "secret_sauce");
        //Click on Login button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the Text "PRODUCTS"
        verifyText("Products", By.xpath("//span[contains(text(),'Products')]"), "Products");

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter the username in to username filed “standard_user”
        sendTextToElement(By.id("user-name"), "standard_user");

        //Enter “secret_sauce” password
        sendTextToElement(By.name("password"), "secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify that six products are displayed on page

        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualNumber = number.size();
        int expectedNumber = 6;
        Assert.assertEquals("6 product not displayed", expectedNumber, actualNumber);
        System.out.println("Number of Products:" + actualNumber);

    }
@After
    public void tearDown(){

        driver.close();
}

}
