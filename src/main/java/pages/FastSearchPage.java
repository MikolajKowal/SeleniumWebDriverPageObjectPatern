package pages;

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
        new Select(fastSearchLocators.getMark()).selectByVisibleText(mark);
    }

    public void selectModel(String model)
    {
        new Select(fastSearchLocators.getModel()).selectByVisibleText(model);
    }

    public void selectKilometer(String kilometer)
    {
        new Select(fastSearchLocators.getKilometer()).selectByVisibleText(kilometer);
    }

    public void selectCity(String city)
    {
        fastSearchLocators.getCity().sendKeys(city);
        fastSearchLocators.getCity().sendKeys(Keys.TAB);
    }

    public void search()
    {
        fastSearchLocators.getSearchButton().click();
    }
}
