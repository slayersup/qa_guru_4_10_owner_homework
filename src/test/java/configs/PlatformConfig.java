package configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:configurations/${platform}.properties")
public interface PlatformConfig extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("remoteWebDriver")
    String getRemoteWebDriver();

    @Key("videoStorage")
    String getVideoStorage();
}
