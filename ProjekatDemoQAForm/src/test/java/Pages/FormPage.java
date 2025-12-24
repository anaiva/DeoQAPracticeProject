package Pages;

import Base.BaseTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class FormPage extends BaseTest {

    public FormPage() {
        PageFactory.initElements(driver, this);
    }



    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(css = "label[for^='gender-radio-']")
    public List<WebElement> genderList;

    @FindBy(css = "input[id^='gender-radio-']")
    public List<WebElement> inputGenderList;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement birthDayField;

    @FindBy(className = "react-datepicker__day")
    public List<WebElement> dayList;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthField;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearField;

    @FindBy(id = "subjectsInput")
    public WebElement subjectElement;

    //klikabilna opcija
    @FindBy(css = "label[for^='hobbies-checkbox-']")
    public List<WebElement> checkboxList;

    // da li je cekiran
    @FindBy(css = "input[id^='hobbies-checkbox']")
    public  List<WebElement> hobbiesList;

    @FindBy(id = "uploadPicture")
    public WebElement uploadFile;

    @FindBy(id = "currentAddress")
    public WebElement addressField;

    @FindBy(id = "react-select-3-input")
    public WebElement countryField;

    @FindBy(id = "react-select-4-input")
    public WebElement cityField;

    @FindBy(css = "button[id='submit']")
    public WebElement submitButton;


    //*****************************************************

    public void submitForm() {

        submitButton.click();
    }

    public void selectCountry(String country) throws InterruptedException {
        countryField.clear();
        countryField.sendKeys(country);
        countryField.sendKeys(Keys.ENTER);
        countryField.sendKeys(Keys.TAB);
        Thread.sleep(1000);

    }

    public void selectCity(String city) throws InterruptedException {

        cityField.clear();
        Thread.sleep(500);
        cityField.sendKeys(city);
        Thread.sleep(500);
        cityField.sendKeys(Keys.ENTER);
        Thread.sleep(500);


    }

    public void uploadImage() throws InterruptedException {
        //need to add your own file
      uploadFile.sendKeys("/sampleFile.jpeg");

        Thread.sleep(2000);
    }

    public void checkHobbies(List<String> lStr) throws InterruptedException {
        //dobija podatak iz excela za hobi
        for (int k = 0; k < lStr.size(); k++){
                for (int i = 0; i < checkboxList.size(); i++) {

                    if (checkboxList.get(i).getText().equalsIgnoreCase(lStr.get(k))) {
                        checkboxList.get(i).click();
                        Assert.assertTrue(hobbiesList.get(i).isSelected());
                        Thread.sleep(500);
                    }
                }

        }
    }



    public void clickOnAllHobbiesOptions() throws InterruptedException {
        for (int i = 0; i < checkboxList.size(); i++) {
            checkboxList.get(i).click();
            Thread.sleep(500);
        }
    }
    public void selectDeselectHobbiesOneByOne() throws InterruptedException {
        for (int i = 0; i < checkboxList.size(); i++) {
            checkboxList.get(i).click();
            checkboxList.get(i).click();

            Thread.sleep(500);
            Assert.assertFalse(checkboxList.get(i).isSelected());
        }
    }


    public void chooseSubjects(List<String> subject) throws InterruptedException {

        for (int i = 0; i < subject.size(); i++) {
            subjectElement.sendKeys(subject.get(i));
            Thread.sleep(500);
            subjectElement.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            subjectElement.sendKeys(Keys.ENTER);
        }
    }


    public void inputData(WebElement element, String data) {
        element.clear();
        element.sendKeys(data);
    }

    public void choosingGender(String gender) {

        for (int i = 0; i < genderList.size(); i++) {
            if (genderList.get(i).getText().equalsIgnoreCase(gender)) {
                genderList.get(i).click();
            }
        }
    }

    public void checkGenderRadioButtons() throws InterruptedException {

        for (int i = 0; i < genderList.size(); i++) {
                genderList.get(i).click();
        }
        for (int i = genderList.size()-2; i >=0; i--) {
            genderList.get(i).click();
        }
        for (int i = 1; i < genderList.size(); i++) {
            genderList.get(i).click();
        }
    }

    public void clickOnDate() {
        birthDayField.click();
    }

    public void chooseDate(WebElement element, String birthdate) {
        Select select = new Select(element);
        select.selectByContainsVisibleText(birthdate);
    }


    public void chooseDay(String birthDate) {
        for (int i = 0; i < dayList.size(); i++) {
            if (dayList.get(i).getText().equals(birthDate)) {
                dayList.get(i).click();
            }
        }
    }


    //assert
    public void checkGenderListIsNotSelected() {
        for (int i = 0; i < genderList.size(); i++) {
            Assert.assertFalse(genderList.get(i).isSelected());
        }
    }

    public void checkGenderIsSelected() throws InterruptedException {

        for (int i = 0; i < inputGenderList.size(); i++) {

            if ((genderList.get(i).isSelected())){
                Assert.assertTrue(genderList.get(i).isSelected());
                break;
            }
        }
    }


    public void checkGenderListisDisplayed() {
        for (int i = 0; i < genderList.size(); i++) {
            Assert.assertTrue(genderList.get(i).isDisplayed());

        }
    }

    public void checkGenderListIsEnabled() {
        for (int i = 0; i < genderList.size(); i++) {
            Assert.assertTrue(genderList.get(i).isEnabled());

        }
    }
    public void checkInputFieldIsDispleyed(WebElement element){

        Assert.assertTrue(element.isDisplayed());
    }
    public void checkInputFieldIsEnabled(WebElement element){

        Assert.assertTrue(element.isEnabled());
    }

    public void checkInputFieldIsNotEnabled(WebElement element){

        Assert.assertFalse(element.isEnabled());
    }

    public  void checkHobbiesCheckboxAreVisible() throws InterruptedException {
        for (int i = 0; i < checkboxList.size(); i++) {
            Assert.assertTrue(checkboxList.get(i).isDisplayed());
        }
    }

    public  void checkHobbiesCheckboxAreEnabled() throws InterruptedException {
        for (int i = 0; i < checkboxList.size(); i++) {
            Assert.assertTrue(checkboxList.get(i).isEnabled());
        }
    }

    public  void checkHobbiesCheckboxAreNotSelected() throws InterruptedException {
        for (int i = 0; i < checkboxList.size(); i++) {
            Assert.assertFalse(checkboxList.get(i).isSelected());
        }
    }
    public  void checkHobbiesCheckboxAreSelected() throws InterruptedException {
        for (int i = 0; i < hobbiesList.size(); i++) {

            Thread.sleep(500);
            Assert.assertTrue(hobbiesList.get(i).isSelected());

        }
    }


}
