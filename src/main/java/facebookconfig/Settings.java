package facebookconfig;

import java.io.IOException;

public class Settings {

    public static String browserName;
    public static String chromeDriverPath;
    public static String chromeDriverValue;
    public static String websiteUrl;
    public static boolean isHeadless;  // Updated field name for headless setting

    static {
        try {
            ConfigReader.populateSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
