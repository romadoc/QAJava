package pages;

import commons.Constants;
import commons.HomePageElements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    HomePageElements homePageElements = new HomePageElements();
    Constants constants = new Constants();
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSearch() {
        driver.findElement(homePageElements.getHomePageSearchButton()).click();
        driver.findElement(homePageElements.getHomePageInputSearchArea()).sendKeys(constants.getHomeSearchString());
        driver.findElement(homePageElements.getHomePageInputSearchArea()).sendKeys(Keys.ENTER);

    }
}
