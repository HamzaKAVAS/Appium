package day01;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class HesapMak {

    AndroidDriver<AndroidElement> driver;

    @Test
    public void hesapMakinesi() throws MalformedURLException {
        // Kullanici gerekli kurulumları yapar
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 148");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "D:\\Java\\SeleniumProject\\HmzAppium\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");
        // capabilities.setCapability(MobileCapabilityType.APP,"D:\\Java\\SeleniumProject\\HmzAppium\\Apps\\Apk Bilgisi_2.3.4_apkcombo.com.apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Uygulamanın yüklendigi dogrulanır
        assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // Uygulamanın acıldıgını dogrular
        assertTrue(driver.findElementById("com.google.android.calculator:id/op_pct").isDisplayed());

        // 650 un 2 katinin 1300 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("6").click();
        driver.findElementByAccessibilityId("5").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();

        String islemSonucu = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        int beklenenSonuc = 1300;

        assertEquals(Integer.parseInt(islemSonucu), beklenenSonuc);
    }
}
