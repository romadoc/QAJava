import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected  static final String BASE_URL = "https://pastebin.com";
    protected WebDriver driver;

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"/driver/chromedriver.exe"
        );
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void startDriver() {
        initDriver();
        driver.get(BASE_URL);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeDriver() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       driver.quit();
    }
}
