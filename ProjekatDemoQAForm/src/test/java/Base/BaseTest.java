package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jshell.execution.FailOverExecutionControlProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    public FormPage formPage;
    public WebDriverWait wait;
    public SubmittedFormPage submittedFormPage;
    public ExcelReader excelReader;
    public String fname, lname, email, gender, mNumber, dateOfBirth, address, country, city, subject, hobbie ;
    public List<String> subjects, listOfHobbies;
    public Actions action;
    public WebElement webElement;
    public HomePage homePage;
    public ButtonsPage buttonsPage;
    public FormsPage formsPage;
    public String strForms, strPracticeForm, doubleClick, rightClick, dynamicClick, formSuccessfullySubmitted, practiceFormURL ;




    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("WebTablesData.xlsx");



        int m=1;
        int n=0;
        strForms = excelReader.getStringData("Messages", m,n++);
        strPracticeForm = excelReader.getStringData("Messages", m,n++);
        doubleClick = excelReader.getStringData("Messages", m,n++);
        rightClick = excelReader.getStringData("Messages", m,n++);
        dynamicClick = excelReader.getStringData("Messages", m,n++);
        formSuccessfullySubmitted = excelReader.getStringData("Messages", m,n++);
        practiceFormURL = excelReader.getStringData("Messages", m,n);
    }
    public void waitElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }




    public void checkIsNotPresent(WebElement element){
        boolean isPresent = false;

        try {
            isPresent = element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertFalse(isPresent);
    }

    public void enterDataWithExcel(String tab, int i, int j){

        waitElement(formPage.firstNameField);
        fname = excelReader.getStringData(tab, i, j++);
        waitElement(formPage.lastNameField);
        lname = excelReader.getStringData(tab, i, j++);
        gender = excelReader.getStringData(tab, i, j++);
        waitElement(formPage.mobileNumberField);
        mNumber = excelReader.getStringData(tab, i, j);
    }

    public void enterDataWithExcelToCompleteForm(String tab, int i, int j){
       // tab= "FormData";
        waitElement(formPage.firstNameField);
        fname = excelReader.getStringData(tab, i, j++);

        waitElement(formPage.lastNameField);
        lname = excelReader.getStringData(tab, i, j++);

        waitElement(formPage.userEmailField);
        email = excelReader.getStringData(tab, i, j++);
        gender = excelReader.getStringData(tab, i, j++);


        waitElement(formPage.mobileNumberField);
        mNumber = excelReader.getStringData(tab, i, j++);
        dateOfBirth = excelReader.getStringData(tab, i, j++);

        address = excelReader.getStringData(tab, i, j++);
        country = excelReader.getStringData(tab, i, j++);
        city = excelReader.getStringData(tab, i, j++);

        hobbie = excelReader.getStringData(tab, i, j++);
        listOfHobbies.add(hobbie);
        hobbie = excelReader.getStringData(tab, i, j++);
        listOfHobbies.add(hobbie);


        subject = excelReader.getStringData(tab, i, j++);
        subjects.add(subject);
        subject = excelReader.getStringData(tab, i, j++);
        subjects.add(subject);
        subject = excelReader.getStringData(tab, i, j);
        subjects.add(subject);

    }

    public void doubleClickAction(WebElement wElement){

        action.doubleClick(wElement).perform();
    }
    public void oneClickAction(WebElement wElement){

        action.click(wElement).perform();
    }
    public void rightClickAction(WebElement wElement){
        action.contextClick(wElement).perform();
    }
}
