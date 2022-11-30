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

public class TestCase_9_SearchProduct {
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

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedUrl="https://automationexercise.com/products";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        //6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//*[@id='search_product']")).
            sendKeys("tshirt");
        driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

        //8. Verify all the products related to search are visible

    }
}
