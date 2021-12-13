package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalculatorMailSenderPage;
import pages.MailBoxPage;

public class MailServiceTest extends CommonConditions {
    String calculatedSum;

    @Test
    public void testIsMailedEstimateOK() {
        calculatedSum = estimatePage.getCountedSumLabelValue().getText();
        CalculatorMailSenderPage calculatorMailSenderPage = estimatePage.openCalculatorMailSenderPage();
        MailBoxPage mailBoxPage = calculatorMailSenderPage.openMailBoxPage();
        Assert.assertTrue(calculatedSum.contains(mailBoxPage.readSumInMail()));
    }
}
