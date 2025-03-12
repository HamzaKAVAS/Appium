package tests.day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ToDoList {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void toDoList() throws MalformedURLException {

        // Kullanici gerekli kurulumlari yapar
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 148");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "todolist.scheduleplanner.dailyplanner.todo.reminders");
        caps.setCapability("appActivity", "app.todolist.activity.SplashActivity");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    // uygulamanin basarili bir sekilde yuklendigi dogrulanir
    // uygulaminin basarili bir sekilde acildigi dogrulanir
    // Ileri butonlarina tiklanir ve pop-up lar kapatilir
    // görev ekleme adimina gecilir
    // görev adi girilir
    // görev kaydedilir
    // görev silinir
    // Görev olusturma sayfasina geri dönüldügü dogrulanir
}
