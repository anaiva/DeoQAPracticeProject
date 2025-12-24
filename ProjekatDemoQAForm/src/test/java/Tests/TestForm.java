package Tests;

import Base.BaseTest;
import Pages.FormPage;
import Pages.FormsPage;
import Pages.HomePage;
import Pages.SubmittedFormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestForm extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        formPage = new FormPage();
        homePage = new HomePage();
        formsPage = new FormsPage();
        subjects = new ArrayList<>();
        listOfHobbies = new ArrayList<>();
        submittedFormPage = new SubmittedFormPage();

        homePage.clickOnElements(strForms);
        formsPage.findPracticeForm(strPracticeForm);


    }

    @Test
    public void testStudentCanSubmitForm() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), practiceFormURL);
        //unos podataka iz Excela

        for (int i = 1; i < excelReader.getLastRow("FormData") + 1; i++) {
            int j = 0;

            enterDataWithExcelToCompleteForm("FormData", i,j);

            //input podataka
            //provera da li su polja vidljiva i omogucena

            formPage.checkInputFieldIsDispleyed(formPage.firstNameField);
            formPage.checkInputFieldIsEnabled(formPage.firstNameField);
            formPage.checkInputFieldIsDispleyed(formPage.lastNameField);
            formPage.checkInputFieldIsEnabled(formPage.lastNameField);
            formPage.checkInputFieldIsDispleyed(formPage.userEmailField);
            formPage.checkInputFieldIsEnabled(formPage.userEmailField);

            formPage.inputData(formPage.firstNameField, fname);
            formPage.inputData(formPage.lastNameField, lname);
            formPage.inputData(formPage.userEmailField, email);
            Thread.sleep(2000);


            formPage.checkGenderListisDisplayed();
            formPage.checkGenderListIsEnabled();
            formPage.checkGenderListIsNotSelected();
            formPage.choosingGender(gender);
            Thread.sleep(2000);

            formPage.checkGenderIsSelected();



            Thread.sleep(500);
            formPage.checkInputFieldIsDispleyed(formPage.mobileNumberField);
            formPage.checkInputFieldIsEnabled(formPage.mobileNumberField);
            formPage.inputData(formPage.mobileNumberField, mNumber);

            formPage.clickOnDate();

            waitElement(formPage.monthField);
            formPage.chooseDate(formPage.monthField, dateOfBirth.substring(2, dateOfBirth.length() - 4));
            waitElement(formPage.yearField);
            formPage.chooseDate(formPage.yearField, dateOfBirth.substring(dateOfBirth.length() - 4));

            formPage.chooseDay(dateOfBirth.substring(0, 2));

            waitElement(formPage.subjectElement);
            formPage.checkInputFieldIsDispleyed(formPage.subjectElement);
            formPage.checkInputFieldIsEnabled(formPage.subjectElement);
            formPage.chooseSubjects(subjects);

            formPage.checkHobbiesCheckboxAreVisible();
            formPage.checkHobbiesCheckboxAreEnabled();
            formPage.checkHobbiesCheckboxAreNotSelected();
            formPage.checkHobbies(listOfHobbies);

            formPage.uploadImage();

            formPage.checkInputFieldIsDispleyed(formPage.addressField);
            formPage.checkInputFieldIsEnabled(formPage.addressField);
            formPage.inputData(formPage.addressField, address);

            formPage.checkInputFieldIsDispleyed(formPage.countryField);
            formPage.checkInputFieldIsEnabled(formPage.countryField);
            formPage.checkInputFieldIsNotEnabled(formPage.cityField);
            formPage.selectCountry(country);

            Thread.sleep(500);
            formPage.checkInputFieldIsDispleyed(formPage.cityField);
            formPage.checkInputFieldIsEnabled(formPage.cityField);
            formPage.selectCity(city);

            formPage.checkInputFieldIsDispleyed(formPage.submitButton);
            formPage.checkInputFieldIsEnabled(formPage.submitButton);
            formPage.submitForm();
            Thread.sleep(2000);

            Assert.assertEquals(submittedFormPage.submittedFormMessage.getText(), formSuccessfullySubmitted);
            Assert.assertTrue(submittedFormPage.closeButton.isDisplayed());
            Assert.assertTrue(submittedFormPage.closeButton.isEnabled());

            submittedFormPage.checkSubmittedFormIsNotEmpty();
            submittedFormPage.closeSubmittedForm();

        }
    }
}
