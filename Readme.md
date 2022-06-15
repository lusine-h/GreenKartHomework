## Green Kart Automation Testing Practice Project


### Homework task with POM
1. Navigate to https://rahulshettyacademy.com/seleniumPractise/#/ page
2. Assert page is opened (url, title)
3. Add **"Mango"** to the cart
4. Assert **Items** and **Price** are shown as expected in the cart info (top right)
5. Click on the **cart icon**
6. Assert **"Mango"** is shown on the opened overlay
7. Click on **"Proceed to checkout"** button
8. Assert cart page is opened
9. Asset only one item is shown in the cart
10. Click on **"Place Order"**
11. Check **"Terms & Conditions"** checkbox
12. Click on **"Proceed"** button
13. Assert **Success message** is shown
_______________________________________________________________________________________
### Description
This is a dynamic automated test using Java Selenium, it asserts the required tasks listed up.


>**Technology Used:** *Java*, *Selenium*, *Maven*, *JUnit5*
>
>**Framework Used:** *Page Object Model*
>
>**Required Dependancies:**  Navigate to [mvnrepository.com](https://mvnrepository.com/) and search following dependencies, next step by step copy them and paste to your POM.xml file in the ***dependencies*** section.
>- JUnit Jupiter (Aggregator)
>- WebDriverManager (io.github.bonigarcia)
>- Selenium Chrome Driver
>- Selenium Support

### Usage
Open TestGreenKart class in test->java->greenKartTests folder then **run** <img src="https://user-images.githubusercontent.com/106512280/173769405-044a7889-f3d6-47bf-af0a-3576c118bdd7.png" width="12"> the **@Test** or **class**.

```java
    @Test
@DisplayName("Homework task with POM")
public void testHomeworkWithPOM() {
        String actualURL = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();
        assertEquals(MAIN_URL, actualURL);
        assertEquals(EXPECTED_TITLE, actualTitle);
        .....
        }
```