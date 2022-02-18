import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    WebDriver webDriver;

    @BeforeEach
    public void initBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files (x86)/Yandex/YandexBrowser/Application/browser.exe");
        webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    }

    @AfterEach
    public void closeBrowser() {
        webDriver.close();
        webDriver.quit();
    }
}
