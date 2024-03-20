package assignment;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

public class assignment52 {
    //Go to URL: https://opensource-demo.orangehrmlive.com/
    //Login with negative credentilas by Data Provider.
    //Then assert that ‘’Invalid credentials’’ is displayed.
    //Run it parallel with 3 threads
    //Generate Allure report


//    @DataProvider
//    public Object[][] getData(){
//        return new Object[][]{
//                {"admin*","admin123"},
//                {"admin12","123"},
//                {"Admin1","***00**"},
//                {"test","123"},
//                {"user","369"},
//        }


    public class LoginTests {
        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            // Set up necessary settings before running the tests
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        }

        @DataProvider(parallel = true)
        public Iterator<Object[]> getData() {
            JSONParser parser = new JSONParser();
            try {
                JSONArray credentials = (JSONArray) parser.parse(new FileReader("path/to/credentials.json"));
                List<Object[]> data = credentials.stream()
                        .map(obj -> {
                            JSONObject jsonObject = (JSONObject) obj;
                            return new Object[]{jsonObject.get("username"), jsonObject.get("password")};
                        })
                        .toList();
                return data.iterator();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Test(dataProvider = "getData")
        public void testInvalidLogin(String username, String password) {
            driver = new ChromeDriver();
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.findElement(By.id("txtUsername")).sendKeys(username);
            driver.findElement(By.id("txtPassword")).sendKeys(password);
            driver.findElement(By.id("btnLogin")).click();
            Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
            driver.quit();
        }

        @AfterClass
        public void tearDown() {
            // Perform necessary cleanup after running the tests
        }
    }

}

