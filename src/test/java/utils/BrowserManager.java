package utils;

import Pages.CartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BrowserManager {
    private WebDriver driver;
    public String url,url1;
    public CartPage cartPage;

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        url= QAprops.getValue("url");
        url1= QAprops.getValue("url1");
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
}
