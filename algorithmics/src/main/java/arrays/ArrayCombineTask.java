package arrays;

import arrays.util.ArrayUtil;

public class ArrayCombineTask {

    public int[] sortAndCombineArrays(int[] firstArray, int[] secondArray) {
        errorVerification(firstArray, secondArray);
        int[] sortedFirstArray = ArrayUtil.sortArray(firstArray);
        int[] sortedSecondArray = ArrayUtil.sortArray(secondArray);
        return ArrayUtil.combineArrays(sortedFirstArray, sortedSecondArray);
    }

    private void errorVerification(int[] ...arrays) throws NullPointerException {
        for (int[] array : arrays) {
            if (array == null) {
                throw new NullPointerException();
            }
        }
    }
}
