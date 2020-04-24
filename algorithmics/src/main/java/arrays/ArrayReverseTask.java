package arrays;

import arrays.util.ArrayUtil;

public class ArrayReverseTask {

    public int[] reverseArray(int[] array) {
        errorVerification(array);
        return reverse(array);
    }

    private int[] reverse(int[] originalArray) {
        int[] resultArray = originalArray.clone();
        for (int index = 0, lastIndex = resultArray.length - 1; index < resultArray.length / 2; index++, lastIndex--) {
            resultArray = ArrayUtil.swap(resultArray, index, lastIndex);
        }
        return resultArray;
    }

    private void errorVerification(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
    }
}
