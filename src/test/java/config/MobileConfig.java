package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:local.properties",
        "classpath:remote.properties"
})
public interface MobileConfig extends Config {
    @Key("browserstack.username")
    String username();

    @Key("browserstack.password")
    String password();

    @Key("browserstack.app")
    String app();
}
