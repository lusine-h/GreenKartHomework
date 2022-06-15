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
    @DisplayName("Homework task with POM")
    public void testHomeworkWithPOM() throws InterruptedException {
        String actualURL = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();
        assertEquals(MAIN_URL, actualURL);
        assertEquals(EXPECTED_TITLE, actualTitle);

        homepage.addToCart();
        String qty = homepage.getItemsQty();
        String price = homepage.getItemPrice();
        assertEquals(qty, "1");
        assertEquals(price, "75");

        homepage.getCartIcon();
        assertTrue(homepage.getModalContentImage().isDisplayed());
        assertEquals(homepage.getModalContentText().getText(), "Mango - 1 Kg");
        assertEquals(homepage.getModalContentQty().getText(), "1 No.");
        assertEquals(homepage.getModalContentPrice().getText(), "75");
        assertEquals(homepage.getModalContentAmount().getText(), "75");

        String actualURLCart = homepage.getOrderPageUrl();
        assertTrue(actualURLCart.endsWith("cart"));
        boolean assertSize = homepage.getOrderPageTable();
        assertTrue(assertSize);

        homepage.clickOnPlaceOrderBtn();
        homepage.getOrderPlacePageUrl();
        String actualURLCountry =homepage.getOrderPlacePageUrl();
        assertTrue(actualURLCountry.endsWith("country"));

        WebElement shadow;
        String text = "Thank you, your order has been placed successfully\n" +
                "You'll be redirected to Home page shortly!!";

        homepage.selectCountry();
        homepage.selectAgreeCheckBox();
        homepage.clickOnProceed();
        shadow = homepage.shadowSuccessMessage();
        assertEquals(text, shadow.getText());
    }
}



