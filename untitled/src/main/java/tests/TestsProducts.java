package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsProducts extends BaseTests{
    @Test
    public void addToCartOneProduct(){
        getLoginPage().login("standard_user","secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Onesie");
        getProductsPage().clickAddToCartBtn();
        Assert.assertTrue(getProductsPage().removeBtnIsVisible());
    }
    @Test
    public void addAndRemoveOneProduct(){
        getLoginPage().login("standard_user","secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Bike Light");
        getProductsPage().clickAddToCartBtn();
        getProductsPage().clickRemoveBtn();
        Assert.assertTrue(getProductsPage().addToCartBtnIsVisible());
    }
    @Test
    public void deleteAllProductsFromCart(){
        getLoginPage().login("standard_user","secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Bike Light");
        getProductsPage().clickAddToCartBtn();
        getProductsPage().clickReturnToProductsBtn();
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Bolt T-Shirt");
        getProductsPage().clickAddToCartBtn();
        getProductsPage().clickReturnToProductsBtn();
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Fleece Jacket");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().removeAllProductsFromCart("REMOVE");
        Assert.assertTrue(getShoopingCartPage().checkIfCartIsEmpty("REMOVE"));

    }
    @Test
    public void removeAllProductsFromCart(){
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Onesie");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().removeProductFromCartByName("Sauce Labs Onesie");
        Assert.assertFalse(getShoopingCartPage().checkIfProductIsInCart("Sauce Labs Onesie"));
    }
    @Test
    public void addTwoProductsClickContinueShoopingAndAddOneMoreProduct(){
        getLoginPage().login("standard_user","secret_sauce");
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Bolt T-Shirt");
        getProductsPage().clickAddToCartBtn();
        getProductsPage().clickReturnToProductsBtn();
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Fleece Jacket");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().clickContinueShoopingBtn();
        getProductsPage().clickOpenDetailsProduct("Sauce Labs Onesie");
        getProductsPage().clickAddToCartBtn();
        getShoopingCartPage().openCartPage();
        Assert.assertTrue((getShoopingCartPage().checkIfProductIsInCart("Sauce Labs Onesie"))&&
                (getShoopingCartPage().checkIfProductIsInCart("Sauce Labs Fleece Jacket"))&&
                (getShoopingCartPage().checkIfProductIsInCart("Sauce Labs Bolt T-Shirt")));
    }
    @Test
    public void selectSortingByNameAscending(){
        getLoginPage().login("standard_user","secret_sauce");
        Assert.assertEquals(getProductsPage().afterSortingNameListAscending(), getProductsPage().beforeSortingNameListAscending());
    }
    @Test
    public void selectSortingByNameDescending(){
        getLoginPage().login("standard_user","secret_sauce");
        Assert.assertEquals(getProductsPage().afterSortingNameListDescending(), getProductsPage().beforeSortingNameListDescending());
    }
    @Test
    public void selectSortingByPriceAscending(){
        getLoginPage().login("standard_user","secret_sauce");
        Assert.assertEquals(getProductsPage().afterSortingPriceListAscending(), getProductsPage().beforeSortingPriceListAscending());
    }
    @Test
    public void selectSortingByPriceDescending(){
        getLoginPage().login("standard_user","secret_sauce");
        Assert.assertEquals(getProductsPage().afterSortingPriceListDescending(), getProductsPage().beforeSortingPriceListDescending());
    }
    @Test
    public void checkTwitterLink(){
        getLoginPage().login("standard_user","secret_sauce");
        getProductsPage().clickTwitterIcon();
        Assert.assertEquals(getProductsPage().actualTwitterLink(), "https://twitter.com/saucelabs" );
    }
    @Test
    public void checkFacebookLink() {
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().clickFacebookIcon();
        Assert.assertEquals(getProductsPage().actualFacebookLink(), "https://www.facebook.com/saucelabs" );
    }
    @Test
    public void checkLinkedinLink() {
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().clickLinkedinIcon();
        Assert.assertEquals(getProductsPage().actualLinkedinLink(), "Sauce Labs | LinkedIn" );
    }
    @Test
    public void checkAboutBtnFromMenu(){
        getLoginPage().login("standard_user", "secret_sauce");
        getProductsPage().about();
        Assert.assertEquals("https://saucelabs.com/", getProductsPage().aboutUrl());
    }
}
