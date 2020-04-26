package files.util;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesUtil {

    private FilesUtil() {

    }

    private static final Logger LOGGER = Logger.getLogger(FilesUtil.class.getName());

    public static List<String> readFromFile(String fileName) {
        LinkedList<String> list = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                list.add(bufferedReader.readLine());
            }
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
        return list;
    }

    public static void writeToFile(String fileName, List<String> list) {
        try (BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(fileName))) {
            for (String element : list) {
                bufferedReader.write(element);
                bufferedReader.newLine();
            }
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
        }
    }
}
