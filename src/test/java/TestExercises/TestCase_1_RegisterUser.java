package TestExercises;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase_1_RegisterUser {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDowm() {
        //driver.close();
    }
  /*
    1. Launch browser
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

   */
    @Test
    public void test_1() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
      driver.get("http://automationexercise.com");

      // 3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible

        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/login']")).isDisplayed());

        Faker fake=new Faker();
        Actions action=new Actions(driver);

        //6. Enter name and email address and 7. Click 'Signup' button
      driver.findElement(By.xpath("//*[@type='text']")).click();
       action.sendKeys(fake.name().username()).sendKeys(Keys.TAB).
       sendKeys(fake.internet().emailAddress()).perform();
       // driver.findElement(By.xpath("(//*[@type='email'])[2]")).sendKeys(fake.internet().emailAddress());
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        Thread.sleep(2000);

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String expectedText="ENTER ACCOUNT INFORMATION";
        String actualText=driver.findElement(By.xpath("(//*[@class='title text-center'])[1]")).getText();
       Assert.assertEquals(actualText,expectedText);

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //Title
        driver.findElement(By.xpath("//*[@for='id_gender1']")).click();

        //Name

        //Email


        //Password
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123456");

        //Date of birth
        WebElement dayMenu=driver.findElement(By.xpath("//*[@id='days']"));
        Select slc=new Select(dayMenu);
        slc.selectByIndex(1);

        WebElement months=driver.findElement(By.xpath("//*[@id='months']"));
        Select slc1=new Select(months);
        slc1.selectByIndex(10);

        WebElement year=driver.findElement(By.xpath("//*[@id='years']"));
        Select slc2=new Select(year);
        slc2.selectByValue("2000");


        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("lokman");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("qqq");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("techpro");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("bahcesehir");


        WebElement country=driver.findElement(By.xpath("//*[@id='country']"));
        Select slc3=new Select(country);
        slc3.selectByValue("Australia");

        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("turkey");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("turkey");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("11111");
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("555 5555");


        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible

          Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='pull-right']")).click();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

       // 17. Click 'Delete Account' button
        driver.findElement(By.xpath("(//a[@style='color:brown;'])[2]")).click();

        //
        // driver.findElement(By.xpath("")).



    }

}
