package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage {
    private final WebDriver driver;
    private By instanceType;
    private String VMclass;
    private String Region;
    private String localSSD;
    private String term;
    private String totalSum;
    WebDriverWait wait;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getInstanceTypeCPU() {
        return driver.findElement(By.xpath("//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy']/div[contains(text(),'Instance type:')]")).getText();
    }

    public String getVMclass() {
        return driver.findElement(By.xpath("//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[contains(text(),'VM class:')]")).getText();
    }

    public String getRegion() {
        return driver.findElement(By.xpath("//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy']/div[contains(text(),'Region')]")).getText();
    }

    public String getLocalSSD() {
        return driver.findElement(By.xpath("//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[contains(text(),'Local SSD:')]")).getText();
    }

    public String getTerm() {
        return driver.findElement(By.xpath("//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy ng-scope']/div[contains(text(),'Commitment')]")).getText();
    }

    public String getTotalSum() {
        return driver.findElement(By.xpath("//md-content[@class='cartsection ng-scope']/md-list/md-list-item[@class='md-1-line md-no-proxy']/div/b")).getText();
    }

}
