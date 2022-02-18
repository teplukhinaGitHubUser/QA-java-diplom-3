import com.UserOperations;
import com.pageObject.LoginPage;
import com.pageObject.MainPage;
import com.pageObject.RegistrationPage;
import com.pageObject.ResetPasswordPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ResetPasswordPage resetPasswordPage;
    UserOperations userOperations;
    Map<String, String> response = new HashMap<>();

    private void login(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickToLoginButton();
    }


    @BeforeEach
    public void setUp() {
        userOperations = new UserOperations();
        response = userOperations.register();
        startMaximized = true;
        mainPage = open(MainPage.URL, MainPage.class);
        loginPage = page(LoginPage.class);
        registrationPage = page(RegistrationPage.class);
        resetPasswordPage = page(ResetPasswordPage.class);
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Проверяем, что юзер залогинился")
    public void loginByGoToAccountButton() throws InterruptedException {
        mainPage.clickToGoToAccountButton();
        login(response.get("email"), response.get("password"));
        Assertions.assertTrue(mainPage.orderButtonIsVisible());
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    @Description("Проверяем, что юзер залогинился")
    public void loginByAccountButton() {
        mainPage.clickToAccountButton();
        login(response.get("email"), response.get("password"));
        Assertions.assertTrue(mainPage.orderButtonIsVisible());

    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяем, что юзер залогинился")
    public void loginFromRegistrationPage() {
        mainPage.clickToAccountButton();
        loginPage.clickToRegistrationButton();
        registrationPage.clickToLoginButton();
        login(response.get("email"), response.get("password"));
        Assertions.assertTrue(mainPage.orderButtonIsVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяем, что юзер залогинился")
    public void loginByResetPasswordButton() {
        mainPage.clickToAccountButton();
        loginPage.clickToResetPasswordButton();
        resetPasswordPage.clickToLoginButton();
        login(response.get("email"), response.get("password"));
        Assertions.assertTrue(mainPage.orderButtonIsVisible());
    }

    @AfterEach
    public void tearDown() {
        userOperations.delete();
    }
}
