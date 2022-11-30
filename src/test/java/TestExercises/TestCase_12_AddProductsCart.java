package TestExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utility.TestBaseBeforeAfter;

import java.util.List;

public class TestCase_12_AddProductsCart extends TestBaseBeforeAfter {

    @Test
    public void test1() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        // 4. Click on 'Products' button
          driver.findElement(By.xpath("//*[text()=' Products']")).click();

        //5. Hover over first product and click 'Add to cart'
       // WebElement firstProduct= driver.findElement(By.xpath("(//*[@class='single-products'])[1]"));
        WebElement firstProduct= driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[1]"));
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.moveToElement(firstProduct).perform();
        Thread.sleep(100);
       // driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();

        //6. Click 'Continue Shopping' button
       Thread.sleep(100);
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //7. Hover over second product and click 'Add to cart'
        action.moveToElement(driver.findElement(By.xpath("(//*[@class='single-products'])[2]"))).perform();
        Thread.sleep(100);
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[4]")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();

        //9. Verify both products are added to Cart
        List<WebElement> cartProducts=driver.findElements(By.xpath("//tr"));
        //System.out.println(cartProducts.size());
        Assert.assertTrue(((cartProducts.size())-1)==2);

        //10. Verify their prices, quantity and total price
        String expectedFirstPrdQuant="1";
        String actualFirstPrdQuant=driver.findElement(By.xpath("(//*[@class='disabled'])[1]")).getText();
        Assert.assertEquals(expectedFirstPrdQuant,actualFirstPrdQuant);

        String expected2ndPrdQuant="1";
        String actual2ndPrdQuant=driver.findElement(By.xpath("(//*[@class='disabled'])[2]")).getText();
        Assert.assertEquals(expected2ndPrdQuant,actual2ndPrdQuant);

        //first product price ve total price verify
        Assert.assertEquals("Rs. 500",driver.findElement(By.xpath("(//*[text()='Rs. 500'])[1]")).getText());
        Assert.assertEquals("Rs. 500",driver.findElement(By.xpath("(//*[text()='Rs. 500'])[2]")).getText());

        //second product price and total price verify
        Assert.assertEquals("Rs. 400",driver.findElement(By.xpath("(//*[text()='Rs. 400'])[1]")).getText());
        Assert.assertEquals("Rs. 400",driver.findElement(By.xpath("(//*[text()='Rs. 400'])[2]")).getText());


        //



        /*








     */

    }
}
