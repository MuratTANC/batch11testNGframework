package com.techproed.tests;

import com.techproed.pages.GmiBankPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class GmiBankPOM extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get(ConfigReader.getProperty("gmi_url"));
        GmiBankPage gmiBankPage = new GmiBankPage(driver);
        gmiBankPage.kisiSimgesi.click();
        gmiBankPage.signIn.click();
        gmiBankPage.userTextBox.sendKeys(ConfigReader.getProperty("gmi_user"));
        gmiBankPage.passwordTextBox.sendKeys(ConfigReader.getProperty("gmi_password"));
        gmiBankPage.signInButton.click();
        Thread.sleep(10000);
    }
}
