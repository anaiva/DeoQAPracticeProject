package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormsPage extends BaseTest {

    public FormsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='text']")
    public List<WebElement> spanElements;

   //********************************************************

    public void findPracticeForm(String str){
        for (int i=0; i<spanElements.size(); i++){
            if (spanElements.get(i).getText().equalsIgnoreCase(str)){
                spanElements.get(i).click();
            }
        }
    }
}
