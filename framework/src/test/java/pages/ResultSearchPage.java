package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultSearchPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator/?hl=sv']")
    private WebElement linkToCalculator;

    public ResultSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public CalculatorPage openCalculatorPage() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                .presenceOfElementLocated
                (By.xpath("//a[@data-ctorig='https://cloud.google.com/products/calculator/?hl=sv']")));
        linkToCalculator.click();
        return new CalculatorPage(driver);
    }
}
