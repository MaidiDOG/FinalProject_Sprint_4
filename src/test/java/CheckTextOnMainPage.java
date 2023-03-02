import extensions.WebDriverFactory;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class CheckTextOnMainPage {
    private By btnForOpenContainer;
    private String textInContainer;
    private By containerWithText;
    public CheckTextOnMainPage (By btnForOpenContainer, String textInContainer, By containerWithText) {
        this.btnForOpenContainer = btnForOpenContainer;
        this.textInContainer = textInContainer;
        this.containerWithText = containerWithText;
    }
    @Parameterized.Parameters
    public static Object[][] getButtonInfo() {
        return new Object[][]{
                {By.id("accordion__heading-0"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", By.id("accordion__panel-0")},
                {By.id("accordion__heading-1"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", By.id("accordion__panel-1")},
                {By.id("accordion__heading-2"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", By.id("accordion__panel-2")},
                {By.id("accordion__heading-3"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", By.id("accordion__panel-3")},
                {By.id("accordion__heading-4"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", By.id("accordion__panel-4")},
                {By.id("accordion__heading-5"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", By.id("accordion__panel-5")},
                {By.id("accordion__heading-6"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", By.id("accordion__panel-6")},
                {By.id("accordion__heading-7"), "Да, обязательно. Всем самокатов! И Москве, и Московской области.", By.id("accordion__panel-7")},
        };
    }

    private WebDriver driver;


    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkTextOnMainPageInBottomButton0() {
        WebElement element = driver.findElement(btnForOpenContainer);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(btnForOpenContainer).click();
        MatcherAssert.assertThat("После нажатия на стрелочку, открывается соответствующий текст", driver.findElement(containerWithText).getText(), is(textInContainer)); //Тест проверяет схожесть текста фактического с ожидаемым.
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
