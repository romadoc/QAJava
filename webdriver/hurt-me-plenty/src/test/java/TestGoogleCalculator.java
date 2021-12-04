import commons.Constants;
import commons.ConstantsSuccessPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SuccessPage;
import services.CalculatorPageService;
import unit.BaseTest;


public class TestGoogleCalculator extends BaseTest {
    Constants constants = new Constants();
    ConstantsSuccessPage constantsSuccessPage = new ConstantsSuccessPage();
    private final String URL = constants.getCALCULATOR_PAGE_URL();
    SuccessPage successPage;

    @BeforeClass
    @Override
    public void startDriver() {
        super.startDriver(URL);
        CalculatorPageService calculatorPageService = new CalculatorPageService(driver);
        successPage = calculatorPageService.startCalculator();
    }

    @Test
    public void testIsVMClassCorrect() {
        Assert.assertEquals(successPage.getVMclass(), constantsSuccessPage.getVN_CLASS(),
                "VMclass is not 'Regular'");
    }

    @Test
    public void testIsRegionCorrect() {
        Assert.assertEquals(successPage.getRegion(), constantsSuccessPage.getREGION(),
                "Region is not 'Frankfurt'");
    }

    @Test
    public void testIsCommitmentTermCorrect() {
        Assert.assertEquals(successPage.getTerm(), constantsSuccessPage.getTERM(),
                "commitment term is not 'Commitment term: 1 Year'");
    }

    @Test
    public void testIsInstanceTypeCorrect() {
        Assert.assertEquals(successPage.getInstanceTypeCPU(), constantsSuccessPage.getCPU(),
                "vCPU & RUM is not correct");
    }

    @Test
    public void testIsLocalSSdCorrect() {
        Assert.assertEquals(successPage.getLocalSSD(), constantsSuccessPage.getSSD(),
                "check 'local SSD'");
    }

    @Test
    public void testIsSumPerMonthCorrect() {
        Assert.assertEquals(successPage.getTotalSum(), constantsSuccessPage.getSUM(),
                "sum should be 1,082.77 per 1 month");
    }

}


