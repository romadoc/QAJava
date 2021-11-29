package pages;

import constants.Elements;
import constants.TextContains;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    Elements elements = new Elements();
    TextContains textContains = new TextContains();

    public HomePage createNewPaste() {
        driver.findElement(elements.getCodeInput()).sendKeys(textContains.getCode());
        driver.findElement(elements.getSyntaxHilitingContainer()).click();
        List<WebElement> hightlightVariants = driver.findElements(elements.getSyntaxSelectionForList());
        WebElement choosenHightlightVariant = hightlightVariants.get(0);
        choosenHightlightVariant.click();
        driver.findElement(elements.getExpiration()).click();
        List<WebElement> expVariants = driver.findElements(elements.getExpirationDropDownMenu());
        expVariants.get(2).click();
        driver.findElement(elements.getTitleInput()).sendKeys(textContains.getTitleText());
        driver.findElement(elements.getButtonCreateNewPaste()).click();
        return this;
    }

}


