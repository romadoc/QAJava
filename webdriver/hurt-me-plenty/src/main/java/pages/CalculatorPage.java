package pages;

import commons.CalculatorPageElements;
import commons.Constants;
import commons.HomePageElements;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CalculatorPage {
    private final WebDriver driver;
    private final HomePageElements homePageElements = new HomePageElements();
    private final CalculatorPageElements calculatorPageElements = new CalculatorPageElements();
    private final Constants constants = new Constants();
    WebDriverWait wait;

    public CalculatorPage(WebDriver driver) {
          this.driver = driver;
    }

    public void fillCalculatorWithData() {

        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.switchTo().frame(0);

        WebElement frameIndexTwo = driver.findElement(calculatorPageElements.getFrameWithIndexTwo());
        driver.switchTo().frame(frameIndexTwo);

        driver.findElement(calculatorPageElements.getChooseComputeEngine()).sendKeys(constants.getCOMPUTE_ENGINE());
        driver.findElement(calculatorPageElements.getIconFindComputeCategory()).click();

        driver.findElement(calculatorPageElements.getInputInstances()).click();
        driver.findElement(calculatorPageElements.getInputInstances()).sendKeys(constants.getNUMBER_OF_INSTANCES());

        driver.findElement(calculatorPageElements.getCalculatorPageInputOSAndSoftwareSelector()).click();
        driver.findElement(calculatorPageElements.getCalculatorPageChoosenOsAndSoftware()).click();

        driver.findElement(calculatorPageElements.getCalculatorPageVMSelector()).click();
        driver.findElement(calculatorPageElements.getCalculatorPageInputVMClass()).click();

        //series - should be N1
        driver.findElement(calculatorPageElements.getCalculatorPageSeriesSelector()).click();
        List<WebElement> listOfSeries = driver.findElements(By.xpath(calculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfSeries.get(0)));
        listOfSeries.get(0).click();

        //choose Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        driver.findElement(By.xpath(calculatorPageElements.getCpuSelectorXpath())).click();
        List<WebElement> listOfvCPUs = driver.findElements(By.xpath(calculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfvCPUs.get(3)));
        listOfvCPUs.get(3).click();

        //ADD CPUs
        driver.findElement(By.xpath(calculatorPageElements.getCheckBoxSelectorXpath())).click();

        //GPU type: NVIDIA Tesla V100
        driver.findElement(By.xpath(calculatorPageElements.getGpuTypeXpathSelector())).click();
        List<WebElement> listGPUs = driver.findElements(By.xpath(calculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listGPUs.get(3)));
        listGPUs.get(3).click();

        //Number of GPUs: 1
        driver.findElement(By.xpath(calculatorPageElements.getNumberOfGPUsXpathSelector())).click();
        List<WebElement> listQuantities = driver.findElements(By.xpath(calculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listQuantities.get(1)));
        listQuantities.get(1).click();

        //Local SSD: 2x375 Gb
        driver.findElement(By.xpath(calculatorPageElements.getLocalSSdXpathSelector())).click();
        List<WebElement> listOfSSD = driver.findElements(By.xpath(calculatorPageElements.getRootForListXpath()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfSSD.get(2)));
        listOfSSD.get(2).click();

        //Datacenter location: Frankfurt (europe-west3)
        driver.findElement(By.xpath(calculatorPageElements.getLocationDatacenterXpathSelector())).click();
        List<WebElement> listLocation = driver.findElements(By.xpath(calculatorPageElements.getLocationXpathForList()));
        wait.until(ExpectedConditions.elementToBeClickable(listLocation.get(9)));
        listLocation.get(9).click();

        //Commited usage: 1 Year
        driver.findElement(By.xpath(calculatorPageElements.getCommitUsageXpathSelector())).click();
        List<WebElement> listOfUsage = driver.findElements(By.xpath(calculatorPageElements.getCommitedUsageXpathForList()));
        wait.until(ExpectedConditions.elementToBeClickable(listOfUsage.get(1)));
        listOfUsage.get(1).click();

        pressButtonAddtoEstimate();

    }

    private SuccessPage pressButtonAddtoEstimate() {
        driver.findElement(By.xpath(calculatorPageElements.getAddToEstimateXpath())).click();
        return new SuccessPage(driver);
    }

}
