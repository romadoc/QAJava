package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimatePage extends AbstractPage {

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[contains(text(),'VM class:')]")
    private WebElement vmClassValue;

    @FindBy(xpath = "//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy']/div[contains(text(),'Instance type:')]")
    private WebElement instanceTypeValue;

    @FindBy(xpath = "//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy']/div[contains(text(),'Region')]")
    private WebElement regionValue;

    @FindBy(xpath = "//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[contains(text(),'Local SSD:')]")
    private WebElement localSSDValue;

    @FindBy(xpath = "//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[contains(text(),'Commitment')]")
    private WebElement termValue;

    @FindBy(xpath = "//h2[@class='md-title']/b")
    private WebElement countedSumLabelValue;

    protected EstimatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getVmClassValue() {
        return vmClassValue;
    }

    public WebElement getInstanceTypeValue() {
        return instanceTypeValue;
    }

    public WebElement getRegionValue() {
        return regionValue;
    }

    public WebElement getLocalSSDValue() {
        return localSSDValue;
    }

    public WebElement getTermValue() {
        return termValue;
    }

    public WebElement getCountedSumLabelValue() {
        return countedSumLabelValue;
    }


    public CalculatorMailSenderPage openCalculatorMailSenderPage() {
        buttonEmailEstimate.click();
        return new CalculatorMailSenderPage(driver);
    }
}
