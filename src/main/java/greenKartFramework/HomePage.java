package greenKartFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomePage {
    protected WebDriver driver;
    WebDriverWait wait;
    List<WebElement> listOfItems;

    //Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locate Elements
    private final By itemsQty = By.xpath("//div[@class='cart-info']//tr[1]//strong");
    private final By priceItem = By.xpath("//div[@class='cart-info']//tr[2]//strong");

    private final By cartIcon = By.xpath("//a[@class = 'cart-icon']");
    private final By modalContainer = By.xpath("//div[@class = 'cart-preview active']");
    private final By modalContentText= By.xpath(".//p[@class = 'product-name']");
    private final By modalContentQty = By.xpath("//p[@class = 'quantity']");
    private final By modalContentPrice = By.xpath("//p[@class = 'product-price']");
    private final By modalContentAmount = By.xpath("//p[@class = 'amount']");
    private final By proceedToCheckoutBtn = By.xpath("//button[text() = 'PROCEED TO CHECKOUT']");

    public int generateRandomNumber() {
        listOfItems = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
        return (int) Math.round(Math.random() * listOfItems.size());
    }
    //Add Item Into Cart
    public List<String> addItemIntoCart(int index) {
        String price = "";
        String qty = "";
        String text = "";
        for (int i = 0; i < listOfItems.size(); i++) {
            listOfItems = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
            if (index == i) {
                WebElement addBtn = listOfItems.get(i).findElement(By.xpath("//div[@class = 'product'][" + i + "]//child::button"));
                WebElement getQty = listOfItems.get(i).findElement(By.xpath("//div[@class= 'product'][" + i + "]//child::input"));
                WebElement getPrice = listOfItems.get(i).findElement(By.xpath("//div[@class= 'product'][" + i + "]//child::p"));
                WebElement getText = listOfItems.get(i).findElement(By.xpath("//div[@class= 'product'][" + i + "]//child::h4"));
                price = getPrice.getText();
                qty = getQty.getAttribute("value");
                text = getText.getText();
                addBtn.click();
            }
        }
        return Arrays.asList(qty, price, text);
    }
    //Verify Items and Price are shown as expected in the cart info (top right)
    public String getItemsQty(){
        WebElement getItemQty = driver.findElement(itemsQty);
       String qty = getItemQty.getText();
        return qty;
    }
    public String getItemPrice(){
        WebElement getItemPrice = driver.findElement(priceItem);
        String price = getItemPrice.getText();
        return price;
    }
    //Click Cart Icon and verify modal Content Elements
    public void getCartIcon(){
        WebElement getCartIcon = driver.findElement(cartIcon);
        getCartIcon.click();
    }
    public WebElement getModalContainer(){
        return driver.findElement(modalContainer);
    }
    //Get container images list
    public boolean getContainerImages() {
        boolean isBrokenImage = false;

        try {
            List<WebElement> image_list = getModalContainer().findElements(By.tagName("img"));
            for (WebElement img : image_list) {
                if (img != null) {
                    if (img.getAttribute("naturalWidth").equals("0")) {
                        isBrokenImage = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return isBrokenImage;
    }
    public WebElement getModalContentText(){
        return getModalContainer().findElement(modalContentText);
    }
    public WebElement getModalContentQty(){
        return getModalContainer().findElement(modalContentQty);
    }
    public WebElement getModalContentPrice(){
        return getModalContainer().findElement(modalContentPrice);
    }
    public WebElement getModalContentAmount(){
        return getModalContainer().findElement(modalContentAmount);
    }
    //Click on "Proceed to checkout" button
    public void  clickOnProceedToCheckoutBtn() {
        WebElement getProceedToCheckoutBtn = getModalContainer().findElement(proceedToCheckoutBtn);
        getProceedToCheckoutBtn.click();
    }
    public String getOrderPageUrl() {
        clickOnProceedToCheckoutBtn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains("cart"));
        return driver.getCurrentUrl();
    }
}


