package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultSearch {

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']/div/a[@href='https://cloud.google.com/products/calculator/?hl=sv']")
    private WebElement linkToCalculator;

    public ResultSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void goToCalculatorPage() {
        linkToCalculator.click();
    }
}
