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
    public void inputNameText(String name) {
        driver.findElement(inputName).sendKeys(name);
    }
    public void inputLastNameText(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
    }
    public void inputAddressText(String street) {
        driver.findElement(inputAddress).sendKeys(street);
    }
    public void inputMetroChoice(By metroStation) {
        driver.findElement(inputMetro).click();
        driver.findElement(metroStation).click();
    }
    public void inputPhoneNumberText(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }
    public void btnNextPageChoice() {
        driver.findElement(btnNextPage).click();
    }
    public void whenToBringAScooter(String date) {
        driver.findElement(whenToBringAScooter).sendKeys(date);
    }
    public void timeOfOrderChoice() {
        driver.findElement(timeOfOrder).click();
        driver.findElement(selectForDay).click();
    }
    public void selectColourScooterChoice(By colourScooter) {
        driver.findElement(colourScooter).click();
    }
    public void commentForCourierText(String comment) {
        driver.findElement(commentForCourier).sendKeys(comment);
    }
    public void fillingInputsFields() {
        driver.findElement(btnForOrder).click();
        driver.findElement(btnAcceptOrder).click();
    }
    //После заполнения формы вылазиет окно об оформлении заказа. Метод проверяет наличие этого окна.
    public void checkContainerOrderIsReady() {
        driver.findElement(containerOrderIsReady).isEnabled();
    }

}
