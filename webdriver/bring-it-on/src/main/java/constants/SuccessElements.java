package constants;

import org.openqa.selenium.By;

public class SuccessElements {
    TextContains textContains = new TextContains();
    private By syntaxBash = By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/textarea//div/text()");
    private By codeContent = By.xpath("//div[@class='source']");

    public By getCodeContent() {
        return codeContent;
    }

    public String getSuccessPageTitle() {
        String postTitle = " - Pastebin.com";
        return  textContains.getTitleText() + postTitle;
    }

}
