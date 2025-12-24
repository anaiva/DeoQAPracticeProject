package Tests;

import Base.BaseTest;
import Pages.FormPage;
import Pages.SubmittedFormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestGenderRadioButtons extends BaseTest {
    @BeforeMethod
    public void pageSetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        formPage = new FormPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void testGenderButtons() throws InterruptedException {

        formPage.checkGenderListisDisplayed();
        formPage.checkGenderListIsEnabled();
        formPage.checkGenderListIsNotSelected();
        formPage.checkGenderRadioButtons();

        formPage.checkGenderIsSelected();
    }
}
