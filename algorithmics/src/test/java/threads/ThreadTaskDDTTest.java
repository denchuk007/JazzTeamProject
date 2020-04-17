package threads;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import threads.util.ThreadsUtil;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ThreadTaskDDTTest {

    private static final ThreadTask threadTask = new ThreadTask();
    private static final String THREADS_FILE_PATH = "src/main/resources/threads/";
    private static final String THREADS_ROOT_FILE_PATH = THREADS_FILE_PATH + "root/";
    private static final String THREADS_ACTUAL_FILE_PATH = THREADS_FILE_PATH + "actual/";
    private final double[][] firstMatrix;
    private final double[][] secondMatrix;
    private final double[][] multipliedMatrix;

    public ThreadTaskDDTTest(double[][] firstMatrix, double[][] secondMatrix, double[][] multipliedMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.multipliedMatrix = multipliedMatrix;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        File threadsRootFiles = new File(THREADS_ROOT_FILE_PATH);
        File threadsActualFiles = new File(THREADS_ACTUAL_FILE_PATH);
        File[] rootMatrices = threadsRootFiles.listFiles();
        File[] actualMatrices = threadsActualFiles.listFiles();
        Object[][] data = new Object[actualMatrices.length][3];
        for (int i = 0; i < actualMatrices.length; i++) {
            for (int j = 0, counter = 0; j < rootMatrices.length; j++) {
                if (actualMatrices[i].getName().substring(12).equals(rootMatrices[j].getName().substring(11))) {
                    data[i][counter++] = ThreadsUtil.readMatrixFromFile(rootMatrices[j].getPath());
                }
                if (actualMatrices[i].getName().substring(12).equals(rootMatrices[j].getName().substring(12))) {
                    data[i][counter++] = ThreadsUtil.readMatrixFromFile(rootMatrices[j].getPath());
                }
            }
            data[i][2] = ThreadsUtil.readMatrixFromFile(actualMatrices[i].getPath());
        }
        return Arrays.asList(data);
    }

    @Test
    public void multiplyMatrixInSingle() throws Exception {
        Assert.assertArrayEquals(threadTask.multiplyMatrix(firstMatrix, secondMatrix), multipliedMatrix);
    }

    @Test
    public void multiplyMatrixInMultiThreading() throws Exception {
        Assert.assertArrayEquals(threadTask.multiplyMatrixInMultithreading(firstMatrix, secondMatrix), multipliedMatrix);
    }

    @Test(expected = NullPointerException.class)
    public void matrixIsNull() throws Exception {
        threadTask.multiplyMatrix(null, null);
    }
}
