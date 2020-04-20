package threads.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadsUtil {

    private final static Logger LOGGER = Logger.getLogger(ThreadsUtil.class.getName());

    public static double[][] readMatrixFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine());
            }
            int matrixWidth = lines.get(0).split(" ").length;
            int matrixHeight = lines.size();
            double[][] matrix = new double[matrixHeight][matrixWidth];
            for (int i = 0; i < matrixHeight; i++) {
                String[] line = lines.get(i).split(" ");
                for (int j = 0; j < matrixWidth; j++) {
                    matrix[i][j] = Double.parseDouble(line[j]);
                }
            }
            return matrix;
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        throw new NullPointerException("Error load from file");
    }

    public static void writeMatrixToFile(String filePath, int matrixWidth, int matrixHeight, int value) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixHeight; j++) {
                    fileWriter.append(String.valueOf(value)).append(" ");
                }
                fileWriter.append("\n");
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }
}
