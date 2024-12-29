package facebookconfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static void populateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        try {
            reader.readProperty();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Failed to read properties from config file.");
        }
    }

    private void readProperty() throws IOException {
        Properties prop = new Properties();

        // Load the properties file from the specified path
        String configFilePath = "src/main/resources/config.properties";
        FileInputStream file = new FileInputStream(configFilePath);

        if (file == null) {
            System.out.println("Could not find the configuration file at: " + configFilePath);
            throw new IOException("Configuration file not found at: " + configFilePath);
        }

        prop.load(file);

        // Set values to Settings class
        Settings.websiteUrl = prop.getProperty("test.url");
        Settings.browserName = prop.getProperty("browser");
        Settings.isHeadless = Boolean.parseBoolean(prop.getProperty("headless.browser"));

        // Add debug logging for the loaded properties
        System.out.println("Loaded properties: ");
        System.out.println("Website URL: " + Settings.websiteUrl);
        System.out.println("Browser: " + Settings.browserName);
        System.out.println("Headless mode: " + Settings.isHeadless);
    }
}
