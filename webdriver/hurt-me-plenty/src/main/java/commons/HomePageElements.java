package commons;

import org.openqa.selenium.By;

public class HomePageElements {

    private final By homePageSearchButton = By.xpath("//div[@class = 'devsite-search-container']");
    private final By homePageInputSearchArea = By.xpath("//div[@class = 'devsite-searchbox']/input[@name='q']");
    public By getHomePageSearchButton() {
        return homePageSearchButton;
    }

    public By getHomePageInputSearchArea() {
        return homePageInputSearchArea;
    }

    private final By resultSearchGoToCalculator = By.xpath("//div[@class='gsc-thumbnail-inside']" +
            "//a[@data-ctorig='https://cloud.google.com/products/calculator/?hl=sv']");
    public By getResultSearchGoToCalculator() {
        return resultSearchGoToCalculator;
    }

}
