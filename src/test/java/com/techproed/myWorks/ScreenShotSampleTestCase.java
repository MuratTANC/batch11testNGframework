package com.techproed.myWorks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.techproed.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ScreenShotSampleTestCase extends TestBase {

    WebDriver driver;

    @Test(priority = 0)
    public void SampleFailedTestCase() {

        //Start Browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Google a yönlendiriliyor.
        driver.get("https://www.google.com.tr/");
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

        //Olmayan bir id yi bulmaya çalışıyor.
        driver.findElement(By.id("BİLEREK-YANLIŞ-ID-VERİYORUM"));

    }

    @AfterMethod
    public void FailedTestCaseScreenShot(ITestResult result) throws IOException {

        if(ITestResult.FAILURE==result.getStatus()) {

            TakesScreenshot ts=(TakesScreenshot)driver;
            File source=ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("./Screenshots/"+ result.getName() + ".png"));

        }
    }
}
