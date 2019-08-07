package dataProviders;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "/Users/dom/Learning/Selenium/AutomationPracticeCucumberFramework/configs/Configuation.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties file not found at " + properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null)
            return driverPath;
        else throw new RuntimeException("Driver path not specified in Configuration properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null)
            return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("Implicitly wait not specified in Configuration properties file.");
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");
        if (baseUrl != null)
            return baseUrl;
        else throw new RuntimeException("Base URL not specified in Configuration properties file.");
    }

    public EnvironmentType getEnvironment() {
        String environment = properties.getProperty("environment");
        if (environment == null || environment.equalsIgnoreCase("local"))
            return EnvironmentType.LOCAL;
        else if (environment.equalsIgnoreCase("remote"))
            return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment (" + environment + ") in Configuration properties file not recognised.");
    }

    public DriverType getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser == null || browser.equalsIgnoreCase("chrome"))
            return DriverType.CHROME;
        else if (browser.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else if (browser.equalsIgnoreCase("internetExplorer"))
            return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser (" + browser + ") in Configuration properties file not recognised.");
    }

    public boolean getWindowMaximise() {
        String windowMaximise = properties.getProperty("windowMaximise");
        if (windowMaximise != null)
            return Boolean.parseBoolean(windowMaximise);
        else return true;
    }

    public String getTestDataResourcePath() {
        String testDataResourcesPath = properties.getProperty("testDataResourcesPath");
        if (testDataResourcesPath != null)
            return testDataResourcesPath;
        else throw new RuntimeException("Test data resources path not specified in Configuration properties file.");
    }

}
