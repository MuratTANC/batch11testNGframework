package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D11_SoftAssert1 {

    // Yeni bir class oluşturun : D11_SoftAssert1
    //
    //
    // 1) "https://www.sahibinden.com/" adresine gidin
    // 2) Baslığın "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" olduğunu doğrılayın
    // 3) search kutusuna araba yazıp arattırınız
    // 4) Bulunan sonuc sayısını yazdırın.
    // 5) Sonuc yazisinin "araba içerdiğini doğrulayın
    // 6) Tümünü temile linkine tıklayın
    // 7) Bulunan sonucu yazdırın
    // 8) Sonuc yazısının "araba" kelimesi içerdiğini doğrulayın

    WebDriver driver;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        // 1) "https://www.sahibinden.com/" adresine gidin
        driver.get("https://www.sahibinden.com/");
        SoftAssert softAssert = new SoftAssert();

        // 2) Baslığın "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri" olduğunu doğrılayın
        String expectedTitle = "Sahibinden Satılık, Kiralık, Emlak, Oto, Alışveriş Ürünleri";
        String actualTitle = driver.getTitle();

        softAssert.assertEquals(actualTitle, expectedTitle, "anasayfa title'i istedigim gibi degil");

        // 3) search kutusuna araba yazıp arattırınız
        WebElement searchBox = driver.findElement(By.id("searchText"));
        searchBox.sendKeys("araba" + Keys.ENTER);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='result-text estimated-result-text']"));

        // 4) Bulunan sonuc sayısını yazdırın.
        System.out.println(sonucYaziElementi.getText());

        // 5) Sonuc yazisinin "araba içerdiğini doğrulayın
        softAssert.assertTrue(sonucYaziElementi.getText().contains("araba"), "buraya virgül atıp mesaj yazabiliyoruz test failse metni yazar");

        // 6) Tümünü temile linkine tıklayın
        driver.findElement(By.linkText("Tümünü Temizle")).click();


        // 7) Bulunan sonucu yazdırın
        WebElement sonucYaziElementi2 = driver.findElement(By.className("result-text"));
        System.out.println(sonucYaziElementi2.getText());

        // 8) Sonuc yazısının "araba" kelimesi içerdiğini doğrulayın
        softAssert.assertFalse(sonucYaziElementi2.getText().contains("araba"), "buraya test başarısız olursa metin yazar");



        softAssert.assertAll();
        System.out.println("bu satir calisir mi?");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
