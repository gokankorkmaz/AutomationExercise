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

public class LogoutUser {

    //tc4Logoutuser

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Logout' button
    //10. Verify that user is navigated to login page
    //11. Close driver

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void AssertionExample(){
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement logoElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElementi.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement verifyLogin = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(verifyLogin.isDisplayed());

        //6. Enter correct email address and password
        WebElement login = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        login.sendKeys("ahmet@nehaber.com");
        WebElement password = driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        password.sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();


        //8. Verify that 'Logged in as username' is visible
        WebElement loggedTextCheck=driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        Assert.assertTrue(loggedTextCheck.isDisplayed());

        //9. Click 'Logout' button
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/logout']"));
        logoutButton.click();

        //10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);


    }


    @AfterClass
    public static void tearDown() {
        //11. Close driver
        driver.close();
    }

}
