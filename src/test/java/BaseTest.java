import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    WebDriver webDriver;

    @BeforeEach
    public void initBrowser() {
        System.setProperty("browser","yandex");
        if (System.getProperty("browser") == "yandex") {
            System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
            webDriver = new ChromeDriver();
            setWebDriver(webDriver);
        }
    }

    @AfterEach
    public void closeBrowser() {
        if (System.getProperty("browser") == "yandex") {
            webDriver.quit();
        }

    }

}
