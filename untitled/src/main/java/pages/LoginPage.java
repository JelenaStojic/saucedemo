package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By noPasswordMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
    public void enterUsername(String username){
        getDriver().findElement(this.username).sendKeys(username);
    }
    public void enterPassword(String password){
        getDriver().findElement(this.password).sendKeys(password);
    }
    public void loginBtnClick(){
        getDriver().findElement(this.loginBtn).click();
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        loginBtnClick();
    }
    public String messageLogin(){
        return getDriver().findElement(this.noPasswordMessage).getText();
    }
}
