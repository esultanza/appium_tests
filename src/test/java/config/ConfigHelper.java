package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getUsername() {
        return getConfig().username();
    }

    public static String getPassword() {
        return getConfig().password();
    }

    public static String getApp() {
        return getConfig().app();
    }

    private static MobileConfig getConfig() {
        return ConfigFactory.newInstance().create(MobileConfig.class, System.getProperties());
    }
}
