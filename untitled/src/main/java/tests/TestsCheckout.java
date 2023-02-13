package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsCheckout extends BaseTests {
    @Test(priority = 1)
    public void orderProducts() {
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Bike Light");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().clickCheckoutBtn();
        getCheckoutPage().openCheckoutPage();
        getCheckoutPage().enterCheckoutInformation("Marko", "Markovic", "21123");
        getCheckoutPage().clickFinishBtn();
        Assert.assertEquals(getCheckoutPage().getCheckoutCompleteMessage(), "CHECKOUT: COMPLETE!");
        getProductsPage().logout();
    }

    @Test (priority = 2)
    public void orderProductsWithNoUsername() {
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Bolt T-Shirt");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().clickCheckoutBtn();
        getCheckoutPage().openCheckoutPage();
        getCheckoutPage().enterCheckoutInformation("", "Markovic", "21123");
        getCheckoutPage().clickContinueBtn();
        Assert.assertEquals(getCheckoutPage().getErrorMessage(), "Error: First Name is required");
        getProductsPage().logout();
    }
    @Test (priority = 3)
    public void orderProductsWithNoLastname() {
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Onesie");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().clickCheckoutBtn();
        getCheckoutPage().openCheckoutPage();
        getCheckoutPage().enterCheckoutInformation("Marko", "", "21123");
        getCheckoutPage().clickContinueBtn();
        Assert.assertEquals(getCheckoutPage().getErrorMessage(), "Error: Last Name is required");
        getProductsPage().logout();
    }
    @Test (priority = 4)
    public void orderProductsWithNoPostalCode() {
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Backpack");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().clickCheckoutBtn();
        getCheckoutPage().openCheckoutPage();
        getCheckoutPage().enterCheckoutInformation("Marko", "Markovic", "");
        getCheckoutPage().clickContinueBtn();
        Assert.assertEquals(getCheckoutPage().getErrorMessage(), "Error: Postal Code is required");
        getCheckoutPage().logout();
    }
}