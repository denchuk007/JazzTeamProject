package threads;

public class RowAdderThread extends Thread {

    private double[][] firstMatrix;
    private double[][] secondMatrix;
    private double[][] resultMatrix;
    private int currentRow;

    public RowAdderThread(double[][] resultMatrix, double[][] firstMatrix, double[][] secondMatrix, int currentRow) {
        this.resultMatrix = resultMatrix;
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.currentRow = currentRow;
    }

    @Override
    public synchronized void run() {
        for (int j = 0; j < secondMatrix[0].length; ++j) {
            int multiplySum = 0;
            for (int k = 0; k < secondMatrix.length; ++k) {
                multiplySum += firstMatrix[currentRow][k] * secondMatrix[k][j];
            }
            resultMatrix[currentRow][j] = multiplySum;
        }
    }
}
