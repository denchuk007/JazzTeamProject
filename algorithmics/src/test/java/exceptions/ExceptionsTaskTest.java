package exceptions;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExceptionsTaskTest {

    private static ExceptionsTask exceptionsTask;
    private static int[] inputArray;
    private static int[] incrementedArray;

    @BeforeClass
    public static void initialize() {
        exceptionsTask = new ExceptionsTask();
        inputArray = new int[] { 3, 5, 1, 3 };
        incrementedArray = new int[] { 4, 6, 2, 4 };
    }

    @Test
    public void incrementArrayElements() {
        Assert.assertArrayEquals(exceptionsTask.incrementArrayElements(inputArray), incrementedArray);
    }

    @Test(expected = DividingByZeroException.class)
    public void secondArgumentIsZero() throws DividingByZeroException {
        exceptionsTask.divide(1, 0);
    }

    @Test(expected = NullPointerException.class)
    public void errorWithoutTry() {
        exceptionsTask.incrementArrayElements(null);
    }

    @Test(expected = NullPointerException.class)
    public void errorInTry() {
        exceptionsTask.errorInTry(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void errorInCatch() {
        exceptionsTask.errorInCatch(inputArray);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void errorInTryWithTry() {
        exceptionsTask.errorInTryWithTry(inputArray);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void errorInFinally() {
        exceptionsTask.errorInFinally(inputArray);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void errorInFinallyWithTry() {
        exceptionsTask.errorIntFinallyWithTry(inputArray);
    }
}