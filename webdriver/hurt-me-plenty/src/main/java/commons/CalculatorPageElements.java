package commons;

import org.openqa.selenium.By;

public class CalculatorPageElements {
    private final By frameWithIndexTwo = By.xpath("//iframe[@id='myFrame']");
    public By getFrameWithIndexTwo() {
        return frameWithIndexTwo;
    }

    private final By chooseComputeEngine = By.xpath("//*[@id='input-0']");
    public By getChooseComputeEngine() {
        return chooseComputeEngine;
    }

    private final By iconFindComputeCategory = By.xpath("//*[@id='mainForm']/div[1]/md-icon");
    public By getIconFindComputeCategory() {
        return iconFindComputeCategory;
    }

    private final By inputInstances = By.xpath("//input[@ng-model='listingCtrl.computeServer.quantity']");
    public By getInputInstances() {
        return inputInstances;
    }

    private final By calculatorPageVMSelector = By.xpath("//*[@id='select_92']");
    public By getCalculatorPageVMSelector() {
        return calculatorPageVMSelector;
    }

    private final By calculatorPageInputVMClass = By.xpath("//div[@id='select_container_93']" +
            "/md-select-menu/md-content/md-option/div[@class='md-text'][text()='Regular']");
    public By getCalculatorPageInputVMClass() {
        return calculatorPageInputVMClass;
    }

    private final By calculatorPageChoosenOsAndSoftware = By.xpath("//*[@id='select_option_77']");
    public By getCalculatorPageChoosenOsAndSoftware() {
        return calculatorPageChoosenOsAndSoftware;
    }

    private final By calculatorPageInputOSAndSoftwareSelector = By.xpath("//md-select[@ng-model=" +
            "'listingCtrl.computeServer.os']");
    public By getCalculatorPageInputOSAndSoftwareSelector() {
        return calculatorPageInputOSAndSoftwareSelector;
    }

    private final By calculatorPageSeriesSelector = By.xpath("//md-select[@placeholder='Series']");
    public By getCalculatorPageSeriesSelector() {
        return calculatorPageSeriesSelector;
    }

    private String rootForListXpath = "//div[contains(@class, 'md-select-menu-container md-active md-clickable')]" +
            "//md-option/div[@class='md-text ng-binding']";
    public String getRootForListXpath() {
        return rootForListXpath;
    }

    private String cpuSelectorXpath = "//*[@id='select_102']";
    public String getCpuSelectorXpath() {
        return cpuSelectorXpath;
    }

    private String checkBoxSelectorXpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']";
    public String getCheckBoxSelectorXpath() {
        return checkBoxSelectorXpath;
    }

    private String gpuTypeXpathSelector = "//md-select[@placeholder='GPU type']";
    public String getGpuTypeXpathSelector() {
        return gpuTypeXpathSelector;
    }

    private String numberOfGPUsXpathSelector = "//md-select[@placeholder='Number of GPUs']";
    public String getNumberOfGPUsXpathSelector() {
        return numberOfGPUsXpathSelector;
    }

    private String localSSdXpathSelector = "//md-select[@placeholder='Local SSD']";
    public String getLocalSSdXpathSelector() {
        return localSSdXpathSelector;
    }

    private String locationDatacenterXpathSelector = "//md-select[@placeholder='Datacenter location']";
    public String getLocationDatacenterXpathSelector() {
        return locationDatacenterXpathSelector;
    }

    private String locationXpathForList = "//div[contains(@class, 'md-select-menu-container " +
            "cpc-region-select md-active md-clickable')]//md-optgroup/md-option[@class='ng-scope md-ink-ripple']" +
            "//div[@class='md-text ng-binding']";
    public String getLocationXpathForList() {
        return locationXpathForList;
    }

    private String commitUsageXpathSelector = "//md-select[@placeholder='Committed usage']";
    public String getCommitUsageXpathSelector() {
        return commitUsageXpathSelector;
    }

    private String commitedUsageXpathForList = "//div[contains(@class, 'md-select-menu-container md-active md-clickable')]" +
            "//md-option/div[@class='md-text']";
    public String getCommitedUsageXpathForList() {
        return commitedUsageXpathForList;
    }

    private String addToEstimateXpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][1]";

    public String getAddToEstimateXpath() {
        return addToEstimateXpath;
    }
}
