package Tests;

import Base.BaseTest;
import Pages.FormPage;
import Pages.HomePage;
import Pages.SubmittedFormPage;
import org.apache.hc.core5.http.protocol.UriPatternType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMandatoryFields extends BaseTest {

    @BeforeMethod
    public void setUpPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        formPage = new FormPage();
        homePage = new HomePage();
        submittedFormPage = new SubmittedFormPage();




    }


    //positive test
    @Test (priority = 10)
    public void testSubmittedMandatoryForm() throws InterruptedException {
        Assert.assertEquals(driver.getCurrentUrl(), practiceFormURL);

        for (int i = 1; i < excelReader.getLastRow("TestMandatoryFormData")+1; i++) {
            int j = 0;
            enterDataWithExcel("TestMandatoryFormData", i,j);

            Thread.sleep(500);
            formPage.checkInputFieldIsDispleyed(formPage.firstNameField);
            formPage.checkInputFieldIsEnabled(formPage.firstNameField);
            Thread.sleep(500);
            formPage.checkInputFieldIsDispleyed(formPage.lastNameField);
            formPage.checkInputFieldIsEnabled(formPage.lastNameField);
            Thread.sleep(500);
            formPage.inputData(formPage.firstNameField, fname);
            Thread.sleep(500);
            formPage.inputData(formPage.lastNameField, lname);
            Thread.sleep(500);

            formPage.checkGenderListisDisplayed();
            formPage.checkGenderListIsEnabled();
            formPage.checkGenderListIsNotSelected();
            Thread.sleep(500);
            formPage.choosingGender(gender);
            formPage.checkGenderIsSelected();

            Thread.sleep(500);
            formPage.checkInputFieldIsDispleyed(formPage.mobileNumberField);
            formPage.checkInputFieldIsEnabled(formPage.mobileNumberField);
            Thread.sleep(500);
            formPage.inputData(formPage.mobileNumberField, mNumber);

            formPage.checkInputFieldIsDispleyed(formPage.submitButton);
            formPage.checkInputFieldIsEnabled(formPage.submitButton);
            Thread.sleep(500);
            formPage.submitForm();

            Assert.assertEquals(submittedFormPage.submittedFormMessage.getText(), "Thanks for submitting the form");
            Assert.assertTrue(submittedFormPage.closeButton.isDisplayed());
            Assert.assertTrue(submittedFormPage.closeButton.isEnabled());
            Thread.sleep(500);


            submittedFormPage.closeSubmittedForm();
        }

    }
    //negative test, firstname empty
    @Test (priority = 20)
    public void cannotSubmitFormWithEmptyFirstName() throws InterruptedException {


        int i=1;
        int j=0;
        enterDataWithExcel("EmptyDataField", i, j);

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.firstNameField);
        formPage.checkInputFieldIsEnabled(formPage.firstNameField);
        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.lastNameField);
        formPage.checkInputFieldIsEnabled(formPage.lastNameField);
        Thread.sleep(500);
        formPage.inputData(formPage.firstNameField, fname);
        Thread.sleep(500);
        formPage.inputData(formPage.lastNameField, lname);
        Thread.sleep(500);


        formPage.checkGenderListisDisplayed();
        formPage.checkGenderListIsEnabled();
        formPage.checkGenderListIsNotSelected();
        Thread.sleep(500);
        formPage.choosingGender(gender);
        formPage.checkGenderIsSelected();

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.mobileNumberField);
        formPage.checkInputFieldIsEnabled(formPage.mobileNumberField);
        Thread.sleep(500);
        formPage.inputData(formPage.mobileNumberField, mNumber);

        formPage.checkInputFieldIsDispleyed(formPage.submitButton);
        formPage.checkInputFieldIsEnabled(formPage.submitButton);
        Thread.sleep(500);
        formPage.submitForm();

        checkIsNotPresent(submittedFormPage.submittedFormMessage);
        checkIsNotPresent(submittedFormPage.closeButton);
        Assert.assertTrue(formPage.submitButton.isDisplayed());


    }

    //negative test, lastname is empty
    @Test (priority = 30)
    public void cannotSubmitFormWithEmptyLastName() throws InterruptedException {


        int i=2;
        int j=0;

        enterDataWithExcel("EmptyDataField",i,j);

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.firstNameField);
        formPage.checkInputFieldIsEnabled(formPage.firstNameField);
        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.lastNameField);
        formPage.checkInputFieldIsEnabled(formPage.lastNameField);
        Thread.sleep(500);
        formPage.inputData(formPage.firstNameField, fname);
        Thread.sleep(500);
        formPage.inputData(formPage.lastNameField, lname);
        Thread.sleep(500);


        formPage.checkGenderListisDisplayed();
        formPage.checkGenderListIsEnabled();
        formPage.checkGenderListIsNotSelected();
        Thread.sleep(500);
        formPage.choosingGender(gender);
        formPage.checkGenderIsSelected();

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.mobileNumberField);
        formPage.checkInputFieldIsEnabled(formPage.mobileNumberField);
        Thread.sleep(500);
        formPage.inputData(formPage.mobileNumberField, mNumber);

        formPage.checkInputFieldIsDispleyed(formPage.submitButton);
        formPage.checkInputFieldIsEnabled(formPage.submitButton);
        Thread.sleep(500);
        formPage.submitForm();

        checkIsNotPresent(submittedFormPage.submittedFormMessage);
        checkIsNotPresent(submittedFormPage.closeButton);
        Assert.assertTrue(formPage.submitButton.isDisplayed());


    }

    //negative test, lastname is empty
    @Test (priority = 40)
    public void cannotSubmitFormWhenGenderButtonIsNotSelected() throws InterruptedException {


        int i=3;
        int j=0;

        enterDataWithExcel("EmptyDataField",i,j);

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.firstNameField);
        formPage.checkInputFieldIsEnabled(formPage.firstNameField);
        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.lastNameField);
        formPage.checkInputFieldIsEnabled(formPage.lastNameField);
        Thread.sleep(500);
        formPage.inputData(formPage.firstNameField, fname);
        Thread.sleep(500);
        formPage.inputData(formPage.lastNameField, lname);
        Thread.sleep(500);


        formPage.checkGenderListisDisplayed();
        formPage.checkGenderListIsEnabled();
        formPage.checkGenderListIsNotSelected();
        Thread.sleep(500);
        formPage.choosingGender(gender);
        formPage.checkGenderIsSelected();

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.mobileNumberField);
        formPage.checkInputFieldIsEnabled(formPage.mobileNumberField);
        Thread.sleep(500);
        formPage.inputData(formPage.mobileNumberField, mNumber);

        formPage.checkInputFieldIsDispleyed(formPage.submitButton);
        formPage.checkInputFieldIsEnabled(formPage.submitButton);
        Thread.sleep(500);
        formPage.submitForm();

        checkIsNotPresent(submittedFormPage.submittedFormMessage);
        checkIsNotPresent(submittedFormPage.closeButton);
        Assert.assertTrue(formPage.submitButton.isDisplayed());


    }

    //negative test, lastname is empty
    @Test (priority = 50)
    public void cannotSubmitFormWithEmptyMobileNumberField() throws InterruptedException {


        int i=4;
        int j=0;
        enterDataWithExcel("EmptyDataField", i,j);

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.firstNameField);
        formPage.checkInputFieldIsEnabled(formPage.firstNameField);
        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.lastNameField);
        formPage.checkInputFieldIsEnabled(formPage.lastNameField);
        Thread.sleep(500);
        formPage.inputData(formPage.firstNameField, fname);
        Thread.sleep(500);
        formPage.inputData(formPage.lastNameField, lname);
        Thread.sleep(500);


        formPage.checkGenderListisDisplayed();
        formPage.checkGenderListIsEnabled();
        formPage.checkGenderListIsNotSelected();
        Thread.sleep(500);
        formPage.choosingGender(gender);
        formPage.checkGenderIsSelected();

        Thread.sleep(500);
        formPage.checkInputFieldIsDispleyed(formPage.mobileNumberField);
        formPage.checkInputFieldIsEnabled(formPage.mobileNumberField);
        Thread.sleep(500);
        formPage.inputData(formPage.mobileNumberField, mNumber);

        formPage.checkInputFieldIsDispleyed(formPage.submitButton);
        formPage.checkInputFieldIsEnabled(formPage.submitButton);
        Thread.sleep(500);
        formPage.submitForm();

        checkIsNotPresent(submittedFormPage.submittedFormMessage);
        checkIsNotPresent(submittedFormPage.closeButton);
        Assert.assertTrue(formPage.submitButton.isDisplayed());


    }
    @Test (priority = 60)
    public void testAllMandatoryFieldsAreEmpty() {

        formPage.checkInputFieldIsDispleyed(formPage.firstNameField);
        formPage.checkInputFieldIsEnabled(formPage.firstNameField);

        formPage.checkInputFieldIsDispleyed(formPage.lastNameField);
        formPage.checkInputFieldIsEnabled(formPage.lastNameField);

        formPage.checkGenderListisDisplayed();
        formPage.checkGenderListIsEnabled();
        formPage.checkGenderListIsNotSelected();



        formPage.checkInputFieldIsDispleyed(formPage.mobileNumberField);
        formPage.checkInputFieldIsEnabled(formPage.mobileNumberField);


        formPage.checkInputFieldIsDispleyed(formPage.submitButton);
        formPage.checkInputFieldIsEnabled(formPage.submitButton);

        formPage.submitForm();

        checkIsNotPresent(submittedFormPage.submittedFormMessage);
        checkIsNotPresent(submittedFormPage.closeButton);
        Assert.assertTrue(formPage.submitButton.isDisplayed());

    }
}
