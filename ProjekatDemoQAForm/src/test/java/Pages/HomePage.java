package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "card-body")
    public List<WebElement> menuListOptions;


    //******************************************************************
    public void clickOnElements(String str) {
        for (int i = 0; i < menuListOptions.size(); i++) {
            if (menuListOptions.get(i).getText().equals(str)) {
                menuListOptions.get(i).click();
                break;
            }
        }
    }


}
