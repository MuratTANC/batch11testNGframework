package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {
    // driver'i bu sayfada kontrol edebilmek icin bu sayfada da bir driver olusturmaliyim
    // olusturacagim driver'i instance olarak olusturuyorum ki class'in her yerinde kullanabileyim

    WebDriver driver;  //BU DRİVER FaceBookPage sayfasının driver'ı

    //1. adim parametre olarak Webdriver driver kullanabilecegim bir Constructor olusturmaliyim
    //page sayfasi açtığımızda ilk yapacağomız şey constractor üretmektir.
    //public yapıyoruz ki FacebookPOM SAYFASINDAN ULAŞILSIN.

    public FaceBookPage(WebDriver driver){ //bu driver FaceBookPOM sayfasının driver'ı


    this.driver = driver;           //burada 2 driver'ı eşitliyoruz, atıyoruz.
        PageFactory.initElements(driver, this);
    //driver'a ilk değeri vermek için bu komut

    }

    @FindBy(id="email")
    public WebElement userTextBox;

    @FindBy(id="pass")
    public WebElement passwordTextBox;

    @FindBy(id="u_0_b")
    public WebElement loginButton;

}
