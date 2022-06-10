package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class PageGreenKart {

    protected WebDriver driver;


    //Constructor
    public PageGreenKart(WebDriver driver) {
       this.driver = driver;
    }



    //Locate Elements
    private final By itemsQty = By.cssSelector("div.cart-info tr:nth-child(1) > td:nth-child(3) > strong");
    private final By priceItem = By.cssSelector("div.cart-info tr:nth-child(2) > td:nth-child(3) > strong");

    private final By cartIcon = By.cssSelector("a.cart-icon");
    private final By modalContainer = By.cssSelector("div.cart-preview.active");
    private final By modalContentImage = By.xpath(".//img[@src = './images/mango.jpg']");
    private final By modalContentText = By.xpath(".//p[text()= 'Mango - 1 Kg']");
    private final By modalContentQty = By.cssSelector("p.quantity");
    private final By modalContentPrice = By.cssSelector("p.product-price");
    private final By modalContentAmount = By.cssSelector("p.amount");

    private final By proceedToCheckoutBtn = By.xpath(".//button[text() = 'PROCEED TO CHECKOUT']");
    private final By orderTable = By.xpath("//table[@class = 'cartTable']/ tbody");

    public long generateRadomNumber() {
        return Math.round(Math.random() * 100);
    }


    //Add Mango To The Cart
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
    //Verify Items and Price are shown as expected in the cart info (top right)
    public String getItemsQty(){
        WebElement getItemQty = driver.findElement(itemsQty);
        return getItemQty.getText();
    }
    public String getItemPrice(){
        WebElement getItemPrice = driver.findElement(priceItem);
        return getItemPrice.getText();
    }
    //Click Cart Icon and verify modal Content Elements
    public void getCartIcon(){
        WebElement getCartIcon = driver.findElement(cartIcon);
        getCartIcon.click();
    }
    public WebElement getModalContainer(){
        WebElement getModalContainer = driver.findElement(modalContainer);
        return getModalContainer;
    }
    public WebElement getModalContentImage(){
        WebElement getModalContentImage = getModalContainer().findElement(modalContentImage);
        return getModalContentImage;
    }
    public WebElement getModalContentText(){
        WebElement getModalContentText = getModalContainer().findElement(modalContentText);
        return getModalContentText;
    }
    public WebElement getModalContentQty(){
        WebElement getModalContentQty = getModalContainer().findElement(modalContentQty);
        return getModalContentQty;
    }
    public WebElement getModalContentPrice(){
        WebElement getModalContentPrice = getModalContainer().findElement(modalContentPrice);
        return getModalContentPrice;
    }
    public WebElement getModalContentAmount(){
        WebElement getModalContentAmount = getModalContainer().findElement(modalContentAmount);
        return getModalContentAmount;
    }
    //Click on "Proceed to checkout" button
    public void  clickOnProceedToCheckoutBtn() {
        WebElement getProceedToCheckoutBtn = getModalContainer().findElement(proceedToCheckoutBtn);
        getProceedToCheckoutBtn.click();
    }
    public String getOrderPageUrl(){
        clickOnProceedToCheckoutBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains("cart"));
        String actualURL = driver.getCurrentUrl();
        return actualURL;
    }
    //Order Table
    public boolean getOrderPageTable(){
        WebElement table = driver.findElement(orderTable);
        List<WebElement> rowTable = table.findElements(By.tagName("tr"));
        int rowsCount = rowTable.size();
//        //Loop will execute till the last row of table.
//        for (int row = 0; row < rowsCount; row++) {
//            List<WebElement> columnsRow = rowTable.get(row).findElements(By.tagName("td"));
////        }
        if (rowsCount==1) return true;
        else{
            return  false;
        }

    }
}
