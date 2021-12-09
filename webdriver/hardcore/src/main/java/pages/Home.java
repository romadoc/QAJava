package pages;

import commons.Constants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;
    @FindBy(xpath = "//div[@class = 'devsite-search-container']")
    private WebElement findButton;

    @FindBy(xpath = "//div[@class = 'devsite-searchbox']/input[@name='q']")
    private WebElement inputFindElement;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pressButtonSearch() {
        findButton.click();
    }

    public void fillInputFindElement() {
        inputFindElement.sendKeys(Constants.getHomeSearchString(), Keys.ENTER);
    }
}
