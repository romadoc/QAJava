package unit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected  static final String BASE_URL = "https://pastebin.com";
    protected WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"/driver/chromedriver.exe"
        );
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void startDriver() {

        driver.get(BASE_URL);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void closeDriver() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       driver.quit();
    }
}
