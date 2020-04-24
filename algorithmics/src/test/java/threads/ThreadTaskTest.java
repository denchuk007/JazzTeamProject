package threads;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import threads.util.ThreadsUtil;

public class ThreadTaskTest {

    private static final String THREADS_FILE_PATH = "src/main/resources/threads/";
    private static final String FIRST_MATRIX_FILE_PATH = THREADS_FILE_PATH + "firstMatrix";
    private static final String SECOND_MATRIX_FILE_PATH = THREADS_FILE_PATH + "secondMatrix";
    private static final String MULTIPLIED_MATRIX_FILE_PATH = THREADS_FILE_PATH + "multipliedMatrix";
    private static ThreadTask threadTask;
    private static double[][] firstNotComparableMatrix;
    private static double[][] secondNotComparableMatrix;
    private static double[][] firstMatrix;
    private static double[][] secondMatrix;
    private static double[][] multipliedMatrix;

    @BeforeClass
    public static void initialize() {
        threadTask = new ThreadTask();
        firstNotComparableMatrix = new double[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        secondNotComparableMatrix = new double[][]{
                {2, 2, 2},
                {2, 2, 2}
        };
        firstMatrix = ThreadsUtil.readMatrixFromFile(FIRST_MATRIX_FILE_PATH);
        secondMatrix = ThreadsUtil.readMatrixFromFile(SECOND_MATRIX_FILE_PATH);
        multipliedMatrix = ThreadsUtil.readMatrixFromFile(MULTIPLIED_MATRIX_FILE_PATH);
    }

    @Test
    public void multiplyMatrixInSingle() throws Exception {
        Assert.assertArrayEquals(threadTask.multiplyMatrix(firstMatrix, secondMatrix), multipliedMatrix);
    }

    @Test
    public void multiplyMatrixInMultiThreading() throws Exception {
        Assert.assertArrayEquals(threadTask.multiplyMatrixInMultithreading(firstMatrix, secondMatrix), multipliedMatrix);
    }

    @Test
    public void multiplyMatrixInSingleAndMultithreading() throws Exception {
        long multiplyMatrixInSingleThreadingTime = threadTask.getMatrixMultiplyTime(firstMatrix, secondMatrix);
        long multiplyMatrixInMultiThreadingTime = threadTask
                .getMatrixMultiplyInMultithreadingTime(firstMatrix, secondMatrix);
        Assert.assertTrue(multiplyMatrixInSingleThreadingTime > multiplyMatrixInMultiThreadingTime);
    }

    @Test(expected = NullPointerException.class)
    public void matrixIsNull() throws Exception {
        threadTask.multiplyMatrix(null, null);
    }

    @Test(expected = MatricesAreNotComparableException.class)
    public void matrixIsNotComparable() throws Exception {
        threadTask.multiplyMatrix(firstNotComparableMatrix, secondNotComparableMatrix);
    }
}