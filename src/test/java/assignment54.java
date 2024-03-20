import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class assignment54 {
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password:
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.

//(create an array structure with "Mac, iPad and Samsung". You can see it in Assignment 2)
WebDriver driver = new ChromeDriver();

@Test
public void log(){
    driver.get("http://opencart.abstracta.us/index.php?route=account/login");
    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("clarusway@gmail.com");
    driver.findElement(By.name("password")).sendKeys("123456789");
    WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
    loginButton.click();

}
    @Test(dataProvider = "getData")
    public void test (String word){

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(word+ Keys.ENTER);
         driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
    }
@DataProvider
    public Object [][]getData(){
        return new Object[][]{
                {"mac"},{"ipad"},{"samsung"}
        };
}
}
