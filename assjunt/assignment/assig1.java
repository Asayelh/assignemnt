package assignment;

import junit.Tests;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Set;

public class assig1 extends Tests {
    //Go to URL: https://the-internet.herokuapp.com/windows
    //Verify the text: “Opening a new window”
    //Verify the title of the page is “The Internet”
    //Click on the “Click Here” button
    //Verify the new window title is “New Window”
    //Go back to the previous window and then verify the title: “The Internet”

    @Test
    public void win(){

        driver.get("https://the-internet.herokuapp.com/windows");
        var originalWindowHandle = driver.getWindowHandle();
        String text = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(text, "Opening a new window");

        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet");
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        Set<String > handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        String newWindowHandle = (String) handles.toArray()[0];
        driver.switchTo().window(newWindowHandle);


        String newTitle = driver.getTitle();
        Assert.assertEquals(newTitle, "New Window");

//Go back to the previous window and then verify the title: “The Internet”
            driver.close();
            driver.switchTo().window(originalWindowHandle);
            Assert.assertEquals(title, "The Internet");

        }
    }

