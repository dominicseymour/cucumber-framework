package managers;

import dataProviders.ConfigFileReader;
import dataProviders.JsonDataReader;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static JsonDataReader jsonDataReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigFileReader() {
        if (configFileReader != null)
            return configFileReader;
        else return configFileReader = new ConfigFileReader();
    }

    public JsonDataReader getJsonDataReader() {
        if (jsonDataReader != null)
            return jsonDataReader;
        else return jsonDataReader = new JsonDataReader();
    }
}
