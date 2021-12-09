package pages;

import commons.Constants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class CalculatorMailToPage {
    WebDriver driver;
    String email;
    String urlMailService;


    @FindBy(xpath = "//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy']/div/b")
    private WebElement calculatorTotalCost;  //not nessesary ?

    @FindBy(xpath = "//a[@href='email-generator']/i")
    private WebElement ButtonForMailGeneration;

    @FindBy(id = "egen")
    private WebElement generatedEmail;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement myFrame;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][@aria-label='Email Estimate']")
    private WebElement mailEstimateButton;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailInputter;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public CalculatorMailToPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void generateMailService() {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get(driver.getCurrentUrl());
        String windowCalculator = driver.getWindowHandle();
        js.executeScript("window.open()");
        Set<String> currentWindws = driver.getWindowHandles();
        urlMailService = null;
        for (String window : currentWindws) {
            if (!window.equals(windowCalculator)) {
                urlMailService = window;
                break;
            }
        }
        driver.switchTo().window(urlMailService);
        driver.get(Constants.getMailService());
        ButtonForMailGeneration.click();
        email = generatedEmail.getText();
        driver.switchTo().window(windowCalculator);
    }

    public MailBoxPage sendMail() {
        driver.switchTo().frame(0);
        driver.switchTo().frame(myFrame);
        mailEstimateButton.click();
        emailInputter.sendKeys(email);
        sendEmailButton.click();
        driver.switchTo().window(urlMailService);
        return new MailBoxPage(driver);
    }
}
