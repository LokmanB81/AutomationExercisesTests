package TestExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.TestBaseBeforeAfter;

import java.sql.Driver;

public class TestCase_13_VerifyQuantityInCart extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        //   2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //  4. Click 'View Product' for any product on home page
        driver.findElement(By.xpath("//*[@href='/product_details/2']")).click();

        // 5. Verify product detail is opened
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details"));

        // 6. Increase quantity to 4
        Thread.sleep(500);
       action.click(driver.findElement(By.xpath("(//input)[1]"))).perform();
        driver.findElement(By.xpath("(//input)[1]")).clear();
        driver.findElement(By.xpath("(//input)[1]")).sendKeys("4");

        // 7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        //  8. Click 'View Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

        // 9. Verify that product is displayed in cart page with exact quantity
        String expectedQuantity="4";
        Assert.assertEquals(expectedQuantity,driver.findElement(By.xpath("//button[@class='disabled']")).getText());



    }
}
