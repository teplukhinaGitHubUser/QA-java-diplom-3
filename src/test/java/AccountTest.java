import com.UserOperations;
import com.pageObject.*;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AccountTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    UserOperations userOperations;
    Map<String, String> response = new HashMap<>();
    ProfilePage profilePage;

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
        profilePage = page(ProfilePage.class);
        mainPage.clickToAccountButton();
        login(response.get("email"), response.get("password"));
    }

    @Test
    @DisplayName("Переход по клику на Личный кабинет")
    @Description("Проверяем, что страница Личный кабинет открыта")
    public void openAccountPage() {
        mainPage.clickToAccountButton();
        Assertions.assertTrue(profilePage.profileButtonIsDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на Конструктор")
    @Description("Проверяем, что главная страница открыта")
    public void openMainPageFromAccountPageClickingToConstructor() {
        mainPage.clickToAccountButton();
        profilePage.clickToConstructorButton();
        Assertions.assertTrue(mainPage.orderButtonIsVisible());
    }

    @Test
    @DisplayName("Переход по клику на Логотип")
    @Description("Проверяем, что главная страница открыта")
    public void openMainPageFromAccountPageClickingToLogo() {
        mainPage.clickToAccountButton();
        profilePage.clickToLogoButton();
        Assertions.assertTrue(mainPage.orderButtonIsVisible());
    }

    @Test
    @DisplayName("Кнопка Выход")
    @Description("Проверяем, что юзер разлогинился")
    public void logout() {
        mainPage.clickToAccountButton();
        profilePage.clickToLogoutButton();
        Assertions.assertTrue(loginPage.loginButtonIsDisplayed());
    }

    @AfterEach
    public void tearDown() {
        userOperations.delete();
    }
}
