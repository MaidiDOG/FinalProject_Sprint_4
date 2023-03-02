import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class CheckClickOnLogo {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkLogoScooterGoesInMainPage() {
        MainPage page = new MainPage(driver);
        page.checkOnScooterLogoClick();
    }

    @Test
    public void checkLogoYandexGoesInMainPageYa() {
        MainPage page = new MainPage(driver);
        page.checkOnYandexLogoClick();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
