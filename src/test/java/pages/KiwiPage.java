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

    @FindBy(xpath = "//*[@*='From:']")
    public WebElement fromButonu;

    @FindBy(xpath = "//*[@content-desc='Clear All']")
    public WebElement silmeButonu;

    @FindBy(xpath = "(//*[@class='android.view.View'])[4]")
    public WebElement fromTextArea;

    @FindBy(xpath = "(//*[@class='android.widget.Button'])[2]")
    public WebElement kalkisVarisUlkesiButonu;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(xpath = "//*[@text='To:']")
    public WebElement toButonu;

    @FindBy(xpath = "//*[@text='Departure:']")
    public WebElement tarihButonu;


}
