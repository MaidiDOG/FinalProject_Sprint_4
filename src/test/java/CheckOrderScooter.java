import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.OrderPage;

public class CheckOrderScooter {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkOrderScooterOnMainPage() {
        MainPage page = new MainPage(driver);
        page.clickOrderScooterButton();
        OrderPage oPage = new OrderPage(driver);
        oPage.fillingInputsFields();
        oPage.fillingInputsFieldsFinal();
        oPage.checkContainerOrderIsReady();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
