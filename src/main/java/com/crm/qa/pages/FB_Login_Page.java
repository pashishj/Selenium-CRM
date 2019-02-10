package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FB_Login_Page extends TestBase {

    //page factory or Object repository for web element on login page

    @FindBy(name="email")
    WebElement email;

    @FindBy(name="pass")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement login_button;

    @FindBy (xpath="/a[contains(@title,'Go to Facebook Home')]")
    WebElement faceBookImage;

// initialize page factory objects using constructor of a calss
    public FB_Login_Page(){
        PageFactory.initElements(driver,this);
    }

    //Actiona or methods of signup page--means what kinds of validation we can perform

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateFacebookLogo(){
        return faceBookImage.isDisplayed();
    }


    public FB_Home_Page login(String emailId,String password){
        email.sendKeys(emailId);
        this.password.sendKeys(password);
        login_button.click();
        return new FB_Home_Page();
    }


}
