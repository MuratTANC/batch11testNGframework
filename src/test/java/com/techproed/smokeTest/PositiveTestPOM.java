package com.techproed.smokeTest;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTestPOM  extends TestBase {

    //1) com.techproed altinda bir package olustur : smoketest
    //2) Bir Class olustur : PositiveTest
    //3) Bir test method olustur positiveLoginTest()
    //       http://qa-environment.crystalkeyhotels.com adresine git
    //      login butonuna bas
    //test data username: manager ,
    //test data password : Manager2!
    //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et



    @Test
    public void Test(){

        //1) com.techproed altinda bir package olustur : smoketest
        driver.get(ConfigReader.getProperty("c_url"));

        //      login butonuna bas
        CrystalHotelPage crystalHotelPage = new CrystalHotelPage(driver);
        crystalHotelPage.ilkLogIn.click();
        //test data username: manager ,
        crystalHotelPage.userNameTextBox.sendKeys(ConfigReader.getProperty("valid_user"));
        //test data password : Manager2!
        crystalHotelPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        crystalHotelPage.ikinciLoginButonu.click();

    }
}
