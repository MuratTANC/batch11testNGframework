package com.techproed.tests;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrystalKeyPOM extends TestBase {

    @Test
    public void test1(){

        driver.get(ConfigReader.getProperty("c_url"));

        CrystalHotelPage crystalHotelPage = new CrystalHotelPage(driver);

        crystalHotelPage.ilkLogIn.click();
        crystalHotelPage.userNameTextBox.sendKeys(ConfigReader.getProperty("valid_user"));
        crystalHotelPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        crystalHotelPage.ikinciLoginButonu.click();
        crystalHotelPage.hotelmanagementButonu.click();
        crystalHotelPage.hotelRoomsButonu.click();
        crystalHotelPage.addHotelRoom.click();
    }

    @Test
    public void test2() throws InterruptedException {

        WebElement idDropDown=driver.findElement(By.id("IDHotel"));
        Select select=new Select(idDropDown);
        select.selectByValue("1121");
        WebElement codeWebElementi=driver.findElement(By.id("Code"));
        Actions actions=new Actions(driver);
        actions.click(codeWebElementi)
                .sendKeys("06100")
                .sendKeys(Keys.TAB)
                .sendKeys("Double with Child Room")
                .sendKeys(Keys.TAB)
                .sendKeys("Sydney")
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Amazing Room");
        WebElement yediYuzButonu=driver.findElement(By.linkText("700"));
        Thread.sleep(5000);
        WebElement priceTextBox=driver.findElement(By.id("Price"));
        actions.dragAndDrop(yediYuzButonu,priceTextBox).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement roomTypeDropDown=driver.findElement(By.id("IDGroupRoomType"));
        Select select1=new Select(roomTypeDropDown);
        select1.selectByIndex(5);
        driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
        driver.findElement(By.id("MaxChildCount")).sendKeys("2");

        // 8. Save butonuna basin.
        driver.findElement(By.id("btnSubmit")).click();
        Thread.sleep(5000);

        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//*[text()='HotelRoom was inserted successfully']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

    }


}
