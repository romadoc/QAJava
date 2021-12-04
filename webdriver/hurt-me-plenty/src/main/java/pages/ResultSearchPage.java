package pages;

import commons.HomePageElements;
import org.openqa.selenium.WebDriver;

public class ResultSearchPage {
    private final WebDriver driver;
    HomePageElements homePageElements = new HomePageElements();

    public ResultSearchPage(WebDriver driver) {
        this.driver = driver;
        driver.get(driver.getCurrentUrl());
    }

    public void goToCalculator() {
        driver.findElement(homePageElements.getResultSearchGoToCalculator()).click();
    }
}
