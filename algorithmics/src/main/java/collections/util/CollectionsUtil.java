package collections.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CollectionsUtil {

    private CollectionsUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static final SecureRandom random = new SecureRandom();
    private static final Logger LOGGER = Logger.getLogger(CollectionsUtil.class.getName());

    public static String readFromFile(String filePath) {
        String tagsString = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            while(bufferedReader.ready()) {
                stringBuilder.append((char)bufferedReader.read());
            }
            tagsString = stringBuilder.toString();
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
        return tagsString;
    }

    public static List<Integer> fillListRandom(List<Integer> inputList, int elementsCount) {
        for (int i = 0; i < elementsCount; i++) {
            inputList.add(random.nextInt());
        }
        return inputList;
    }
}
