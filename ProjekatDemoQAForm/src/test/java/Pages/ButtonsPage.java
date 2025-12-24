package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class ButtonsPage extends BaseTest {

    public ButtonsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(tagName = "html")
    public WebElement html;

    public WebElement body(){
        return html.findElement(By.tagName("body"));
    }


    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickButton;

    @FindBy(xpath = "//div[3]/button")
    public WebElement buttonC;

    @FindBy(tagName = "button")
    public List<WebElement> buttonsList;

    @FindBy(id="doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement oneClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightOnclickMessage;
    //******************************************

    public WebElement chooseButton(String s){

        WebElement element=null;
        for (int i=0; i<buttonsList.size(); i++){
            if(buttonsList.get(i).getText().equalsIgnoreCase(s)){
                element = buttonsList.get(i);
            }
        }
        return element;
    }

    public String doubleClickOnButton(){
        return "Double Click Me";
    }

    public String clickOnClickButton(){
        // buttonC.click();
        return "Click Me";
    }
    public String rightClickOnButton(){
        return "Right Click Me";
    }

}
