package assignment;

import junit.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class assig5 extends Tests {
     /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */


    @Test
    public void testCooke() {
        driver.get("http://facebook.com");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Name: " + cookie.getName() + ", Value: " + cookie.getValue());
        }
        driver.manage().addCookie(new Cookie("exampleCookie", "exampleValue"));
        driver.manage().deleteCookieNamed("exampleCookie");
        driver.manage().deleteAllCookies();


    }
}