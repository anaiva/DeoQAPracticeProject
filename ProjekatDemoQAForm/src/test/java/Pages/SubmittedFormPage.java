package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SubmittedFormPage extends BaseTest {
    public SubmittedFormPage(){
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "table[class^='table']")
    public WebElement submittedTable;

    public List<WebElement> getSubmittedTable(){
        return submittedTable.findElements(By.tagName("td"));
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement submittedFormMessage;

    @FindBy(id = "closeLargeModal")
    public WebElement closeButton;

    //***************************************************

    public void closeSubmittedForm(){

        closeButton.click();
    }
    //proverava da li su polja u submitovanoj formi popunjena tj, nisu prazna
    public void checkSubmittedFormIsNotEmpty(){
        for (int i =0; i< getSubmittedTable().size()/2-1; i++){

            Assert.assertFalse(getSubmittedTable().get(2*i+1).getText().isEmpty());

        }
    }

}
