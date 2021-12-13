package pages;

import commons.CalculatorPageElements;
import model.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.OrderCreator;

import java.time.Duration;
import java.util.List;

public class CalculatorPage extends AbstractPage {
    Order order = OrderCreator.getTestOrder();

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

    protected CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        driver.switchTo().frame(0);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='myFrame']")));
        driver.switchTo().frame(myFrame);
    }

    public void enterComputeEngine() {
        inputSearchProduct.sendKeys(order.getComputeEngine());
        iconFindComputeEngine.click();

    }

    public void enterNumbersOfInstances() {
        inputNumberOfInstances.sendKeys(order.getNumber());

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
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CalculatorPageElements
                        .getRootForListXpath())));
        List<WebElement> listOfSeries = driver.findElements(By.xpath(CalculatorPageElements.getRootForListXpath()));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(listOfSeries.get(order.getSeries())));
        listOfSeries.get(order.getSeries()).click();

    }

    public void enterMachineType() {
        inputMachineType.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CalculatorPageElements
                        .getRootForListXpath())));
        List<WebElement> listOfvCPUs = driver.findElements(By.xpath(CalculatorPageElements.getRootForListXpath()));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(listOfvCPUs.get(order.getInstanceType())));
        listOfvCPUs.get(order.getInstanceType()).click();
    }

    public void chooseGPUs() {
        if (order.isAddGpu()) {
            inputAddGPUs.click();
        }
    }

    public void chooseGPUtype() {
        chooseGPUtype.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CalculatorPageElements
                        .getRootForListXpath())));
        List<WebElement> listGPUs = driver.findElements(By.xpath(CalculatorPageElements
                .getRootForListXpath()));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(listGPUs.get(order.getGpuType())));
        listGPUs.get(order.getGpuType()).click();
    }

    public void chooseGPUsNumber() {
        chooseNumberOfGPUs.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CalculatorPageElements
                        .getRootForListXpath())));
        List<WebElement> listQuantities = driver.findElements(By.xpath(CalculatorPageElements
                .getRootForListXpath()));
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.elementToBeClickable(listQuantities.get(order.getNumberGpu())));
        listQuantities.get(order.getNumberGpu()).click();
    }

    public void enterLocalSSD() {
        enterLocalSSD.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CalculatorPageElements
                        .getRootForListXpath())));
        List<WebElement> listOfSSD = driver.findElements(By.xpath(CalculatorPageElements
                .getRootForListXpath()));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(listOfSSD.get(order.getSsd())));
        listOfSSD.get(order.getSsd()).click();
    }

    public void enterDatacenterLocation() {
        inputDatacenterLocation.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CalculatorPageElements
                        .getLocationXpathForList())));
        List<WebElement> listLocation = driver.findElements(By.xpath(CalculatorPageElements
                .getLocationXpathForList()));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(listLocation.get(order.getLocation())));
        listLocation.get(order.getLocation()).click();
    }

    public void enterCommittedUsage() {
        inputComittedUsage.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(CalculatorPageElements
                        .getCommitedUsageXpathForList())));
        List<WebElement> listOfUsage = driver.findElements(By.xpath(CalculatorPageElements
                .getCommitedUsageXpathForList()));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(listOfUsage.get(order.getCommitedUsage())));
        listOfUsage.get(order.getCommitedUsage()).click();

    }



    public EstimatePage openEstimatePage() {
        enterComputeEngine();
        enterNumbersOfInstances();
        enterOperatingSystem();
        enterMachineClass();
        enterSeries();
        enterMachineType();
        chooseGPUs();
        chooseGPUtype();
        chooseGPUsNumber();
        enterLocalSSD();
        enterDatacenterLocation();
        enterCommittedUsage();
        buttonAddToEstimate.click();

        return new EstimatePage(driver);
    }
}
