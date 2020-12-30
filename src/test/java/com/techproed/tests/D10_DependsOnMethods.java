package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D10_DependsOnMethods {
    // Bir class oluşturun: DependsOnTest
    // https://www.walmart.com/ adresine gidin.
    // 1. Test : Walmart ana sayfaya gittiğinizi test edin.
    // 2. Test : 1. test basarılı ise search Box'i kullanarak "Nutella" için arama yapın
    //  ve aramanızın gerçekleştiğini test edin
    //  3. Test : "Nutella" için arama yapıldıysa ilk ürün için tıklayın ve
    //  fiyatının 6.45 dolar olduğunu test edin.


    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void homePageTest () {
        driver.get("https://www.walmart.com/");
        WebElement logo = driver.findElement(By.className("z_a"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test //(dependsOnMethods = "homePageTest") BU TESTİ İLK TESTE BAĞLAYIP ÇALIŞTIRIYOR.
    public void searchTest(){
    // 2. Test : 1. test basarılı ise search Box'i kullanarak "Nutella" için arama yapın
    //  ve aramanızın gerçekleştiğini test edin.
        WebElement searchBox = driver.findElement(By.id("global-search-input"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains("Nutella"));

    }

    @Test
    public void fiyatTesti(){
    //  3. Test : "Nutella" için arama yapıldıysa ilk ürün için tıklayın ve
    //  fiyatının 6.45 dolar olduğunu test edin.
        driver.findElement(By.xpath("(//img[@data-pnodetype='item-pimg'])[1]")).click();
        WebElement fiyat = driver.findElement(By.xpath("//span[@class='price-group'])[1]"));
        Assert.assertEquals(fiyat.getText(), "$6.65");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
