package TestExercises;

import org.junit.Test;
import utility.TestBaseBeforeAfter;

public class TestCase_14 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();

    }
}
