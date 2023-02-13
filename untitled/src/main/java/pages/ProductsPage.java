package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends BasePage {
    private By addToCartBtn = By.xpath("//button[contains(@name, 'add-to')]");
    private By removeBtn = By.xpath("//button[contains(@name, 'remove')]");
    private By backToProductsBtn = By.id("back-to-products");
    private By twitter = By.className("social_twitter");
    private By facebook = By.className("social_facebook");
    private By linkedin = By.className("social_linkedin");
    public ProductsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement selectProductByName(String name) {

        return getDriver().findElement(By.linkText(name));
    }
    public WebElement getAddToCartButton() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
        return getDriver().findElement(addToCartBtn);
    }

    public void clickAddToCartBtn() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        getAddToCartButton().click();
    }

    public void clickRemoveBtn() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(removeBtn));
        getDriver().findElement(removeBtn).click();
    }

    public void clickOpenDetailsProduct(String productName) {
        selectProductByName(productName).click();
    }
    public boolean removeBtnIsVisible(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(removeBtn));
        return getDriver().findElement(removeBtn).isDisplayed();
    }
    public boolean addToCartBtnIsVisible(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        return getDriver().findElement(addToCartBtn).isDisplayed();
    }
    public void clickReturnToProductsBtn(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(backToProductsBtn));
        getDriver().findElement(backToProductsBtn).click();
    }
    public void setSelectSortingByNameAscending() {
        Select selectSorting = new Select(getDriver().findElement(By.className("product_sort_container")));
        selectSorting.selectByVisibleText("Name (A to Z)");
    }
    public String beforeSortingNameListAscending() {
        List<WebElement> beforeSortingName = getDriver().findElements(By.className("inventory_item_name"));
        List<String> beforeSortingNameList = new ArrayList<>();
        for (WebElement n : beforeSortingName) {
            beforeSortingNameList.add(String.valueOf(n.getText()));
        }
        Collections.sort(beforeSortingNameList);
        return String.valueOf(beforeSortingNameList);
    }
    public String afterSortingNameListAscending() {
        setSelectSortingByNameAscending();
        List<WebElement> afterSortingName = getDriver().findElements(By.className("inventory_item_name"));
        List<String> afterSortingNameList = new ArrayList<>();
        for (WebElement n : afterSortingName) {
            afterSortingNameList.add(String.valueOf(n.getText()));
        }
        return String.valueOf(afterSortingNameList);
    }
    public void setSelectSortingByNameDescending() {
        Select selectSorting = new Select(getDriver().findElement(By.className("product_sort_container")));
        selectSorting.selectByVisibleText("Name (Z to A)");
    }
    public String beforeSortingNameListDescending() {
        List<WebElement> beforeSortingName = getDriver().findElements(By.className("inventory_item_name"));
        List<String> beforeSortingNameList = new ArrayList<>();
        for (WebElement n : beforeSortingName) {
            beforeSortingNameList.add(String.valueOf(n.getText()));
        }
        Collections.sort(beforeSortingNameList, Collections.reverseOrder());
        return String.valueOf(beforeSortingNameList);
    }
    public String afterSortingNameListDescending() {
        setSelectSortingByNameDescending();
        List<WebElement> afterSortingName = getDriver().findElements(By.className("inventory_item_name"));
        List<String> afterSortingNameList = new ArrayList<>();
        for (WebElement n : afterSortingName) {
            afterSortingNameList.add(String.valueOf(n.getText()));
        }
        return String.valueOf(afterSortingNameList);
    }
    public void setSelectSortingByPriceAscending() {
        Select selectSorting = new Select(getDriver().findElement(By.className("product_sort_container")));
        selectSorting.selectByVisibleText("Price (low to high)");
    }

    public String beforeSortingPriceListAscending() {
        List<WebElement> beforeSortingPrice = getDriver().findElements(By.className("inventory_item_price"));
        List<Double> beforeSortingPriceList = new ArrayList<>();
        for (WebElement p : beforeSortingPrice) {
            beforeSortingPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Collections.sort(beforeSortingPriceList);
        return String.valueOf(beforeSortingPriceList);
    }
    public String afterSortingPriceListAscending() {
        setSelectSortingByPriceAscending();
        List<WebElement> afterSortingPrice = getDriver().findElements(By.className("inventory_item_price"));
        List<Double> afterSortingPriceList = new ArrayList<>();
        for (WebElement p : afterSortingPrice) {
            afterSortingPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        return String.valueOf(afterSortingPriceList);
    }
    public void setSelectSortingByPriceDescending() {
        Select selectSorting = new Select(getDriver().findElement(By.className("product_sort_container")));
        selectSorting.selectByVisibleText("Price (high to low)");
    }
    public String beforeSortingPriceListDescending() {
        List<WebElement> beforeSortingPrice = getDriver().findElements(By.className("inventory_item_price"));
        List<Double> beforeSortingPriceList = new ArrayList<>();
        for (WebElement p : beforeSortingPrice) {
            beforeSortingPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Collections.sort(beforeSortingPriceList, Collections.reverseOrder());
        return String.valueOf(beforeSortingPriceList);
    }
    public String afterSortingPriceListDescending() {
        setSelectSortingByPriceDescending();
        List<WebElement> afterSortingPrice = getDriver().findElements(By.className("inventory_item_price"));
        List<Double> afterSortingPriceList = new ArrayList<>();
        for (WebElement p : afterSortingPrice) {
            afterSortingPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        return String.valueOf(afterSortingPriceList);
    }
    public void clickTwitterIcon(){
        getDriver().findElement(twitter).click();
    }
    public String actualTwitterLink() {
        switchToNextTab();
        return getDriver().getCurrentUrl();
    }
    public void switchToNextTab() {
        ArrayList<String> tab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tab.get(1));
    }
    public void clickFacebookIcon(){
        getDriver().findElement(facebook).click();
    }
    public String actualFacebookLink() {
        switchToNextTab();
        return getDriver().getCurrentUrl();
    }
    public void clickLinkedinIcon(){
        getDriver().findElement(linkedin).click();
    }
    public String actualLinkedinLink(){
        switchToNextTab();
        getDriverWait().until(ExpectedConditions.urlToBe("https://www.linkedin.com/company/sauce-labs/?original_referer="));
        return getDriver().getTitle();
    }
}
