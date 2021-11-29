import constants.TextContains;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SuccessPage;
import unit.BaseTest;

public class TestScenario extends BaseTest {
    private HomePage homePage;
    private SuccessPage successPage;
    private TextContains textContains;

    @BeforeTest
    public void setupPages() {
        textContains = new TextContains();
        homePage = new HomePage(driver);
        successPage = new SuccessPage(driver);
    }

    @Test
    public void testScenario() {
        homePage.createNewPaste();

        String color = driver.findElement(textContains.getPointOne()).getCssValue("color");
        String hexOne = Color.fromString(color).asHex();

        String colorTwo = driver.findElement(textContains.getPointTwo()).getCssValue("color");
        String hexTwo = Color.fromString(colorTwo).asHex();

        Assert.assertEquals(textContains.getColorViolet(), hexOne, "not BASH formatted");
        Assert.assertEquals(textContains.getColorCarrot(), hexTwo, "not BASH formatted");

        Assert.assertEquals(successPage.getTextCode(),textContains.getCode(), "code text is not equal to Paste Code");
        Assert.assertEquals(successPage.getPageTitle(), driver.getTitle(), "title is not equal to \"Paste Name / Title\"");

    }
}
