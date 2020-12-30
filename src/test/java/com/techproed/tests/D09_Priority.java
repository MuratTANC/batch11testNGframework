package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D09_Priority {

    // https://www.youtube.com adresine gidin.
    // Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapın.
    //      * titleTest     => Sayfa başlığının "Youtube" olduğunu test edin.
    //      * imageTest     --> Youtube resminin görüntülendiğini (isDisplayed()) test edin.
    //      * Search Bozîn erişilebilir olduğunu test edin (isEnable())
    //      * wrongTitleTest --> Sayfa başlığının "youtube" olmadigini dogrulayın


    WebDriver driver;

    @BeforeClass
    public void setUp(){            //static yapmamızı gerek yok JUnit teki gibi

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test (priority = 1)        //priority test ti yapış sırasını yazmış oluyoruz
                                //priority yazmazsak alfabetik sırayla yapar
    public void titleTest(){

        //      * titleTest     => Sayfa başlığının "Youtube" olduğunu test edin.

        driver.get("https://www.youtube.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test (priority = 2)
    public void imageTest(){

        //      * imageTest     --> Youtube resminin görüntülendiğini (isDisplayed()) test edin.

        driver.get("https://www.youtube.com");
        WebElement logo = driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test (priority = 3)
    public void searchBoxUlasmaTesti(){

        //      * Search Bozîn erişilebilir olduğunu test edin (isEnable())

        driver.get("https://www.youtube.com");
        WebElement seatchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(seatchBox.isEnabled());
    }


    @Test (priority = 4)
    public void wrongTitleTest(){
        //      * wrongTitleTest --> Sayfa başlığının "youtube" olmadigini dogrulayın
        driver.get("https://www.youtube.com");
        String actualTitle = driver.getTitle();
        String yanlisTitle = "youtube";
        Assert.assertFalse(actualTitle.equals(yanlisTitle));
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }


}
