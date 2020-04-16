package exceptions;

public class ExceptionsTask {

    public double divide(double firstNumber, double secondNumber) throws DividingByZeroException {
        if (secondNumber == 0) {
            throw new DividingByZeroException("Dividing by zero");
        } else {
            return firstNumber / secondNumber;
        }
    }

    public int[] incrementArrayElements(int[] originalArray) {
        int[] resultArray = originalArray.clone();
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] += 1;
        }
        return resultArray;
    }

    public int[] errorInTry(int[] originalArray) {
        int[] resultArray = new int[100];
        try {
            resultArray = originalArray.clone();
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] += 1;
            }
            resultArray[resultArray.length + 1] = 1;
            return resultArray;
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return resultArray;
    }

    public int[] errorInCatch(int[] originalArray) {
        int[] resultArray = new int[100];
        try {
            resultArray = originalArray.clone();
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] += 1;
            }
            resultArray[resultArray.length + 1] = 1;
            return resultArray;
        } catch (NullPointerException ex) {
            resultArray[resultArray.length + 1] = 1;
        }
        return resultArray;
    }

    public int[] errorInTryWithTry(int[] originalArray) {
        int[] resultArray = new int[100];
        try {
            resultArray = originalArray.clone();
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] += 1;
            }
            resultArray[resultArray.length + 1] = 1;
            return resultArray;
        } catch (NullPointerException e) {
            try {
                resultArray[resultArray.length + 1] = 1;
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new ArrayIndexOutOfBoundsException("Array index is out of bounds");
            }
        }
        return resultArray;
    }

    public int[] errorInFinally(int[] originalArray) {
        int[] resultArray = new int[100];
        try {
            resultArray = originalArray.clone();
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] += 1;
            }
            return resultArray;
        } catch (NullPointerException ex) {
            throw new NullPointerException("Array is null");
        } finally {
            resultArray[resultArray.length + 1] = 1;
        }
    }

    public int[] errorIntFinallyWithTry(int[] originalArray) {
        int[] resultArray = new int[100];
        try {
            resultArray = originalArray.clone();
            for (int i = 0; i < resultArray.length; i++) {
                resultArray[i] += 1;
            }
            return resultArray;
        } catch (NullPointerException e) {
            throw new NullPointerException("Array is null");
        } finally {
            try {
                resultArray[resultArray.length + 1] = 1;
            } catch (ArrayIndexOutOfBoundsException ex) {
                throw new ArrayIndexOutOfBoundsException("Array index out of bounds");
            }
        }
    }
}
