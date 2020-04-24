package arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayCombineTaskTest {

    private static ArrayCombineTask arrayCombineAndSortTask;
    private static int[] inputArrayWithEvenCountOfElements;
    private static int[] inputArrayWithUnevenCountOfElements;
    private static int[] sortAndCombinedArrayWithEvenCountOfElements;
    private static int[] sortAndCombinedArrayWithUnevenCountOfElements;

    @BeforeClass
    public static void initialize() {
        arrayCombineAndSortTask = new ArrayCombineTask();
        inputArrayWithEvenCountOfElements = new int[]{23, 12, 2, 5, 124, 76, 35, 678, 1};
        inputArrayWithUnevenCountOfElements = new int[]{73, 1, 84, 34, 2, 96, 31, 4};
        sortAndCombinedArrayWithEvenCountOfElements = new int[]{1, 2, 5, 12, 23, 35, 76, 124, 678, 1, 2, 5, 12, 23, 35, 76, 124, 678};
        sortAndCombinedArrayWithUnevenCountOfElements = new int[]{1, 2, 5, 12, 23, 35, 76, 124, 678, 1, 2, 4, 31, 34, 73, 84, 96};
    }

    @Test
    public void sortAndCombineArraysWithEvenCountOfElements() {
        assertArrayEquals(arrayCombineAndSortTask.sortAndCombineArrays(inputArrayWithEvenCountOfElements,
                inputArrayWithEvenCountOfElements), sortAndCombinedArrayWithEvenCountOfElements);
    }

    @Test
    public void sortAndCombineArraysWithUnevenCountOfElements() {
        assertArrayEquals(arrayCombineAndSortTask.sortAndCombineArrays(inputArrayWithEvenCountOfElements,
                inputArrayWithUnevenCountOfElements), sortAndCombinedArrayWithUnevenCountOfElements);
    }

    @Test(expected = NullPointerException.class)
    public void sortAndCombineArraysWithNullPointerException() {
        arrayCombineAndSortTask.sortAndCombineArrays(null, null);
    }
}