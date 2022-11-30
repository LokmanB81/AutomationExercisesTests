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

public class TestCase_7_VerifyTestCasePage {
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
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();

        //5. Verify user is navigated to test cases page successfully
        String expectedUrlWord="test_cases";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlWord));

    }
}
