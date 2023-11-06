package parabank.config.util;

import parabank.config.data.DataLoader;
import lombok.SneakyThrows;

import org.testng.reporters.Files;

import java.io.File;
import java.io.InputStream;
import java.net.URI;

public class ResourceHelper {
    @SneakyThrows
    public static URI getResourceAsURI(String relativePathToResource) {
        return DataLoader.class.getResource("/" + relativePathToResource).toURI();
    }

    @SneakyThrows
    public static InputStream getResourceAsInputStream(String relativePathToResource) {
        return DataLoader.class.getResourceAsStream("/" + relativePathToResource);
    }
    @SneakyThrows
    public static File getResourceAsFile(String relativePathToResource) {
        return new File(getResourceAsURI(relativePathToResource));
    }

    @SneakyThrows
    public static String getResourceAsString(String relativePathToResource) {
        return Files.readFile(getResourceAsFile(relativePathToResource));
    }


}
