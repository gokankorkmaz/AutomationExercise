package AutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchProduct {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. close driver

    static WebDriver driver;

    //TestCase 9: Search Product

    @BeforeClass
    public static void setup() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void tearDown() {
        //8. close driver
        driver.quit();
    }


    @Test
    public void searchProduct() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);


        //4. Click on 'Products' button
        WebElement productsElement = driver.findElement(By.xpath("//a[@href='/products']"));
        productsElement.click();


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedProductUrl = "https://automationexercise.com/products";
        String actualProductCurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedProductUrl, actualProductCurrentUrl);


        //6. Enter product name in search input and click search button
        WebElement searchinput = driver.findElement(By.className("input-lg"));
        searchinput.sendKeys("tshirt");
        WebElement clickSearchButton = driver.findElement(By.className("btn-lg"));
        clickSearchButton.click();


        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchProductisVisible = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(searchProductisVisible.isDisplayed());

    }
}


