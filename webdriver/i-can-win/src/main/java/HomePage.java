import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private final By codeInput = By.xpath("//*[@id='postform-text']");
    private final By expiration = By.xpath("//span[@id='select2-postform-expiration-container']");
    private final By titleInput = By.xpath("//*[@id='postform-name']");
    private final By buttonCreateNew = By.xpath("//button[text()='Create New Paste']");
    private final String code = "Hello from WebDriver";
    private final String titleText = "helloweb";
    private final String expirationText = "10 Minutes";
    private final WebDriver driver;

    public String getCode() {
        return code;
    }

    public String getTitleText() {
        return titleText;
    }

    public String getExpirationText() {
        return expirationText;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage createNewPaste() {
        driver.findElement(codeInput).sendKeys(code);
        driver.findElement(expiration).click();
        List<WebElement> expVariants = driver.findElements(By.xpath("//li[@class]"));
        expVariants.get(2).click();
        driver.findElement(titleInput).sendKeys(titleText);
        driver.findElement(buttonCreateNew).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

}
