package parabank.config.data;

import parabank.Users.Users;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import parabank.config.properties.ConstantValues;
import parabank.config.util.ResourceHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class DataLoader {
    public static synchronized <T> T loadJson(String relativePathToFile, String filename, Class<T> clazz) throws DataLoaderException {
        //to accept filename with and without extension
        if(!filename.contains(".json")) filename = filename + ".json";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File file = null;
        try {
            file = new File(ResourceHelper.getResourceAsURI(relativePathToFile + filename));

        } catch (Exception e) {
            String stacktrace = "";
            for (StackTraceElement element : e.getStackTrace()) stacktrace += element.toString() + '\n';
            throw new DataLoaderException("File: " + relativePathToFile + filename + " has failed to load \n" +
                    "Please verify path, or debug within DataLoader\n" +
                    "Message: " + e.getMessage() + "\n" +
                    "Stracktrace:\n" + stacktrace);
        }
        try {
            return mapper.readValue(file, clazz);
        } catch (Exception e) {
            String stacktrace = "";
            for (StackTraceElement element : e.getStackTrace()) stacktrace += element.toString() + "\n";
            throw new DataLoaderException("File" + relativePathToFile + filename + "could not be mapped from json to given class \n" +
                    "Please check if " + relativePathToFile + filename + " is correct, or debug within DataLoader\n" +
                    "Message: " + e.getMessage() + "\n" +
                    "Straktrace:\n" + stacktrace);

        }
    }

    public static synchronized <T> T loadJson(String fileName, Class<T> clazz) throws DataLoaderException {
        return loadJson(ConstantValues.DATA_PATH, fileName, clazz);
    }
    public static synchronized <T> T getUsersData(String user) throws DataLoaderException {
        return loadTestObjects(ConstantValues.USERS_PATH, ConstantValues.USERS_DEFAULT_FILENAME, (Class<T>) Users.class, user);
    }
    public static synchronized Map<String, Users> getAllUsersMap() {
        return loadUsersMapFromJSON(ConstantValues.USERS_PATH, ConstantValues.USERS_DEFAULT_FILENAME);
    }
    @SneakyThrows
    public static synchronized Map<String, Users> loadUsersMapFromJSON(String pathToFile, String filename) {
        filename = (!filename.contains(".")) ? (filename + ".json") : filename;
        Map<String, Object> map = convertToMap(pathToFile + filename);
        Map<String, Users> usersMap = new ObjectMapper().convertValue(map, new TypeReference<Map <String, Users>>() {
        });
        return usersMap;
    }

    public static synchronized <T> T loadTestObjects(String pathToFile, String filename, Class<T> clazz, String... nodes) {
        filename = (!filename.contains(".")) ? (filename + ".json") : filename;
        Map<String, Object> map = convertToMap(pathToFile + filename);
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        for (String node : nodes) {
            map = (Map<String, Object>) map.get(node);
        }
        return mapper.convertValue(map, clazz);
    }
    public static synchronized <T> T loadTestObjects(String filename, Class<T> clazz, String... nodes) {
        return loadTestObjects(ConstantValues.DATA_PATH, filename, clazz, nodes);
    }
    public static synchronized Map<String, Object> convertToMap(String pathToFile) {
        BufferedReader file = null;
        Map<String, Object> result = null;
        try {
            InputStreamReader reader = new InputStreamReader(ResourceHelper.getResourceAsInputStream(pathToFile), "UTF-8");
            file = new BufferedReader(reader);
            ObjectMapper mapper = new ObjectMapper();
            result = new ObjectMapper().convertValue(mapper.readTree(file), TreeMap.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
