import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {
    HomePage homePage;
    WebDriver driver;
    public SuccessPage(HomePage homePage, WebDriver driver) {
        this.homePage = homePage;
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(By.xpath("//div[@class='info-top']/h1")).getText();
    }

    public String getExpirationText() {
        return driver.findElement(By.xpath("//span[@id='select2-postform-expiration-container']")).getText();
    }

    public String getCode() {
        return driver.findElement(By.xpath("//div[@class='de1']")).getText();
    }

}
