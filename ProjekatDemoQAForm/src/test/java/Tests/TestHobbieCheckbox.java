package Tests;

import Base.BaseTest;
import Pages.FormPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestHobbieCheckbox extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        formPage = new FormPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void checkStudentCanSelectHobbies() throws InterruptedException {

        formPage.checkHobbiesCheckboxAreVisible();
        formPage.checkHobbiesCheckboxAreEnabled();
        formPage.checkHobbiesCheckboxAreNotSelected();
        //select
        formPage.clickOnAllHobbiesOptions();
        formPage.checkHobbiesCheckboxAreSelected();
        //deselect
        formPage.clickOnAllHobbiesOptions();
        formPage.checkHobbiesCheckboxAreNotSelected();
        //select/deselect one by one
        formPage.selectDeselectHobbiesOneByOne();
        formPage.checkHobbiesCheckboxAreNotSelected();

    }
}
