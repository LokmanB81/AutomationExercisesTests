package TestExercises;

import com.github.javafaker.Faker;
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

public class TestCase_06_ContactUsForm {

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

            // 3. Verify that home page is visible successfully
            String expectedTitle="Automation Exercise";
            String actualTitle= driver.getTitle();

            Assert.assertEquals(actualTitle,expectedTitle);

            //4. Click on 'Contact Us' button
            driver.findElement(By.xpath("//*[@href='/contact_us']")).click();

            //5. Verify 'GET IN TOUCH' is visible
            String expectedText="GET IN TOUCH";
            String actualText=driver.findElement(By.xpath("(//h2)[2]")).getText();
            Assert.assertEquals(actualText,expectedText);

            //6. Enter name, email, subject and message
            Faker fake=new Faker();
            driver.findElement(By.xpath("//*[@name='name']")).
                    sendKeys("lokman");
            driver.findElement(By.xpath("//*[@name='email']")).
                    sendKeys("lokman@gmail.com");
            driver.findElement(By.xpath("//*[@name='message']")).
                    sendKeys(fake.lorem().paragraph());
            driver.findElement(By.xpath("//*[@name='subject']")).
                    sendKeys("hatali urun");

            //7. Upload file
            WebElement upLoadFile= driver.findElement(By.xpath("//*[@name='upload_file']"));
            upLoadFile.sendKeys("C:/Users/lkmnb/Desktop/Test_execise_sample.bmp");


            //8. Click 'Submit' button
            driver.findElement(By.xpath("//*[@name='submit']")).click();

            //9. Click OK button
            Thread.sleep(3000);
          ///  driver.switchTo().alert().accept();








        /*







10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
         */
        }
    }

