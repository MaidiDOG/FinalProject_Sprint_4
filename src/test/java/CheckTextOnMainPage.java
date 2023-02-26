import extensions.WebDriverFactory;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.hamcrest.CoreMatchers.is;
import static pages.MainPage.textOnPanel0;
import static pages.MainPage.textOnPanel1;

public class CheckTextOnMainPage {

    private WebDriver driver;

    @Before

    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkTextOnMainPageInBottomButton0() {
        MainPage page = new MainPage(driver);
        page.findAndClickBtnAccordionItem0();
        String getTextOnPanel0 = page.checkTextBtnAccordionItem0();
        MatcherAssert.assertThat("После нажатия на стрелочку, открывается соответствующий текст", getTextOnPanel0, is(textOnPanel0)); //Тест проверяет схожесть текста фактического с ожидаемым.
    }

    @Test
    public void checkTextOnMainPageInBottomButton1() {
        MainPage page = new MainPage(driver);
        page.findAndClickBtnAccordionItem1();
        String getTextOnPanel1 = page.checkTextBtnAccordionItem1();
        MatcherAssert.assertThat("После нажатия на стрелочку, открывается соответствующий текст", getTextOnPanel1, is(textOnPanel1));//Тест проверяет схожесть текста фактического с ожидаемым.
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
