import com.github.javafaker.Faker;
import com.pageObject.LoginPage;
import com.pageObject.MainPage;
import com.pageObject.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    Faker faker = new Faker();

    @BeforeEach
    public void setUp() {
        startMaximized = true;
        mainPage = open(MainPage.URL, MainPage.class);
        loginPage=page(LoginPage.class);
        registrationPage=page(RegistrationPage.class);

    }

    @Test
    @DisplayName("Регистрация юзера")
    @Description("Проверяем, что юзер успешно зарегистрировался")
    public void registration_success_case() {
        mainPage.clickToAccountButton();
        loginPage.clickToRegistrationButton();
        registrationPage.setName(faker.name().username());
        registrationPage.setEmail(faker.bothify("??????@gmail.com"));
        registrationPage.setPassword("1234567");
        registrationPage.clickRegistrationButton();
        Assertions.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    @DisplayName("Регистрация юзера. Пароль меньше 6 символов")
    @Description("Проверяем, что нельзя зарегистироваться с невалидным паролем")
    public void registration_fails_when_password_less_then_six_symbols()  {
        mainPage.clickToAccountButton();
        loginPage.clickToRegistrationButton();
        registrationPage.setName(faker.name().username());
        registrationPage.setEmail(faker.bothify("??????@gmail.com"));
        registrationPage.setPassword("12345");
        registrationPage.clickRegistrationButton();
        Assertions.assertEquals("Некорректный пароль",registrationPage.getValidationMessage());

    }
}
