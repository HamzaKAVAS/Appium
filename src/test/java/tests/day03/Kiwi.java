package tests.day03;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Kiwi {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPage page = new KiwiPage();

    // uygulamanin yuklendigi dogrulanir
    // uygulamanin basariyla acildigi dogrulanir
    // misafir olarak devam et e tiklanir
    // ardindan gelecek olan 3 adimda da yesil butona basilarak devam edilir
    // Trip type,one way olarak secilir
    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
    // gidis tarihi 28 Mart olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    @Test
    public void kiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled(ConfigReader.getProperty("kiwiAppPackage")));

        // uygulamanin basariyla acildigi dogrulanir
        Thread.sleep(2000);
        Assert.assertTrue(page.continueAsGuest.isDisplayed());

        // misafir olarak devam et e tiklanir
        Thread.sleep(2000);
        page.continueAsGuest.click();

        // ardindan gelecek olan 3 adimda da yesil butona basilarak devam edilir
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklamaMethodu(550, 2060, 300);
        }

        // Trip type,one way olarak secilir
        Thread.sleep(2000);
        page.returnTrip.click();
        Thread.sleep(2000);
        page.oneWay.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        Thread.sleep(2000);
        page.fromButonu.click();
        Thread.sleep(2000);
        page.silmeButonu.click();

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        page.fromTextArea.click();

        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("Ankara"); // Telefon tuslarindan gönderme
        } else {
            page.fromTextArea.sendKeys("Ankara"); // Pcden gönderme
        }
        Thread.sleep(2000);
        page.kalkisVarisUlkesiButonu.click();
        Thread.sleep(2000);
        page.chooseButton.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        Thread.sleep(2000);
        page.toButonu.click();
        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("Frankfurt"); // Telefon tuslarindan gönderme
        } else {
            page.fromTextArea.sendKeys("Frankfurt"); // Pcden gönderme
        }
        Thread.sleep(2000);
        page.kalkisVarisUlkesiButonu.click();
        Thread.sleep(2000);
        page.chooseButton.click();
    }
}
