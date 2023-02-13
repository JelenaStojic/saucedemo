package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
public class TestsLogin extends BaseTests{

@Test(priority = 2)
public void loginTest(){
        getLoginPage().login("standard_user","secret_sauce");
        Assert.assertEquals(getLoginPage().getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        }

@Test (priority = 1)
public void loginWithNoPasswordTest(){
        getLoginPage().login("problem_user", "");
        Assert.assertEquals(getLoginPage().messageLogin(), "Epic sadface: Password is required");
        getLoginPage().refresh();
        }
@Test (priority = 1)
public void loginWithNoUsername(){
        getLoginPage().login("", "secret_sauce");
        Assert.assertEquals(getLoginPage().messageLogin(), "Epic sadface: Username is required");
        getLoginPage().refresh();
        }
@Test (priority = 1)
public void loginWithNoUsernameAndPassword(){
        getLoginPage().login("", "");
        Assert.assertEquals(getLoginPage().messageLogin(), "Epic sadface: Username is required");
        getLoginPage().refresh();
        }
@Test (priority = 1)
public void loginWithIncorrectUsername(){
        getLoginPage().login("John", "secret_sauce");
        Assert.assertEquals(getLoginPage().messageLogin(), "Epic sadface: Username and password do not match any user in this service");
        getLoginPage().refresh();
        }
@Test (priority = 2)
public void loginAndLogoutTest(){
        getLoginPage().login("standard_user","secret_sauce");
        getProductsPage().logout();
        Assert.assertEquals(getLoginPage().getDriver().getCurrentUrl(), "https://www.saucedemo.com/");
        }
        }
