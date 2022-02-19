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
        if(!mainPage.getSelectedTab().equals("Булки")) {
            mainPage.clickToBuns();
        }
        Assertions.assertEquals("Булки",mainPage.getSelectedTab());
    }
    @Test
    @DisplayName("Переход к раздеру Начинки")
    @Description("Проверяем, что раздел открылся ")
    public void openMainTab()  {
        mainPage.clickToMain();
        Assertions.assertEquals("Начинки",mainPage.getSelectedTab());
    }

    @Test
    @DisplayName("Переход к раздеру Соусы")
    @Description("Проверяем, что раздел открылся")
    public void openSaucesTab()  {
        mainPage.clickToSauces();
        Assertions.assertEquals("Соусы",mainPage.getSelectedTab());
    }

}
