package constants;

import org.openqa.selenium.By;

public class TextContains {
    private final String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private final String highLighting = "Bash";
    private final String pasteExpiration = "10 Minutes";
    private final String titleText = "how to gain dominance among developers";
    private final String colorViolet = "#c20cb9";
    private final String colorCarrot = "#ff0000";
    private final By pointOne = By.cssSelector("span.kw2");
    private final By pointTwo = By.cssSelector("span.st0");

    public String getColorViolet() {
        return colorViolet;
    }

    public String getColorCarrot() {
        return colorCarrot;
    }

    public By getPointOne() {
        return pointOne;
    }

    public By getPointTwo() {
        return pointTwo;
    }

    public String getCode() {
        return code;
    }

    public String getHighLighting() {
        return highLighting;
    }

    public String getPasteExpiration() {
        return pasteExpiration;
    }

    public String getTitleText() {
        return titleText;
    }
}
