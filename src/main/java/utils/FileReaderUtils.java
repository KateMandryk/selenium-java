package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class FileReaderUtils {
    private final String fileUsers = "src/main/resources/user.json";
    private final String fileConfig = "src/main/resources/data.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<User> getUser() {
        File file1 = new File(fileUsers);
        List<User> expectedUsers = null;
        {
            try {
                expectedUsers = objectMapper.readValue(file1, new TypeReference<List<User>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return expectedUsers;
    }

    public String getValue(String name) {
        JSONParser parser = new JSONParser();
        Reader reader = null;
        try {
            reader = new java.io.FileReader(fileConfig);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object jsonObj = null;
        try {
            jsonObj = parser.parse(reader);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) jsonObj;
        assert jsonObject != null;
        String config = (String) jsonObject.get(name);

        try {
            assert reader != null;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;

    }

}

