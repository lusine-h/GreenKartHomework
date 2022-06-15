package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PageGreenKart {
    protected WebDriver driver;

    //Constructor
    public PageGreenKart(WebDriver driver) {

        this.driver = driver;
    }

    WebDriverWait wait;

    //Locate Elements
    private final By itemsQty = By.xpath("//div[@class='cart-info']//tr[1]//strong");
    private final By priceItem = By.xpath("//div[@class='cart-info']//tr[2]//strong");

    private final By cartIcon = By.xpath("//a[@class = 'cart-icon']");
    private final By modalContainer = By.xpath("//div[@class = 'cart-preview active']");
    private final By modalContentImage = By.xpath(".//img[@src = './images/mango.jpg']");
    private final By modalContentText = By.xpath(".//p[text()= 'Mango - 1 Kg']");
    private final By modalContentQty = By.xpath("//p[@class = 'quantity']");
    private final By modalContentPrice = By.xpath("//p[@class = 'product-price']");
    private final By modalContentAmount = By.xpath("//p[@class = 'amount']");

    private final By proceedToCheckoutBtn = By.xpath("//button[text() = 'PROCEED TO CHECKOUT']");
    private final By orderTable = By.xpath("//table[@class = 'cartTable']/ tbody");
    private final By placeOrderBtn  = By.xpath("//button[text() = 'Place Order']");

    private final By selectCountry = By.xpath("//select/option[text() = \"Armenia\"]");
    private final By selectAgreeCheckBox = By.xpath("//input[@type = 'checkbox']");
    private final By proceedBtn = By.xpath("//button[text() = 'Proceed']");

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
    public String getOrderPageUrl() throws InterruptedException {
        clickOnProceedToCheckoutBtn();
        wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains("cart"));
        String actualURL = driver.getCurrentUrl();
        return actualURL;
    }
    //Order Table
    public boolean getOrderPageTable(){
        WebElement table = driver.findElement(orderTable);
        List<WebElement> rowTable = table.findElements(By.tagName("tr"));
        int rowsCount = rowTable.size();
        if (rowsCount==1) return true;
        else{
            return  false;
        }
    }
    public void clickOnPlaceOrderBtn(){
        WebElement getPlaceOrderBtn = driver.findElement(placeOrderBtn);
        getPlaceOrderBtn.click();
    }
    public String getOrderPlacePageUrl(){
        wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains("country"));
        String actualURL = driver.getCurrentUrl();
        return actualURL;
    }
    public WebElement selectCountry(){
        WebElement country = driver.findElement(selectCountry);
        country.click();
        return country;
    }
    public boolean selectAgreeCheckBox(){
        WebElement agreeCheckBox = driver.findElement(selectAgreeCheckBox);
        agreeCheckBox.click();
        return true;
    }
    public void clickOnProceed(){
        WebElement clickOnPlaceOrder = driver.findElement(proceedBtn);
        clickOnPlaceOrder.click();
    }
    public WebElement shadowSuccessMessage(){
        WebElement textSuccess = driver.
                findElement(By.xpath("//*[contains(text(), 'Thank you, your order has been placed successfully')]"));
        return textSuccess;
    }
}

