package arrays.util;

public class ArrayUtil {

    private ArrayUtil() {
    }

    public static int[] swap(int[] originalArray, int firstIndex, int secondIndex) {
        int[] resultArray = originalArray.clone();
        int temp = resultArray[firstIndex];
        resultArray[firstIndex] = resultArray[secondIndex];
        resultArray[secondIndex] = temp;
        return resultArray;
    }

    public static int[] sortArray(int[] originalArray) {
        int[] resultArray = originalArray.clone();
        for (int i = 0; i < resultArray.length - 1; i++) {
            for (int j = 0; j < resultArray.length - i - 1; j++) {
                if (resultArray[j] > resultArray[j + 1]) {
                    resultArray = ArrayUtil.swap(resultArray, j, j + 1);
                }
            }
        }
        return resultArray;
    }

    public static int[] combineArrays(int[] firstArray, int[] secondArray) {
        int[] resultArray = new int[firstArray.length + secondArray.length];
        System.arraycopy(firstArray, 0, resultArray, 0, firstArray.length);
        System.arraycopy(secondArray, 0, resultArray, firstArray.length, secondArray.length);
        return resultArray;
    }
}
