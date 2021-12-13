package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MailBoxPage extends AbstractPage {

    @FindBy(id = "refresh")
    private WebElement refrashButton;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    private WebElement mailFrame;

    @FindBy(xpath = "//table/tbody/tr[2]/td[2]/h3")
    private WebElement sum;


    protected MailBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public String readSumInMail() {
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
        return sum.getText();
    }
}
