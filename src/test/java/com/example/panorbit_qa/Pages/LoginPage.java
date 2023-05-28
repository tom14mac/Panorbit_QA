package com.example.panorbit_qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public class LoginPage {
    @FindBy(xpath = "//input[@id='email']")WebElement Email;
    @FindBy(xpath = "//input[@id='pass']")WebElement password;
    @FindBy(xpath = "//button[@id='loginbutton']")WebElement login_btn;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public WebElement getEmail() {
        return Email;
    }

    public void setEmail(WebElement email) {
        Email = email;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getLogin_btn() {
        return login_btn;
    }

    public void setLogin_btn(WebElement login_btn) {
        this.login_btn = login_btn;
    }
}