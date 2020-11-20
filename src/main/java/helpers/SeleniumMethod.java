package helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumMethod {

    public static void selectByTextFromDropDown(WebElement element, String expecteText) {
        new Select(element).selectByVisibleText(expecteText);
    }

    public static void selectByTextFromElementList(List<WebElement> list, String expectedText){
        for (int i=0; i < list.size(); i++)
        {
            if(list.get(i).getText().contains(expectedText))
            {
                list.get(i).click();
                break;
            }
        }
    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static void sendTextToElementAndLooseFocus(WebElement element, String expectedText) {
        element.sendKeys(expectedText);
        element.sendKeys(Keys.TAB);
    }
}
