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

import java.util.List;

import static greenKartTests.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGreenKart extends BaseTest {

    @Test
    @DisplayName("Homework task with POM")
    public void testHomeworkWithPOM(){
        String actualURL = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();
        assertEquals(MAIN_URL, actualURL);
        assertEquals(EXPECTED_TITLE, actualTitle);

        int randomItem = homePage.generateRandomNumber();
        List<String> aa = homePage.addItemIntoCart(randomItem);
        String pageQty = aa.get(0);
        String pagePrice = aa.get(1);
        String itemText = aa.get(2);
        int total = Integer.valueOf(pageQty) * Integer.valueOf(pagePrice);
        String qty = homePage.getItemsQty();
        String price = homePage.getItemPrice();


        System.out.println(qty + " & " + price);
        assertEquals(qty, pageQty);
        assertEquals(price,pagePrice);

        homePage.getCartIcon();
        assertTrue(homePage.getModalContentImage().isDisplayed());
        assertTrue(homePage.getModalContentImageMatch().contains(itemText));

        assertEquals(homePage.getModalContentText().getText(), itemText);
        assertEquals(homePage.getModalContentQty().getText(), pageQty+ " No.");
        assertEquals(homePage.getModalContentPrice().getText(), pagePrice);
        assertEquals(homePage.getModalContentAmount().getText(), String.valueOf(total));

//        String actualURLCart = homePage.getOrderPageUrl();
//        assertTrue(actualURLCart.endsWith("cart"));
//        int assertSize = cartPage.getOrderPageTable();
//        assertEquals(assertSize, 1);
//
//        cartPage.clickOnPlaceOrderBtn();
//        countryPage.getOrderPlacePageUrl();
//        String actualURLCountry =countryPage.getOrderPlacePageUrl();
//        assertTrue(actualURLCountry.endsWith("country"));
//
//        WebElement message;
//        String text = "Thank you, your order has been placed successfully\n" +
//                "You'll be redirected to Home page shortly!!";
//
//        countryPage.selectCountry();
//        countryPage.selectAgreeCheckBox();
//        countryPage.clickOnProceed();
//        message = countryPage.successMessage();
//        assertEquals(text, message.getText());
    }
}



