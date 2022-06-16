package greenKartTests;


import greenKartFramework.CartPage;
import greenKartFramework.CountryPage;
import greenKartFramework.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static greenKartTests.Constants.MAIN_URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected CountryPage countryPage;

    @BeforeAll
    public void driverSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(MAIN_URL);

        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        countryPage = new CountryPage(driver);
    }
    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}

