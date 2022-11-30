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

public class TestCase_8_VerifyAllProducts {
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

        //6. The products list is visible


        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//*[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        String expectedUrl_1="https://automationexercise.com/product_details/1";
        String actualUrl_2= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl_1,actualUrl_2);

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
    Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//p)[3]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//span)[13]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//b)[1]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//b)[2]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//b)[3]")).isDisplayed());
    }
}
