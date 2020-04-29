package org.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;


public class AppTest 
{

    private WebDriver driver;

    @Before
    public void setUp(){
            driver = new ChromeDriver();
    }

    @Test
    public void seleniumExampleTest() throws InterruptedException {
        driver.manage().window().maximize();
        sleep(2000);
        driver.get("http://thedemosite.co.uk/login.php");
        sleep(1000);
        WebElement userSearchBar = driver.findElement(By.name("username"));
        userSearchBar.sendKeys("smyth123456");
        sleep(1000);
        WebElement passSearchBar = driver.findElement(By.name("password"));
        passSearchBar.sendKeys("osbourne123456");
        sleep(1000);
        WebElement login = driver.findElement(By.name("FormsButton2"));
        login.click();
        sleep(2000);
        WebElement imageLink = driver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
        assertEquals(imageLink.getText(), "**Successful Login**");


    }

    @After
    public void tearDown() {
        driver.close();
    }



    public class HouseBuilderTest {

        private WebDriver driver;

        @Before
        public void setUp(){
            driver = new ChromeDriver();
        }

        @Test
        public void seleniumDrawHouse() throws InterruptedException {
            driver.manage().window().maximize();
            Thread.sleep(2000);
            driver.get("https://www.youidraw.com/apps/painter/");
            Thread.sleep(2000);

            Actions action = new Actions(driver);
            Thread.sleep(2000);

            // draw house

            action.moveByOffset( 400,400).clickAndHold().moveByOffset(400,0).perform();
            Thread.sleep(2000);

            action.moveByOffset( 830,400).clickAndHold().moveByOffset(400,0).perform();
            Thread.sleep(2000);

            action.moveByOffset( 830,600).clickAndHold().moveByOffset(400,0).perform();
            Thread.sleep(2000);

            action.moveByOffset( 400,600).clickAndHold().moveByOffset(400,0).perform();
            Thread.sleep(2000);

        }
    }

}
