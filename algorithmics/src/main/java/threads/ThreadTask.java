package threads;

import threads.util.ThreadsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTask {

    private final static Logger LOGGER = Logger.getLogger(ThreadsUtil.class.getName());

    public double[][] multiplyMatrix(double[][] firstMatrix, double[][] secondMatrix) throws Exception {
        errorVerification(firstMatrix, secondMatrix);
        double[][] resultMatrix = new double[secondMatrix.length][secondMatrix[0].length];
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                int multiplySum = 0;
                for (int k = 0; k < secondMatrix.length; k++) {
                    multiplySum += firstMatrix[i][k] * secondMatrix[k][j];
                }
                resultMatrix[i][j] = multiplySum;
            }
        }
        return resultMatrix;
    }

    public double[][] multiplyMatrixInMultithreading(double[][] firstMatrix, double[][] secondMatrix) throws Exception {
        errorVerification(firstMatrix, secondMatrix);
        double[][] resultMatrix = new double[secondMatrix.length][secondMatrix[0].length];
        List<RowAdderThread> threadList = new ArrayList<>();
        for (int i = 0; i < secondMatrix.length; i++) {
            RowAdderThread rowAdderThread = new RowAdderThread(resultMatrix, firstMatrix, secondMatrix, i);
            threadList.add(rowAdderThread);
            threadList.get(i).start();
        }
        threadsJoin(threadList);

        return resultMatrix;
    }

    private void threadsJoin(List<RowAdderThread> threadList) {
        try {
            for (RowAdderThread multiplierThread : threadList) {
                multiplierThread.join();
            }
        } catch (InterruptedException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public long getMatrixMultiplyTime(double[][] firstMatrix, double[][] secondMatrix) throws Exception {
        long startTime = System.currentTimeMillis();
        multiplyMatrix(firstMatrix, secondMatrix);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getMatrixMultiplyInMultithreadingTime(double[][] firstMatrix, double[][] secondMatrix)
            throws Exception {
        long startTime = System.currentTimeMillis();
        multiplyMatrixInMultithreading(firstMatrix, secondMatrix);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private boolean isMatricesAreComparable(double[][] firstMatrix, double[][] secondMatrix) {
        return firstMatrix[0].length == secondMatrix.length;
    }

    private void errorVerification(double[][] firstMatrix, double[][] secondMatrix) throws Exception {
        if (firstMatrix == null || secondMatrix == null) {
            throw new NullPointerException("One of matrix is null");
        } else if (!isMatricesAreComparable(firstMatrix, secondMatrix)) {
            throw new MatricesAreNotComparableException("Matrices are not comparable");
        }
    }
}
