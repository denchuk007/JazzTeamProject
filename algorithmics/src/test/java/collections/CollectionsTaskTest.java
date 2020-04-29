package collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionsTaskTest {

    private static CollectionsTask collections;
    private static final int AMOUNT_OF_ELEMENTS = 30000;
    private static ArrayList<Integer> arrayList;
    private static LinkedList<Integer> linkedList;

    @BeforeClass
    public static void initialize() {
        collections = new CollectionsTask();
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
    }

    @Test
    public void fillListRandomToStart() {
        long arrayListFillTime = collections.getFillTimeToTheBeginning(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListFillTime = collections.getFillTimeToTheBeginning(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListFillTime > linkedListFillTime);
    }

    @Test
    public void fillListRandomToMiddle() {
        long arrayListFillTime = collections.getFillTimeInTheMiddle(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListFillTime = collections.getFillTimeInTheMiddle(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListFillTime < linkedListFillTime);
    }

    @Test
    public void fillListRandomToEnd() {
        long arrayListFillTime = collections.getFillTimeToTheEnd(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListFillTime = collections.getFillTimeToTheEnd(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListFillTime < linkedListFillTime);
    }

    @Test
    public void deleteListElementsFromStart() {
        long arrayListDeleteTime = collections.getDeleteTimeFromTheBeginning(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListDeleteTime = collections.getDeleteTimeFromTheBeginning(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListDeleteTime > linkedListDeleteTime);
    }

    @Test
    public void deleteListElementsFromMiddle() {
        long arrayListDeleteTime = collections.getDeleteTimeFromTheMiddle(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListDeleteTime = collections.getDeleteTimeFromTheMiddle(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListDeleteTime < linkedListDeleteTime);
    }

    @Test
    public void deleteListElementsFromEnd() {
        long arrayListDeleteTime = collections.getDeleteTimeFromTheEnd(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListDeleteTime = collections.getDeleteTimeFromTheEnd(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListDeleteTime <= linkedListDeleteTime);
    }

    @Test
    public void getListElementFromStart() {
        long arrayListGetElementTime = collections.getListElementFromTheBeginningTime(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListGetElementTime = collections.getListElementFromTheBeginningTime(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void getListElementFromMiddle() {
        long arrayListGetElementTime = collections.getListElementFromTheMiddleTime(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListGetElementTime = collections.getListElementFromTheMiddleTime(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void getListElementFromEnd() {
        long arrayListGetElementTime = collections.getListElementFromTheEndTime(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListGetElementTime = collections.getListElementFromTheEndTime(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void setListElementToMiddle() {
        long arrayListSetElementTime = collections.getTimeToSetListElementsInTheMiddle(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListSetElementTime = collections.getTimeToSetListElementsInTheMiddle(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListSetElementTime < linkedListSetElementTime);
    }
}