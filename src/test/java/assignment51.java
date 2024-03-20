package assignment;

import junit.Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Set;

public class assignment51 extends Tests {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */

    public class InterdependentTests {
        @BeforeClass
        public void setUpSettings() {
            // Set up necessary settings before running the tests
        }

        @Test
        public void testFacebook() {
            // Go to Facebook and perform necessary assertions and actions
        }

        @Test(dependsOnMethods = "testFacebook")
        public void testGoogle() {
            // Go to Google, assuming Facebook test has passed, and perform necessary assertions and actions
        }

        @Test(dependsOnMethods = "testGoogle")
        public void testAmazon() {
            // Go to Amazon, assuming Google test has passed, and perform necessary assertions and actions
        }

        @AfterClass
        public void closeDriver() {
            // Close the driver and perform necessary cleanup after running the tests
        }
    }}
