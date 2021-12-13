package commons;

public class CalculatorPageElements {

    public static String getRootForListXpath() {
        String rootForListXpath = "//div[contains(@class, 'md-select-menu-container md-active md-clickable')]" +
                "//md-option/div[@class='md-text ng-binding']";
        return rootForListXpath;
    }

    public static String getLocationXpathForList() {
        String locationXpathForList = "//div[contains(@class, 'md-select-menu-container " +
                "cpc-region-select md-active md-clickable')]//md-optgroup/md-option[@class='ng-scope md-ink-ripple']" +
                "//div[@class='md-text ng-binding']";
        return locationXpathForList;
    }

    public static String getCommitedUsageXpathForList() {
        String commitedUsageXpathForList = "//div[contains(@class, 'md-select-menu-container md-active md-clickable')]" +
                "//md-option/div[@class='md-text']";
        return commitedUsageXpathForList;
    }

}
