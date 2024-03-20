package assignment;
import junit.Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//( This task should be managed with keyboard actions )
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object
public class assig3 extends Tests {

    @Test
    public void assignment3(){

        driver.get("https://www.google.com/");
        Actions action = new Actions(driver);
        action.sendKeys("Scroll Methods").sendKeys(Keys.RETURN).perform();
        String pageitle = driver.getTitle();
        Assert.assertTrue(pageitle.contains("Scroll Methods"));

    }
}