package tests.day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class ArabamCom {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void arabamComApkYukleme() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 148");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage", "com.dogan.arabam");
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    // uygulamanin basarili bir sekilde yuklendigi dogrulanir
    // uygulamanin basarili bir sekilde acildigi dogrulanir
    // alt menuden ilan ara butonuna tiklanir
    // kategori olarak otomobil secilir
    // arac markası olarak Volkswagen secilir
    // arac modeli olarak passat secilir
    // 1.4 TSI BlueMotion secilir
    // Paket secimi comfortline yapilir
    // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
    // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir

    @Test
    public void test01() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulamanin basarili bir sekilde acildigi dogrulanir
        assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@*='Otomobil']").click();

        // arac markası olarak Volkswagen secilir
        Thread.sleep(2000);
        TouchAction action = new TouchAction<>(driver);

        action.press(PointOption.point(500, 1830)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(70)))
                .moveTo(PointOption.point(500, 409)).release().perform();

        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac modeli olarak passat secilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi comfortline yapilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Comfortline']").click();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Sıralama']").click();
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String enUcuzArabaFiyati = driver.findElementByXPath("(//*[@*='com.dogan.arabam:id/tvPrice'])[1]").getText();
        enUcuzArabaFiyati = enUcuzArabaFiyati.replaceAll("\\D", "");
        assertTrue(Integer.parseInt(enUcuzArabaFiyati) > 500000);
    }

    // alt menuden ilan ara butonuna tiklanir
    // kategori olarak Kiralık Araçlar secilir
    // arac olarak Minivan&Panelvan secilir
    // arac markasi olarak peugeot secilir
    // Bipper secilir
    // listenin geldigi dogrulanir

    @Test
    public void test02() throws InterruptedException {
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak Kiralık Araçlar secilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Kiralık Araçlar']").click();

        // arac olarak Minivan&Panelvan secilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Minivan & Panelvan']").click();

        // arac markasi olarak peugeot secilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Peugeot']").click();

        // Bipper secilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Bipper']").click();

        // listenin geldigi dogrulanir
        Thread.sleep(2000);
        String ilanSayisi = driver.findElementById("com.dogan.arabam:id/texViewSubtitle").getText();
        ilanSayisi = ilanSayisi.replaceAll("\\D", "");
        assertTrue(Integer.parseInt(ilanSayisi) > 0);
    }
}
