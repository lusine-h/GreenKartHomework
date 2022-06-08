package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PageGreenKart {
    protected WebDriver driver;
    protected JavascriptExecutor jse;

    public PageGreenKart(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        String addItem = "Mango";
        List<WebElement> listOfItems = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < listOfItems.size(); i++) {
            listOfItems = driver.findElements(By.cssSelector("h4.product-name"));
            String[] productName = listOfItems.get(i).getText().split("-");
            String trimName = productName[0].trim();

           if (addItem.equals(trimName)) {
                System.out.println(trimName);
                WebElement addMango = driver.findElement(By.xpath("//following::div[2]/button[text()='ADD TO CART']"));
                addMango.click();
            }
        }
    }
}

