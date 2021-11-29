package constants;

import org.openqa.selenium.By;

public class Elements {
    private final By codeInput = By.xpath("//*[@id='postform-text']");
    private final By expiration = By.xpath("//span[@id='select2-postform-expiration-container']");
    private final By titleInput = By.xpath("//*[@id='postform-name']");
    private final By buttonCreateNewPaste = By.xpath("//button[text()='Create New Paste']");
    private final By expirationDropDownMenu = By.xpath("//li[@class]");
    private final By syntaxHilitingContainer = By.xpath("//span[@id='select2-postform-format-container']");
    private final By syntaxSelectionForList = By.xpath("//ul[@class='select2-results__options select2-results__options--nested']/li");

    public By getSyntaxHilitingContainer() {
        return syntaxHilitingContainer;
    }

    public By getSyntaxSelectionForList() {
        return syntaxSelectionForList;
    }

    public By getExpirationDropDownMenu() {
        return expirationDropDownMenu;
    }

    public By getCodeInput() {
        return codeInput;
    }

    public By getExpiration() {
        return expiration;
    }

    public By getTitleInput() {
        return titleInput;
    }

    public By getButtonCreateNewPaste() {
        return buttonCreateNewPaste;
    }
}
