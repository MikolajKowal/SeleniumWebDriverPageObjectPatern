package pages;

import helpers.SeleniumMethod;
import locators.FastSearchLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
 import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastSearchPage {

    WebDriver driver;
    WebDriverWait wait;
    FastSearchLocators fastSearchLocators;

    public FastSearchPage(WebDriver driver)
    {
        this.driver = driver;
        fastSearchLocators = new FastSearchLocators();
        PageFactory.initElements(driver, fastSearchLocators);
        wait = new WebDriverWait(driver, 20);
    }

    public void selectMark(String mark)
    {
        wait.until(ExpectedConditions.visibilityOf(fastSearchLocators.getMark()));
        SeleniumMethod.selectByTextFromDropDown(fastSearchLocators.getMark(), mark);
    }

    public void selectModel(String model)
    {
        SeleniumMethod.selectByTextFromDropDown(fastSearchLocators.getModel(), model);
    }

    public void selectKilometer(String kilometer)
    {
        SeleniumMethod.selectByTextFromDropDown(fastSearchLocators.getKilometer(), kilometer);
    }

    public void selectCity(String city)
    {
        SeleniumMethod.sendTextToElementAndLooseFocus(fastSearchLocators.getCity(), city);
    }

    public void search()
    {
        SeleniumMethod.clickOnElement(fastSearchLocators.getSearchButton());
    }
}
