package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "(//*[@*='android.widget.Button'])[4]")
    public WebElement continueAsGuest;

    @FindBy(xpath = "//*[@*='Return']")
    public WebElement returnTrip;

    @FindBy(xpath = "//*[@*='One way']")
    public WebElement oneWay;
}
