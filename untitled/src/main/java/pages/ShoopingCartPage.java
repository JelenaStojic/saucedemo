package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoopingCartPage extends BasePage{

    private By productsInCart = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]");
    private By chekckoutBtn = By.id("checkout");
    private By removeBtn = By.xpath("//button[contains(@id, 'remove')]");
    private By continueShoopingBtn = By.id("continue-shopping");
    public ShoopingCartPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public WebElement getCart() {
        return getDriver().findElement(productsInCart);
    }
    public void clickCheckoutBtn(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(chekckoutBtn));
        getDriver().findElement(chekckoutBtn).click();
    }
    public void removeProductFromCartByName(String productName) {
        List<WebElement> productsInCart = getCart().findElements(By.xpath("//a[contains(@id, 'title_link')]"));
        for (WebElement product : productsInCart) {
            if (product.getText().contains(productName)) {
                product.findElement(removeBtn).click();
            }
        }
    }
    public boolean checkIfProductIsInCart(String productName) {
        List<WebElement> productsInCart = getCart().findElements(By.xpath("//a[contains(@id, 'title_link')]"));
        for (WebElement product : productsInCart) {
            if (product.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }
    public void removeAllProductsFromCart(String removeButton) {
        List<WebElement> removeBtn = getCart().findElements(By.xpath("//button[contains(@id, 'remove')]"));
        for (WebElement product : removeBtn) {
            if (product.getText().contains(removeButton)) {
                product.click();
            }
        }
    }
    public boolean checkIfCartIsEmpty(String removeButton) {
        List<WebElement> removeBtn = getCart().findElements(By.xpath("//button[contains(@id, 'remove')]"));
        for (WebElement product : removeBtn) {
            if (product.getText().contains(removeButton)) {
                return false;
            }
        }
        return true;
    }
    public void clickContinueShoopingBtn(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(continueShoopingBtn));
        getDriver().findElement(continueShoopingBtn).click();
    }
}
