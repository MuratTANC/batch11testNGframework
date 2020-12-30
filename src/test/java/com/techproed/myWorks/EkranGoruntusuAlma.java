package com.techproed.myWorks;

import com.techproed.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class EkranGoruntusuAlma extends TestBase {

@Test
    public void test1() throws IOException {

        driver.get("https://www.google.com/");

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\MuratTANC\\Documents\\screenshot.jpg"));
    }
    @Test
    public void test2(){


    }
}
