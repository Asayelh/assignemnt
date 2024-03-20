
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class assignment51  {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    WebDriver driver = new ChromeDriver();;
    @Test
    public void Facebook() {
        driver.get("https://www.facebook.com");
    }
    @Test(dependsOnMethods = "Facebook")
    public void Google() {
        driver.get("https://www.google.com");
    }
    @Test(dependsOnMethods = "Google")
    public void Amazon() {
        driver.get("https://www.amazon.com");
    }
}