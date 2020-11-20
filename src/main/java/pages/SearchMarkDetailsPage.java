package pages;

import helpers.SeleniumMethod;
import locators.SearchMarkDetailsLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchMarkDetailsPage {

    WebDriver driver;
    WebDriverWait wait;
    SearchMarkDetailsLocators searchMarkDetailsLocators;

    public SearchMarkDetailsPage(WebDriver driver)
    {
        this.driver = driver;
        searchMarkDetailsLocators = new SearchMarkDetailsLocators();
        PageFactory.initElements(driver, searchMarkDetailsLocators);
        wait = new WebDriverWait(driver, 10);
    }

    public void searchCarList()
    {
        searchMarkDetailsLocators.getInfo().click();
        searchMarkDetailsLocators.getAllCarsAndModels().click();
    }

    public void selectMark(String mark)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchMarkDetailsLocators.getCarList()));
        SeleniumMethod.selectByTextFromElementList(searchMarkDetailsLocators.getCarList(), mark);
    }

    public void selectModel(String model)
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchMarkDetailsLocators.getCarModelList()));
        SeleniumMethod.selectByTextFromElementList(searchMarkDetailsLocators.getCarModelList(), model);
    }

    public String getMarkAndModel()
    {
        wait.until(ExpectedConditions.visibilityOf(searchMarkDetailsLocators.getCarNameAndSerie()));
        return searchMarkDetailsLocators.getCarNameAndSerie().getText();
    }
}


