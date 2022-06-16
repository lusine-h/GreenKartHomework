package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    protected WebDriver driver;

    //Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By orderTable = By.xpath("//table[@class = 'cartTable']/ tbody");
    private final By placeOrderBtn  = By.xpath("//button[text() = 'Place Order']");


    //Order Table
    public int getOrderPageTable(){
        WebElement table = driver.findElement(orderTable);
        List<WebElement> rowTable = table.findElements(By.tagName("tr"));
        return rowTable.size();
    }
    public void clickOnPlaceOrderBtn(){
        WebElement getPlaceOrderBtn = driver.findElement(placeOrderBtn);
        getPlaceOrderBtn.click();
    }
}

