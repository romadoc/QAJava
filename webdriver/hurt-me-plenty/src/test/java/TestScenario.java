import commons.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultSearchPage;
import unit.BaseTest;

public class TestScenario extends BaseTest {
    Constants constants = new Constants();
    @Test(description = "first step of scenario is OK calc is open")
    public void testInitialStagesOkAndCalculatorIsOpen() {
        HomePage homePage = new HomePage(driver);
        homePage.openSearch();
        ResultSearchPage resultSearchPage = new ResultSearchPage(driver);
        resultSearchPage.goToCalculator();
        Assert.assertEquals(driver.getCurrentUrl(), constants.getCALCULATOR_PAGE_URL(),
                "Google Cloud " +
                "Platform Pricing Calculator is not activated");
    }
}
