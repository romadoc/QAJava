import commons.Constants;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import services.CalculatorPageService;
import services.CompareSumService;
import services.StartPageService;
import unit.BaseTest;


public class TestGoogleCalculator extends BaseTest {

    SuccessPage successPage;
    CalculatorMailToPage calculatorMailToPage;
    MailBoxPage mailBoxPage;
    String countedSum;
    String mailedSum;

    @BeforeClass
    @Override
    public void startDriver() {

        super.startDriver();

    }

    @Test
    public void testScenario() {

        StartPageService startPageService = new StartPageService(driver);
        CalculatorPageService calculatorPageService = startPageService.initiateSearch();
        successPage = calculatorPageService.startCalculator().pressButtonAddToEstimate();
        countedSum = successPage.getTotalSum();
        calculatorMailToPage = successPage.emailEstimate();
        calculatorMailToPage.generateMailService();
        mailBoxPage = calculatorMailToPage.sendMail();
        mailBoxPage.checkMail();
        mailedSum = mailBoxPage.getSumInMail();
        CompareSumService compareSumService = new CompareSumService();

        Assert.assertTrue(compareSumService.compareSum(countedSum, mailedSum));

    }

}


