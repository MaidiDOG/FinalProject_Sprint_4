import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.OrderPage;

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
        this.colourScooter = colourScooter;
        this.comment = comment;
    }
    public WebDriver driver;
    @Parameterized.Parameters
    public static Object[][] getButtonInfo() {
        return new Object[][]{
                {By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"), "Павел", "Корчагин", "ул. Пушкина, д. Колотушкина",By.xpath("//button[@value='1']"), "89997771122", "21.03.23", By.xpath("//label[@class='Checkbox_Label__3wxSf' and @for='black']"), "Я верю в твою работоспособность"},
                {By.className("Button_Button__ra12g"), "Алёна", "Вавилоновна", "ул. Арбат, д.3, кв. 45", By.xpath("//button[@value='3']"), "81234567890", "04.03.23", By.xpath("//label[@class='Checkbox_Label__3wxSf' and @for='grey']"), "Хочу самокат"},
        };
    }
    @Before
    public void setup() {
        driver = WebDriverFactory.get();

    }

    @Test
    public void checkOrderScooterOnMainPage() {
        OrderPage oPage = new OrderPage(driver);
        oPage.findBtnOrderScooter(btnOrderScooter);
        oPage.inputNameText(name);
        oPage.inputLastNameText(lastName);
        oPage.inputAddressText(street);
        oPage.inputMetroChoice(metroStation);
        oPage.inputPhoneNumberText(phoneNumber);
        oPage.btnNextPageChoice();
        oPage.whenToBringAScooter(date);
        oPage.timeOfOrderChoice();
        oPage.selectColourScooterChoice(colourScooter);
        oPage.commentForCourierText(comment);
        oPage.fillingInputsFields();
        oPage.checkContainerOrderIsReady();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
