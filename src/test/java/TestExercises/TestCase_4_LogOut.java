package TestExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_4_LogOut {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public  static  void tearDowm() {

        ///driver.close();
    }

    @Test
    public void test1(){
        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());

//6. Enter correct email address and password
        driver.findElement(By.xpath("(//*[@type='email'])[1]")).sendKeys("lokman@gmail.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123456");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

       //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[@href='/logout']")).click();

        //10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
       Assert.assertEquals(expectedUrl,actualUrl);

    }
}
