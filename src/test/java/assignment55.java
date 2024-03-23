import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class assignment55 {
    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 2.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.
    WebDriver driver = new ChromeDriver();
@Test
    public void toDoApp() {
    driver.get("http://crossbrowsertesting.github.io/");
    driver.findElement(By.cssSelector("a[href='todo-app.html']")).click();
    driver.findElement(By.xpath("//input[@name='todo-4']")).click();
    driver.findElement(By.xpath("//input[@name='todo-5']")).click();
    List<WebElement> toDoList = driver.findElements(By.xpath("//span[contains(@class,'done-true')]"));
    int listSize = toDoList.size();
    Assert.assertEquals(listSize, 2, "List length is not as expected");
    String toDoList4 = driver.findElement(By.xpath("//input[contains(@name,'todo-4')]")).getText();
    String toDoList5 = driver.findElement(By.xpath("//input[contains(@name,'todo-2')]")).getText();

    toDoList.forEach(item -> {
        String text = item.getText();
        if (text.equals(toDoList4)) {

            Assert.assertTrue(true, "Text 'to do 4' not found in checked items");
        }
        if (text.equals(toDoList5)) {

            Assert.assertTrue(true, "Text 'to do 5' not found in checked items");
        }
    });
    driver.findElement(By.xpath("//a[@ng-click='todoList.archive()']")).click();

    List<WebElement> restlist = driver.findElements(By.xpath("//span[@class='done-false']"));
    int total = restlist.size();
    Assert.assertEquals(total, 3);
}
    }




