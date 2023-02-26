package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private final By inputName = By.xpath("//input[@placeholder='* Имя']"); //Локаторы полей в форме заказа
    private final By inputLastName = By.xpath("//input[@placeholder='* Фамилия']");
    private final By inputAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By inputMetro = By.xpath("//input[@placeholder='* Станция метро']");
    private final By inputPhoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By selectedMetro = By.xpath("//button[@value='1']"); // Конкретное метро "Бульвар Рокоссовского"
    private final By btnNextPage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка "Далее"
    private final By whenToBringAScooter = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By timeOfOrder = By.xpath("//span[@class='Dropdown-arrow']");
    private final By selectForDay = By.xpath("//div[@class='Dropdown-option' and text()='сутки']"); //Вариант выбора "сутки"
    private final By selectColourScooter = By.xpath("//label[@class='Checkbox_Label__3wxSf' and @for='black']"); //Вариант выбора "Черный жемчуг"
    private final By commentForCourier = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private final By btnForOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка "Заказать"
    private final By btnAcceptOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']"); // Кнопка принятия заказа (ни к чему не приводит в Chrome)
    private final By containerOrderIsReady = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']"); //Окно об успешном оформлении заказа
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    //Метод для ввода данных в форме
    public void fillingInputsFields() {
        driver.findElement(inputName).sendKeys("Павел");
        driver.findElement(inputLastName).sendKeys("Корчагин");
        driver.findElement(inputAddress).sendKeys("ул. Пушкина, д. Колотушкина");
        driver.findElement(inputMetro).click();
        driver.findElement(selectedMetro).click();
        driver.findElement(inputPhoneNumber).sendKeys("89997771122");
        driver.findElement(btnNextPage).click();
    }
    //Метод для ввода данных в последующей форме
    public void fillingInputsFieldsFinal() {
        driver.findElement(whenToBringAScooter).sendKeys("21.03.23");
        driver.findElement(timeOfOrder).click();
        driver.findElement(selectForDay).click();
        driver.findElement(selectColourScooter).click();
        driver.findElement(commentForCourier).sendKeys("Я верю в твою работоспособность");
        driver.findElement(btnForOrder).click();
        driver.findElement(btnAcceptOrder).click();
    }
    //После заполнения формы вылазиет окно об оформлении заказа. Метод проверяет наличие этого окна.
    public void checkContainerOrderIsReady() {
        driver.findElement(containerOrderIsReady).isEnabled();
    }

}
