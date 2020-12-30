package com.techproed.tests;

import com.techproed.pages.CrystalHotelPage2;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrystalKeyPOM3 {

    @Test
    public void test1(){

        CrystalHotelPage2 crystalHotelPage2 = new CrystalHotelPage2();
        Driver.getDriver().get(ConfigReader.getProperty("c_url"));


        crystalHotelPage2.ilkLogIn.click();
        crystalHotelPage2.userNameTextBox.sendKeys(ConfigReader.getProperty("valid_user"));
        crystalHotelPage2.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        crystalHotelPage2.ikinciLoginButonu.click();
        crystalHotelPage2.hotelmanagementButonu.click();
        crystalHotelPage2.hotelRoomsButonu.click();
        crystalHotelPage2.addHotelRoom.click();
    }


    @Test
    public void test2() throws InterruptedException {
        CrystalHotelPage2 crystalHotelPage2 = new CrystalHotelPage2();
        WebElement idDropDown = Driver.getDriver().findElement(By.id("IDHotel"));
        Select select = new Select(idDropDown);
        select.selectByValue("1121");
        WebElement codeWebElementi = Driver.getDriver().findElement(By.id("Code"));
        Actions actions = new Actions(Driver.getDriver());
        actions.click(codeWebElementi)
                .sendKeys("06100")
                .sendKeys(Keys.TAB)
                .sendKeys("Double with Child Room")
                .sendKeys(Keys.TAB)
                .sendKeys("Sydney")
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        Driver.getDriver().findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Amazing Room");
        WebElement yediYuzButonu = Driver.getDriver().findElement(By.linkText("700"));
        Thread.sleep(5000);

        WebElement priceTextBox = Driver.getDriver().findElement(By.id("Price"));
        actions.dragAndDrop(yediYuzButonu, priceTextBox).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement roomTypeDropDown = Driver.getDriver().findElement(By.id("IDGroupRoomType"));
        Select select1 = new Select(roomTypeDropDown);
        select1.selectByIndex(5);

        Driver.getDriver().findElement(By.id("MaxAdultCount")).sendKeys("2");
        Driver.getDriver().findElement(By.id("MaxChildCount")).sendKeys("2");

        Driver.getDriver().findElement(By.id("btnSubmit")).click();
        Thread.sleep(5000);


        Assert.assertTrue(crystalHotelPage2.sonucYaziElementi.isDisplayed());

        Driver.closeDriver();

    }
}

