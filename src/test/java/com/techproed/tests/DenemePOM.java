package com.techproed.tests;

import com.techproed.pages.DenemePage;
import com.techproed.pages.FaceBookPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class DenemePOM extends TestBase {

    @Test
        public void test() {

        driver.get(ConfigReader.getProperty("gmi_url"));
        DenemePage denemePage = new DenemePage(driver);
        denemePage.kisiSimgesi.click();
        denemePage.signIn.click();
        denemePage.userTextBox.sendKeys(ConfigReader.getProperty("gmi_user"));
        denemePage.passwordTextBox.sendKeys(ConfigReader.getProperty("gmi_password"));
    }
}
