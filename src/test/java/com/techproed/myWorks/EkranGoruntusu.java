//github denemesi

package com.techproed.myWorks;

import com.techproed.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class EkranGoruntusu {
    @Test
    public void test1() throws IOException {

        Driver.getDriver().get("https://www.google.com");
        File srcFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\MuratTANC\\Documents\\screenshot.jpg"));

    }
}
