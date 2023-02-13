package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{
    private By firstName = By.name("firstName");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By messageCheckoutComplete = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By errorMessage = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");

    public CheckoutPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void enterFirstName(String firstName){
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }
    public void enterPostalCode(String postalCode){
        getDriver().findElement(this.postalCode).sendKeys(postalCode);
    }
    public void clickContinueBtn(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(continueBtn));
        getDriver().findElement(continueBtn).click();
    }
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinueBtn();
    }
    public void clickFinishBtn(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(finishBtn));
        getDriver().findElement(finishBtn).click();
    }
    public String getCheckoutCompleteMessage() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(messageCheckoutComplete));
        return getDriver().findElement(messageCheckoutComplete).getText();
    }
    public String getErrorMessage(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return getDriver().findElement(errorMessage).getText();
    }

}
