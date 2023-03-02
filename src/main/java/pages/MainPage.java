package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private final By scooterLogo = By.xpath("//img[@alt='Scooter']"); //Логотип со скутера
    private final By homePageBody = By.xpath("//div[@class='Home_HomePage__ZXKIX']"); //Контейинер с элементами главной страницы сервиса "Самокат"
    private final By yandexLogo = By.xpath("//img[@alt='Yandex']"); //Логотип Яндекса
    private final By yandexLogoNewPage = By.xpath("//a[@href='https://ya.ru/']"); //Главная страница Яндекса (хотя я не уверен, что есть главная страница)


    public MainPage(WebDriver driver) {
        this.driver = driver;
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
