package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoopingCartPage;

import java.time.Duration;

public abstract class BaseTests {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ShoopingCartPage shoopingCartPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ThinkPad\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        this.loginPage = new LoginPage(driver, driverWait);
        this.productsPage = new ProductsPage(driver, driverWait);
        this.shoopingCartPage = new ShoopingCartPage(driver, driverWait);
        this.checkoutPage = new CheckoutPage(driver, driverWait);
    }
 //   @AfterClass
 //   public void afterClas(){
  //      driver.close();
  //  }
    public LoginPage getLoginPage() {
        return loginPage;
    }
    public ProductsPage getProductsPage(){
        return productsPage;
    }
    public ShoopingCartPage getShoopingCartPage(){
        return shoopingCartPage;
    }
    public CheckoutPage getCheckoutPage(){
        return checkoutPage;
    }
}
