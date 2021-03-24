package tests;

import com.codeborne.selenide.Configuration;
import configs.PlatformConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

    static final PlatformConfig platformConfig = ConfigFactory.create(PlatformConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = platformConfig.getBrowserName();
        Configuration.browserVersion = platformConfig.getBrowserVersion();
        Configuration.startMaximized = true;
        String remoteWebDriver = platformConfig.getRemoteWebDriver();

        if (remoteWebDriver != null) {
            Configuration.remote = remoteWebDriver;
        }
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}
