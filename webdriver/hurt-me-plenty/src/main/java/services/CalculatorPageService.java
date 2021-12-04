package services;

import org.openqa.selenium.WebDriver;
import pages.CalculatorPage;
import pages.SuccessPage;

public class CalculatorPageService {
    private WebDriver driver;

    public CalculatorPageService(WebDriver driver) {
        this.driver = driver;
    }

    public SuccessPage startCalculator() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.fillCalculatorWithData();
        SuccessPage successPage = new SuccessPage(driver);
        return successPage;
    }
}
