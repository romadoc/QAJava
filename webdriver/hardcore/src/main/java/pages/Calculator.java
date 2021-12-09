package pages;

import commons.CalculatorPageElements;
import commons.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calculator {
    private final WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//*[@id='input-0']")
    private WebElement inputSearchProduct;

    @FindBy(xpath = "//*[@id='mainForm']/div[1]/md-icon")
    private WebElement iconFindComputeEngine;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement inputNumberOfInstances;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement inputOperatingSystem;

    @FindBy(xpath = "//*[@id='select_option_77']")
    private WebElement chooseOperatingSystem;

    @FindBy(xpath = "//*[@id='select_92']")
    private WebElement inputMachineClass;

    @FindBy(xpath = "//div[@id='select_container_93']/md-select-menu/md-content/md-option/div[@class='md-text'][text()='Regular']")
    private WebElement chooseMachineClass;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement inputSeries;

    @FindBy(xpath = "//*[@id='select_102']")
    private WebElement inputMachineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement inputAddGPUs;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement chooseGPUtype;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement chooseNumberOfGPUs;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement enterLocalSSD;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement inputDatacenterLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement inputComittedUsage;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'][1]")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement myFrame;

    public Calculator(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driver.switchTo().frame(0);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        goInsideOfFrame();
        wait = new WebDriverWait(driver, 10);

    }

    public void goInsideOfFrame() {
        driver.switchTo().frame(myFrame);
    }

    public void enterComputeEngine() {
        inputSearchProduct.sendKeys(Constants.getCOMPUTE_ENGINE());
        iconFindComputeEngine.click();

    }

    public void enterNumbersOfInstances() {
        inputNumberOfInstances.sendKeys(Constants.getNUMBER_OF_INSTANCES());
    }

    public void enterOperatingSystem() {
        inputOperatingSystem.click();
        chooseOperatingSystem.click();

    }

    public void enterMachineClass() {
        inputMachineClass.click();
        chooseMachineClass.click();
    }

    public void enterSeries() {
        inputSeries.click();
        List<WebElement> listOfSeries = driver.findElements(By.xpath(CalculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfSeries.get(0)));
        listOfSeries.get(0).click();

    }

    public void enterMachineType() {
        inputMachineType.click();
        List<WebElement> listOfvCPUs = driver.findElements(By.xpath(CalculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfvCPUs.get(3)));
        listOfvCPUs.get(3).click();
    }

    public void chooseGPUs() {
        inputAddGPUs.click();
    }

    public void chooseGPUtype() {
        chooseGPUtype.click();
        List<WebElement> listGPUs = driver.findElements(By.xpath(CalculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listGPUs.get(3)));
        listGPUs.get(3).click();
    }

    public void chooseGPUsNumber() {
        chooseNumberOfGPUs.click();
        List<WebElement> listQuantities = driver.findElements(By.xpath(CalculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listQuantities.get(1)));
        listQuantities.get(1).click();
    }

    public void enterLocalSSD() {
        enterLocalSSD.click();
        List<WebElement> listOfSSD = driver.findElements(By.xpath(CalculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfSSD.get(2)));
        listOfSSD.get(2).click();
    }

    public void enterDatacenterLocation() {
        inputDatacenterLocation.click();
        List<WebElement> listLocation = driver.findElements(By.xpath(CalculatorPageElements.getLocationXpathForList()));
        wait.until(ExpectedConditions.elementToBeClickable(listLocation.get(9)));
        listLocation.get(9).click();
    }

    public void enterCommittedUsage() {
        inputComittedUsage.click();
        List<WebElement> listOfUsage = driver.findElements(By.xpath(CalculatorPageElements.getCommitedUsageXpathForList()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfUsage.get(1)));
        listOfUsage.get(1).click();

    }

    public SuccessPage pressButtonAddToEstimate() {
        buttonAddToEstimate.click();
        return new SuccessPage(driver);
    }

}
