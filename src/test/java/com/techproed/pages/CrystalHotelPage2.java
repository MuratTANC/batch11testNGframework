package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrystalHotelPage2 {

    public CrystalHotelPage2(){
        PageFactory.initElements(Driver.getDriver(), this);

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

    @FindBy(id = "IDHotel")
    public WebElement idDropDown;

    @FindBy(id = "btnSubmit")
    public WebElement saveButonu;

    @FindBy(xpath = "//*[text()='HotelRoom was inserted successfully']")
    public  WebElement sonucYaziElementi;





}
