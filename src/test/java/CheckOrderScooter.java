import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
public class CheckOrderScooter {
    private By btnOrderScooter;
    private String name;
    private String lastName;
    private String street;
    private By metroStation;
    private String phoneNumber;
    private String date;
    private By colourScooter;
    private String comment;
    public CheckOrderScooter(By btnOrderScooter, String name, String lastName, String street, By metroStation, String phoneNumber, String date, By colourScooter, String comment) {
        this.btnOrderScooter = btnOrderScooter;
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.colourScooter =colourScooter;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getButtonInfo() {
        return new Object[][]{
                {By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"), "Павел", "Корчагин", "ул. Пушкина, д. Колотушкина",By.xpath("//button[@value='1']"), "89997771122", "21.03.23", By.xpath("//label[@class='Checkbox_Label__3wxSf' and @for='black']"), "Я верю в твою работоспособность"},
                {By.className("Button_Button__ra12g"), "Алёна", "Вавилоновна", "ул. Арбат, д.3, кв. 45", By.xpath("//button[@value='3']"), "81234567890", "04.03.23", By.xpath("//label[@class='Checkbox_Label__3wxSf' and @for='grey']"), "Хочу самокат"},
        };
    }

    private WebDriver driver;
    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    public void checkOrderScooterOnMainPage() {
        WebElement element = driver.findElement(btnOrderScooter);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element); //Находим элемент на странице.
        driver.findElement(btnOrderScooter).click();
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys(name); //Вводим данные
        driver.findElement(By.xpath("//input[@placeholder='* Фамилия']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@placeholder='* Станция метро']")).click();
        driver.findElement(metroStation).click();
        driver.findElement(By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phoneNumber);
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        driver.findElement(By.xpath("//input[@placeholder='* Когда привезти самокат']")).sendKeys(date);
        driver.findElement(By.xpath("//span[@class='Dropdown-arrow']")).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='сутки']")).click();
        driver.findElement(colourScooter).click();
        driver.findElement(By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']")).sendKeys(comment);
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        driver.findElement(By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']")).click();
        driver.findElement(By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']")).isEnabled();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
