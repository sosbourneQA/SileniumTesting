package org.example;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class MyStoreTest {

    private WebDriver driver;

    @Before
    public void setUp() { driver = new ChromeDriver(); }

    @Test
    public void myStoreTest() throws InterruptedException {
        driver.manage().window().maximize();
        sleep(1000);
        driver.get("http://automationpractice.com/index.php");
        sleep(1000);
        WebElement women = driver.findElement(By.id("search_query_top"));
        women.sendKeys("dresses");
        sleep(2000);
        WebElement search = driver.findElement(By.cssSelector("#searchbox > button"));
        search.click();
        sleep(2000);
        WebElement dress = driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img"));
        dress.click();
        sleep(2000);
        WebElement cart = driver.findElement(By.cssSelector("#add_to_cart > button > span"));
        cart.click();
        sleep(2000);
        WebElement checkout = driver.findElement(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span"));
        checkout.click();
        sleep(2000);
        WebElement product = driver.findElement(By.cssSelector("#product_4_16_0_0 > td.cart_product"));
        WebElement correctDress = driver.findElement(By.cssSelector("#product_4_16_0_0 > td.cart_product > a > img"));

        WebElement cartPopUp = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product_4_16_0_0 > td.cart_product > a > img")));
        assertTrue(cartPopUp.isDisplayed());



//        WebElement dresses = driver.findElement(By.partialLinkText("Dresses"));
//        dresses.click();




//        WebElement login = driver.findElement(By.className("login"));
//        login.click();
//        sleep(1000);
//        WebElement signup = driver.findElement(By.id("email_create"));
//        signup.sendKeys("luke@email.com");
//        sleep(1000);
//        WebElement create = driver.findElement(By.id("SubmitCreate"));
//        create.click();
//        sleep(4000);
//        WebElement gender = driver.findElement(By.id("id_gender1"));
//        gender.click();
//        sleep(1000);
//        WebElement firstname = driver.findElement(By.id("customer_firstname"));
//        firstname.sendKeys("luke");
//        sleep(1000);
//        WebElement lastname = driver.findElement(By.id("customer_lastname"));
//        lastname.sendKeys("smyth");
//        sleep(1000);
//        WebElement pass = driver.findElement(By.id("passwd"));
//        pass.sendKeys("osbourne");
//        sleep(1000);
//        WebElement dob1 = driver.findElement(By.id("days"));
//        dob1.click();
//        sleep(4000);
//        WebElement day = driver.findElement(By.cssSelector("#days > option:nth-child(5)"));
//        gender.click();
//        sleep(1000);



    }

}
