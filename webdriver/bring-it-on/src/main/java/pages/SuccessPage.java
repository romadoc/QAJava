package pages;
import constants.SuccessElements;
import org.openqa.selenium.WebDriver;

public class SuccessPage {
    private SuccessElements successElements = new SuccessElements();
    private WebDriver driver;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return successElements.getSuccessPageTitle();
    }

    public String getTextCode() {
        return driver.findElement(successElements.getCodeContent()).getText();
    }

}
