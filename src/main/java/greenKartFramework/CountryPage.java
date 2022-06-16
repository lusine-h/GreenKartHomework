package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CountryPage {

    protected WebDriver driver;
    WebDriverWait wait;

    private final By selectCountry = By.xpath("//select/option[text() = \"Armenia\"]");
    private final By selectAgreeCheckBox = By.xpath("//input[@type = 'checkbox']");
    private final By proceedBtn = By.xpath("//button[text() = 'Proceed']");

    //Constructor
    public CountryPage(WebDriver driver) {
        this.driver = driver;
    }
    //Get Country page URL
    public String getOrderPlacePageUrl(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains("country"));
        return driver.getCurrentUrl();
    }
    //Choose Country
    public void selectCountry(){
        WebElement country = driver.findElement(selectCountry);
        country.click();
    }
    // Agree to the Terms & Conditions
    public void selectAgreeCheckBox(){
        WebElement agreeCheckBox = driver.findElement(selectAgreeCheckBox);
        agreeCheckBox.click();
    }
    // Click on the Proceed button
    public void clickOnProceed(){
        WebElement clickOnPlaceOrder = driver.findElement(proceedBtn);
        clickOnPlaceOrder.click();
    }
    // Get Success message text
    public WebElement successMessage(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Thank you, your order has been placed successfully')]"));
    }
}
