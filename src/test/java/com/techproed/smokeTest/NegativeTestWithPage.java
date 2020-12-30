package com.techproed.smokeTest;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class NegativeTestWithPage extends TestBase {

    @Test
    public void test(){
        //3 Farkli test Methodunda 3 senaryoyu test et
        //              - yanlisSifre
        //2 http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrystalHotelPage crystalHotelPage = new CrystalHotelPage(driver);
        crystalHotelPage.ilkLogIn.click();
        crystalHotelPage.userNameTextBox.sendKeys("manager");
        crystalHotelPage.passwordTextBox.sendKeys("manager");

        //3) Login butonuna bas
        crystalHotelPage.ikinciLoginButonu.click();


    }
}
