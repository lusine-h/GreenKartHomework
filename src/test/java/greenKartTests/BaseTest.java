package greenKartTests;


import greenKartFramework.PageGreenKart;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static greenKartTests.Constants.MAIN_URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected PageGreenKart homepage;





    @BeforeAll
    public void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(MAIN_URL);
        driver.manage().window().maximize();
        homepage = new PageGreenKart(driver);
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}
