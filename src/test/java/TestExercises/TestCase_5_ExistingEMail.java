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

public class TestCase_5_ExistingEMail {
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
        //driver.close();
    }

    @Test
    public void test1(){
        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/login']")).isDisplayed());

//6. 6. Enter name and already registered email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("lokman");
        driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys("lokman@gmail.com");


        // 7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());


    }
}
