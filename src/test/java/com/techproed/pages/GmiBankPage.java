package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmiBankPage {

    WebDriver driver;

    public GmiBankPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement kisiSimgesi;

    @FindBy(linkText = "Sign in")
    public WebElement signIn;

    @FindBy(id="username")
    public WebElement userTextBox;

    @FindBy(id="password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

}

