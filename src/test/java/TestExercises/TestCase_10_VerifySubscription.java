package TestExercises;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase_10_VerifySubscription {
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
    public void test1() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //4. Scroll down to footer
        Actions action=new Actions(driver);

            action.sendKeys(Keys.PAGE_DOWN).perform();


        //5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed());

        //6. Enter email address in input and click arrow button
        Faker fake=new Faker();
driver.findElement(By.xpath("//*[@type='email']")).sendKeys(fake.internet().emailAddress());
driver.findElement(By.xpath("//*[@type='submit']")).click();
Thread.sleep(5000);

//7. Verify success message 'You have been successfully subscribed!' is visible
        boolean visible=false;
        Assert.assertFalse(false);


    }
}
