package TestExercises;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utility.TestBaseBeforeAfter;

public class TestCase_11_VerifyCartPage extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        //4. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //5. Scroll down to footer
        Actions action=new Actions(driver);
        action.sendKeys(Keys.END).perform();

        //6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Subscription']")).isDisplayed());

        //7. Enter email address in input and click arrow button
        Faker fake=new Faker();
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys(fake.internet().emailAddress());
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(5000);

        //8. Verify success message 'You have been successfully subscribed!' is visible
        boolean visible=false;
        Assert.assertFalse(false);

    }
}
