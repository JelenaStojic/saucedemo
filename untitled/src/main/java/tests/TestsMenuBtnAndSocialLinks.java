package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsMenuBtnAndSocialLinks extends BaseTests{
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
        Assert.assertEquals(getProductsPage().aboutUrl(), "https://saucelabs.com/");
    }
    @Test
    public void checkallItemsBtn(){
        getLoginPage().login("standard_user", "secret_sauce");
        getShoopingCartPage().openCartPage();
        getShoopingCartPage().allItems();
        Assert.assertEquals(getShoopingCartPage().getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
