package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import pages.CalculatorPage;
import pages.EstimatePage;
import pages.HomePage;
import pages.ResultSearchPage;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://cloud.google.com/";
    EstimatePage estimatePage;

    @BeforeClass
    public void createEstimatePage() {
        driver = DriverSingleton.getDriver();
        driver.get(BASE_URL);
        HomePage homePage = new HomePage(driver);
        ResultSearchPage resultSearchPage = homePage
                .pressButtonSearch()
                .openResultSearchPage();
        CalculatorPage calculatorPage = resultSearchPage.openCalculatorPage();
        estimatePage = calculatorPage.openEstimatePage();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
