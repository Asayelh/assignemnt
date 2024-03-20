package assignment;

import junit.Tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/



public class assig2 extends Tests {
    @Test
        public void  ass2(){

        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);
        // Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bank = driver.findElement(By.xpath("//a[contains(text(), 'BANK')]"));
        WebElement debitAccount = driver.findElement(By.xpath("//ol[@id='bank']"));
        actions.dragAndDrop(bank, debitAccount).perform();


        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement sales = driver.findElement(By.xpath("//a[contains(text(), 'SALES')]"));
        WebElement creditAccount = driver.findElement(By.xpath("//ol[@id='loan']"));
        actions.dragAndDrop(sales, creditAccount).perform();


        // Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement amount5000 = driver.findElement(By.xpath("//li[contains(@id,'fourth')]"));
        WebElement debitAmount = driver.findElement(By.xpath("//ol[@id='amt7']"));
        actions.dragAndDrop(amount5000, debitAmount).perform();

        // Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement creditAmount = driver.findElement(By.xpath("//ol[@id='amt8']"));
        actions.dragAndDrop(amount5000, creditAmount).perform();

        // Verify the visibility of Perfect text
        WebElement text = driver.findElement(By.xpath("//a[contains(text(), 'Perfect')]"));
        Assertions.assertTrue(text.isDisplayed());

        driver.quit();
}}