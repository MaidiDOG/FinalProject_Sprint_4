package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    private final By btnAccordionItem0 = By.id("accordion__heading-0"); // Локаторы кнопок раздела "Вопросы о важном"
    private final By btnAccordionItem1 = By.id("accordion__heading-1");

    private final By btnAccordionComponent0 = By.xpath("//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']"); //Локаторы с текстом разделов "Вопросы о важном"

    private final By btnAccordionComponent1 = By.xpath("//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");

    public static String textOnPanel0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой."; //Сравниваемый текст

    public static String textOnPanel1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."; //Сравниваемый текст (2)
    private final By btnOrderScooter = By.className("Button_Button__ra12g"); //Кнопка для начала заказа (верхняя)
    private final By btnOrderScooterBottom = By.className("Button_Button__ra12g"); //Кнопка для начала заказа (нижняя)
    private final By scooterLogo = By.xpath("//img[@alt='Scooter']"); //Логотип со скутера
    private final By homePageBody = By.xpath("//div[@class='Home_HomePage__ZXKIX']"); //Контейинер с элементами главной страницы сервиса "Самокат"
    private final By yandexLogo = By.xpath("//img[@alt='Yandex']"); //Логотип Яндекса
    private final By yandexLogoNewPage = By.xpath("//a[@href='https://ya.ru/']"); //Главная страница Яндекса (хотя я не уверен, что есть главная страница)


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // Метод нажимает кнопку, чтобы раскрыть текст в разделе "Вопросы о важном". Первый раздел.

    public void findAndClickBtnAccordionItem0() {
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(btnAccordionItem0).click();
    }
    //Метод возвращает текст элемента
    public String checkTextBtnAccordionItem0() {
       return driver.findElement(btnAccordionComponent0).getText();
    }

    // Метод нажимает кнопку, чтобы раскрыть текст в разделе "Вопросы о важном". Второй раздел.
    public void findAndClickBtnAccordionItem1() {
        WebElement element = driver.findElement(By.id("accordion__heading-1"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(btnAccordionItem1).click();
    }
    //Метод возвращает текст элемента
    public String checkTextBtnAccordionItem1() {
        return driver.findElement(btnAccordionComponent1).getText();
    }

    //Метод для вызова формы заказа самоката (через верхнюю кнопку)
    public void clickOrderScooterButton() {
        driver.findElement(btnOrderScooter).click();
    }
    //Метод для скрола страницы вниз(до кнопки) и вызова формы заказа самоката (через нижнюю кнопку)
    public void clickOrderScooterBottomButton() {
        WebElement element = driver.findElement(By.className("Button_Button__ra12g"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(btnOrderScooterBottom).click();
    }
    //Метод кликает на логотип и проверяет наличие контейнера с элементом главной страницы сервиса заказа самокатов "Яндекс.Самокат"
    public void checkOnScooterLogoClick() {
        driver.findElement(scooterLogo).click();
        driver.findElement(homePageBody).isEnabled();
    }
    //Метод кликает на логоти Яндекса на главной странице "Яндекс.Самокат"
    public void checkOnYandexLogoClick() {
        driver.findElement(yandexLogo).click();
        driver.findElement(yandexLogoNewPage).isEnabled();
    }


}
