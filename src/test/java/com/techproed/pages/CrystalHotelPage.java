package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalHotelPage {

//smokeTest/PositiveTestWithPage deki dosyanın page
    WebDriver driver;

    public CrystalHotelPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Log in")
    public WebElement ilkLogIn;

    @FindBy(id = "UserName")
    public WebElement userNameTextBox;

    @FindBy(id = "Password")
    public WebElement passwordTextBox;

    @FindBy(id="btnSubmit")
    public WebElement ikinciLoginButonu;

    @FindBy(linkText = "Hotel Management")
    public WebElement hotelmanagementButonu;

    @FindBy(linkText = "Hotel Rooms")
    public WebElement hotelRoomsButonu;

    @FindBy(className = "hidden-480")
    public WebElement addHotelRoom;




   }
