package dataProviders;

import com.google.gson.Gson;
import managers.FileReaderManager;
import testDataTypes.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {

    private final String userFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "User.json";
    private List<User> userList;

    public JsonDataReader() {
        this.userList = getUserData();
    }

    private List<User> getUserData() {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(userFilePath));
            User[] users = gson.fromJson(bufferedReader, User[].class);
            return Arrays.asList(users);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + userFilePath);
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ignore) {
            }
        }
    }

    public final User getUserByName(final String userName) {
        return userList.stream().filter(x -> x.firstName.equalsIgnoreCase(userName)).findAny().get();

    }
}
