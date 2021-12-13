package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    private static final String HOME_SEARCH_STRING = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//div[@class = 'devsite-search-container']")
    private WebElement findButton;

    @FindBy(xpath = "//div[@class = 'devsite-searchbox']/input[@name='q']")
    private WebElement inputFindElement;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage pressButtonSearch() {
        findButton.click();
        return this;
    }


    public ResultSearchPage openResultSearchPage() {
        inputFindElement.sendKeys(HOME_SEARCH_STRING, Keys.ENTER);
        return new ResultSearchPage(driver);
    }
}
