package com.crm.qa.tests;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FB_Home_Page;
import com.crm.qa.pages.FB_Login_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    FB_Login_Page fblogin;
    FB_Home_Page homePage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initializeBroser();
        fblogin=new FB_Login_Page();

    }

    @Test(priority = 0)
    public void loginPageTitle(){
        String title=fblogin.validateLoginPageTitle();
        Assert.assertEquals(title,"Facebook - Log In or Sign Up");
    }

    @Test(priority = 1)
    public void facebookImageTest(){
        boolean flag=fblogin.validateFacebookLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void loginPageTest()
    {
        homePage= fblogin.login(prop.getProperty("email"),prop.getProperty("password"));
    }
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
