package assignment;

import com.google.common.io.Files;
import junit.Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class assig7 extends Tests {
    // Go to amazon.com ///https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot
    @Test
    public void Screenshot() throws IOException {
        driver.get("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");
        File fullScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(fullScreenshot, new File("target/screenshot_"+System.currentTimeMillis()+".png"));

        WebElement element = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
        Files.copy(elementScreenshot, new File("target/ElementScreenshot_"+System.currentTimeMillis()+".png"));




    }


}
