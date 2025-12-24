package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.swing.*;
import java.time.Duration;

public class TestButtons extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/buttons");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        buttonsPage = new ButtonsPage();
        action = new Actions(driver);


    }


    @Test
    public void checkButtonsAreClickable() throws InterruptedException {

        Assert.assertTrue(buttonsPage.doubleClickButton.isDisplayed());
        Assert.assertTrue(buttonsPage.rightClickButton.isDisplayed());
        Assert.assertTrue(buttonsPage.buttonC.isDisplayed());

        Assert.assertTrue(buttonsPage.doubleClickButton.isEnabled());
        Assert.assertTrue(buttonsPage.rightClickButton.isEnabled());
        Assert.assertTrue(buttonsPage.buttonC.isEnabled());


        //double click button
        waitElement(buttonsPage.doubleClickButton);
        doubleClickAction(buttonsPage.chooseButton(buttonsPage.doubleClickOnButton()));
        Thread.sleep(1000);
        Assert.assertTrue(buttonsPage.doubleClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.doubleClickMessage.getText(),doubleClick);

        //right click button
        waitElement(buttonsPage.chooseButton(buttonsPage.rightClickOnButton()));
        rightClickAction(buttonsPage.chooseButton(buttonsPage.rightClickOnButton()));
        Thread.sleep(1000);
        Assert.assertTrue(buttonsPage.rightOnclickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.rightOnclickMessage.getText(),rightClick);

        //dynamic click button
        waitElement(buttonsPage.buttonC);
        oneClickAction(buttonsPage.chooseButton(buttonsPage.clickOnClickButton()));
        Thread.sleep(1000);
        Assert.assertTrue(buttonsPage.oneClickMessage.isDisplayed());
        Assert.assertEquals(buttonsPage.oneClickMessage.getText(),dynamicClick);



    }
}
