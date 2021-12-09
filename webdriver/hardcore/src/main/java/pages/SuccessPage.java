package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
    private final WebDriver driver;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//form[@name='emailForm']")
    private WebElement emailForm;

    @FindBy(xpath = "//h2[@class='md-title']/b")
    private WebElement countedSumLabel;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorMailToPage emailEstimate() {
        buttonEmailEstimate.click();
        return new CalculatorMailToPage(driver);
    }

    public String getTotalSum() {
        return countedSumLabel.getText();
    }

}
