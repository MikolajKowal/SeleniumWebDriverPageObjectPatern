import helpers.FileHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FastSearchPage;
import pages.SearchMarkDetailsPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeleiumPOP {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mikik/Desktop/SDA/Selenium WebDriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.mobile.de");
        FileHelper.createFile();
    }

    @Test
    @Ignore
    public void wyszukiwaniePojazdu()
    {
        FastSearchPage fastSearchPage = new FastSearchPage(driver);
        fastSearchPage.selectMark("Audi");
        fastSearchPage.selectModel("A4");
        fastSearchPage.selectKilometer("100.000 km");
        fastSearchPage.selectCity("Berlin");
        fastSearchPage.search();
    }

    @Test
    public void pobieranieInformacjiOMarceIModelu()
    {
        SearchMarkDetailsPage searchMarkDetailsPage = new SearchMarkDetailsPage(driver);
        searchMarkDetailsPage.searchCarList();
        FileHelper.writeToFile("test tekst");
        searchMarkDetailsPage.selectMark("Audi");
        searchMarkDetailsPage.selectModel("Audi A4");
        assertThat(searchMarkDetailsPage.getMarkAndModel(), containsString("Audi A4 (Serie)"));
        FileHelper.writeToFile("test new tekst");
        System.out.println("\n" + "Wyświetlona nazwa modelu to: " + searchMarkDetailsPage.getMarkAndModel());
    }

    @After
    public void closeWindow()
    {
        driver.quit();
        FileHelper.closeWriter();
    }
}
