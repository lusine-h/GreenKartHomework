package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PageGreenKart {

    protected WebDriver driver;

    public PageGreenKart(WebDriver driver) {
        this.driver = driver;
    }
    //private final By itemsQty = By.xpath("//div[@class = 'cart-info']//td[3]//strong");
    private final By itemsQty = By.cssSelector("div.cart-info tr:nth-child(1) > td:nth-child(3) > strong");
   // private final By priceItem = By.xpath("//div[@class = 'cart-info']//tr[2]/td[3]/strong");
   private final By priceItem = By.cssSelector("div.cart-info tr:nth-child(2) > td:nth-child(3) > strong");

    public void addToCart() {
        String addItem = "Mango";
        List<WebElement> listOfItems = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < listOfItems.size(); i++) {
            listOfItems = driver.findElements(By.cssSelector("h4.product-name"));
            String[] productName = listOfItems.get(i).getText().split("-");
            String trimName = productName[0].trim();

           if (addItem.equals(trimName)) {
               WebElement mangoBtn = listOfItems.get(i).findElement(By.xpath("//div[@class = 'product'][18]//child::button"));
               mangoBtn.click();
            }
        }
    }
    public String findItemsQty(){
        WebElement findItemQty = driver.findElement(itemsQty);
        return findItemQty.getText();
    }
    public String findItemPrice(){
        WebElement findItemPrice = driver.findElement(priceItem);
        return findItemPrice.getText();
    }
}

//*[@id="root"]/div/header/div/div[3]/div[1]/table/tbody/tr[2]/td[3]/strong