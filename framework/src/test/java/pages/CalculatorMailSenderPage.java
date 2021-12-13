package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class CalculatorMailSenderPage extends AbstractPage {
    private String email;
    private String urlMailService;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonSendEstimate;

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

    @FindBy(xpath = "//div[@class='nw']/button[2]")
    private WebElement checkMailButton;


    protected CalculatorMailSenderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public MailBoxPage openMailBoxPage() {
        String calculMailToUrl = driver.getCurrentUrl();
        generateMailAddress();

        driver.switchTo().frame(0);
        driver.switchTo().frame(myFrame);
        buttonSendEstimate.click();
        emailInputter.sendKeys(email);
        sendEmailButton.click();
        driver.switchTo().window(urlMailService);
        checkMailButton.click();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new MailBoxPage(driver);
    }

    private String generateMailAddress() {
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
        driver.get("https://yopmail.com/");
        ButtonForMailGeneration.click();
        email = generatedEmail.getText();
        driver.switchTo().window(windowCalculator);
        return email;
    }
}
