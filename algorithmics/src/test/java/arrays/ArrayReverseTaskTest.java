package arrays;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayReverseTaskTest {

    private static ArrayReverseTask arrayReverseTask;
    private static int[] inputArrayWithEvenCountOfElements;
    private static int[] reversedArrayWithEvenCountOfElements;
    private static int[] inputArrayWithUnevenCountOfElements;
    private static int[] reversedArrayWithUnevenCountOfElements;
    private static int[] emptyArray;

    @BeforeClass
    public static void initialize() {
        arrayReverseTask = new ArrayReverseTask();
        inputArrayWithEvenCountOfElements = new int[]{23, 12, 2, 5, 124, 76, 35, 678, 1};
        reversedArrayWithEvenCountOfElements = new int[]{1, 678, 35, 76, 124, 5, 2, 12, 23};
        inputArrayWithUnevenCountOfElements = new int[]{73, 1, 84, 34, 2, 96, 31};
        reversedArrayWithUnevenCountOfElements = new int[]{31, 96, 2, 34, 84, 1, 73};
        emptyArray = new int[]{};
    }

    @Test
    public void reverseArrayWithEvenCountOfElements() {
        int[] expectedArray = arrayReverseTask.reverseArray(inputArrayWithEvenCountOfElements);
        Assert.assertArrayEquals(expectedArray, reversedArrayWithEvenCountOfElements);
    }

    @Test
    public void reverseArrayWithUnevenCountOfElements() {
        int[] expectedArray = arrayReverseTask.reverseArray(inputArrayWithUnevenCountOfElements);
        Assert.assertArrayEquals(expectedArray, reversedArrayWithUnevenCountOfElements);
    }

    @Test
    public void reverseArrayWithEmptyArray() {
        int[] expectedArray = arrayReverseTask.reverseArray(emptyArray);
        Assert.assertArrayEquals(expectedArray, emptyArray);
    }

    @Test(expected = NullPointerException.class)
    public void reverseArrayWithNullPointerException() {
        arrayReverseTask.reverseArray(null);
    }
}