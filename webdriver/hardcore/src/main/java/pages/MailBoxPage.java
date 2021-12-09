package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='nw']/button[2]")
    private WebElement checkMailButton;

    @FindBy(id = "refresh")
    private WebElement refrashButton;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    private WebElement mailFrame;

    @FindBy(xpath = "//table/tbody/tr[2]/td[2]/h3")
    private WebElement sum;

    public MailBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkMail() {

        wait = new WebDriverWait(driver, 10);
        checkMailButton.click();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        refrashButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.switchTo().frame(mailFrame);

    }
    public String getSumInMail() {
        return sum.getText();
    }
}
