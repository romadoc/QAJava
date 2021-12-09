package services;

import org.openqa.selenium.WebDriver;
import pages.Calculator;

public class CalculatorPageService {
    private WebDriver driver;

    public CalculatorPageService(WebDriver driver) {
        this.driver = driver;
    }

    public Calculator startCalculator() {
        Calculator calculator = new Calculator(driver);
        calculator.enterComputeEngine();
        calculator.enterNumbersOfInstances();
        calculator.enterOperatingSystem();
        calculator.enterMachineClass();
        calculator.enterSeries();
        calculator.enterMachineType();
        calculator.chooseGPUs();
        calculator.chooseGPUtype();
        calculator.chooseGPUsNumber();
        calculator.enterDatacenterLocation();
        calculator.enterLocalSSD();
        calculator.enterCommittedUsage();
        calculator.pressButtonAddToEstimate();
        return calculator;
    }
}
