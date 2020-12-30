package com.techproed.smokeTest;

import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlbSignUpTest {

    @Test (groups = "group1")
    public void signUpTest() throws InterruptedException {
        GlbSignUpPage glbSignUpPage = new GlbSignUpPage();
        Driver.getDriver().get(ConfigReader.getProperty("urlGlblTrdrRegister"));
        glbSignUpPage.emailTextBox.sendKeys(ConfigReader.getProperty("emailGlblTrdr"));
        glbSignUpPage.nameTextBox.sendKeys(ConfigReader.getProperty("nameGlblTrdr"));
        glbSignUpPage.phoneTextBox.sendKeys(ConfigReader.getProperty("mobileGlblTrdr"));
        glbSignUpPage.ilkPassword.sendKeys(ConfigReader.getProperty("passwordGlblTrdr"));
        glbSignUpPage.ikinciPassword.sendKeys(ConfigReader.getProperty("passwordGlblTrdr"));
        glbSignUpPage.signUpButton.click();
        Thread.sleep(5000);

        Assert.assertTrue(glbSignUpPage.successMesaji.isDisplayed());
        Driver.closeDriver();

    }
}
