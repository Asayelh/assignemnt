package assignment;

import junit.Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

/*
   Go to Amazon  https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
public class assig4  extends Tests {
    @Test
    public void amazonScrolling() throws AWTException, InterruptedException {

        driver.get("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");
        Robot robot = new Robot();
        //Scroll to the bottom of the page using a robot
        robot.mouseWheel(10);
        //Click on the "Back to top" web element
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='navFooterBackToTopText']")).click();
        //Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
        driver.findElement(By.xpath("//a[contains(@href,'/?ref_=footer_logo')]")).click();


       /////// //When I use JavaScript,robot does not work
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement amazonLogo = driver.findElement(By.xpath("//a[contains(@href,'/?ref_=footer_logo')]"));
//        js.executeScript("arguments[0].click();", amazonLogo);
//        amazonLogo.click();


//       Use Actions to type "ClarusWay" in the search box and perform the search
        Actions actions = new Actions(driver);
        By search = By.xpath("//input[@id='twotabsearchtextbox']");
        actions.moveToElement(driver.findElement(search)).click().sendKeys("ClarusWay").perform();


    }
}