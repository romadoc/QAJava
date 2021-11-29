import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestICanWinTask extends BaseTest {
   private HomePage homePage;
   private SuccessPage successPage;

   @BeforeClass
   public void setUpPages() {
    homePage = new HomePage(driver);
    homePage.createNewPaste();
    successPage = new SuccessPage(homePage, driver);
   }

   @Test
   public void testTitle() {
       Assert.assertEquals(successPage.getTitle(), homePage.getTitleText());
   }

   @Test
    public void testCodeText() {
       Assert.assertEquals(successPage.getCode(), homePage.getCode());
   }

   @Test
    public void testExpirationText() {
       Assert.assertEquals(successPage.getExpirationText(), homePage.getExpirationText());
   }
}
