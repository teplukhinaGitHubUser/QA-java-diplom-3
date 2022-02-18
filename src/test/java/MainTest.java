import com.pageObject.MainPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.open;

public class MainTest extends BaseTest {
    MainPage mainPage;

    @BeforeEach
    public  void setUp(){
        startMaximized = true;
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    @DisplayName("Переход к раздеру Булки")
    @Description("Проверяем, что раздел открылся")
    public void openBunsTab()  {
        mainPage.clickToMain();
        mainPage.clickToBuns();
        Assertions.assertTrue(mainPage.isBunsHeaderVisible());
    }
    @Test
    @DisplayName("Переход к раздеру Начинки")
    @Description("Проверяем, что раздел открылся ")
    public void openMainTab()  {
        mainPage.clickToMain();
        Assertions.assertTrue(mainPage.isMainHeaderVisible());
    }

    @Test
    @DisplayName("Переход к раздеру Соусы")
    @Description("Проверяем, что раздел открылся")
    public void openSaucesTab()  {
        mainPage.clickToSauces();
        Assertions.assertTrue(mainPage.isSaucesHeaderVisible());
    }

    @AfterEach
    public void tearDown(){
        if(!mainPage.isBunsHeaderVisible()) {
            mainPage.clickToBuns();
        }
    }
}
