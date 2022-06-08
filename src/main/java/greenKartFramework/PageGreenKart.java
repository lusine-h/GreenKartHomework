package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageGreenKart {
    protected WebDriver driver;
    protected JavascriptExecutor jse;

    public PageGreenKart(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "//*[@id=\"root\"]/div/div[1]/div/div[18]/div[3]/button")
    private WebElement mango;

    public void addMangoToCart(){
        jse = (JavascriptExecutor) driver;
        jse.executeScript("0, document.body.scrollHeight");
        mango.click();

    }

}
