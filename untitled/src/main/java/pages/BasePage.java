package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    private static final String SHOOPING_CART_URL = "https://www.saucedemo.com/cart.html";
    private static final String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-one.html";
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logout = By.id("logout_sidebar_link");
    private By aboutBtn = By.id("about_sidebar_link");

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public void refresh() {
        driver.navigate().refresh();
    }
    public void openCartPage() {
        driver.navigate().to(SHOOPING_CART_URL);
    }
    public void openCheckoutPage() {
        driver.navigate().to(CHECKOUT_URL);
    }
    public void logout() {
        getDriver().findElement(menuBtn).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(logout));
        getDriver().findElement(logout).click();
    }
    public void about() {
        getDriver().findElement(menuBtn).click();
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(aboutBtn));
        getDriver().findElement(aboutBtn).click();
    }
    public String aboutUrl(){
        return getDriver().getCurrentUrl();
    }
}
