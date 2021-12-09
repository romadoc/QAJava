package services;

import org.openqa.selenium.WebDriver;
import pages.Home;
import pages.ResultSearch;


public class StartPageService {
    private WebDriver driver;

    public StartPageService(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorPageService initiateSearch() {
        Home home = new Home(driver);
        home.pressButtonSearch();
        home.fillInputFindElement();
        ResultSearch resultSearch = new ResultSearch(driver);
        resultSearch.goToCalculatorPage();
        CalculatorPageService calculatorPageService = new CalculatorPageService(driver);
        return calculatorPageService;
    }
}
