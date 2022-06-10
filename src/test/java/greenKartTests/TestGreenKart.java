package greenKartTests;
/**
 * Homework with POM
 * 1. Navigate to "https://rahulshettyacademy.com/seleniumPractise/#/" page
 * 2. Assert page is opened (url, title)
 * 3. Add "Mango" to the cart
 * 4. Assert Items and Price are shown as expected in the cart info (top right)
 * 5. Click on the cart icon
 * 6. Assert "Mango" is shown on the opened overlay
 * 7. Click on "Proceed to checkout" button
 * 8. Assert cart page is opened
 * 9. Asset only one item is shown in the cart
 * 10. Click on "Place Order"
 * 11. Check "Terms & Conditions" checkbox
 * 12. Click on "Proceed" button
 * 13. Assert Success message is shown
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static greenKartTests.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGreenKart extends BaseTest {

    @Test
    @DisplayName("URL")
    public void testURL() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(MAIN_URL, actualURL);
    }

    @Test
    @DisplayName("Title")
    public void testTitle() {
        String actualTitle = driver.getTitle();
        assertEquals(EXPECTED_TITLE, actualTitle);
    }

    @Test
    @DisplayName("Add Mango to the Cart")
    public void addMangoToCart() {
        homepage.addToCart();
        String qty = homepage.getItemsQty();
        String price = homepage.getItemPrice();
        assertEquals(qty, "1");
        assertEquals(price, "75");
    }

    @Test
    @DisplayName("Click on Cart Icon")
    public void clickOnCartIcon() {
        homepage.addToCart();
        homepage.getCartIcon();
        assertTrue(homepage.getModalContentImage().isDisplayed());
        assertEquals(homepage.getModalContentText().getText(), "Mango - 1 Kg");
        assertEquals(homepage.getModalContentQty().getText(), "1 No.");
        assertEquals(homepage.getModalContentPrice().getText(), "75");
        assertEquals(homepage.getModalContentAmount().getText(), "75");
    }

    @Test
    @DisplayName("Proceed to checkout button")
    public void clickOnProceedCheckout() {
        homepage.addToCart();
        homepage.getCartIcon();
        String actualURL = homepage.getOrderPageUrl();
        assertEquals(CART_CONTENT_PAGE_URL,actualURL);
    }

}
