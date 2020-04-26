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
        long arrayListFillTime = collections.getFillTimeToStart(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListFillTime = collections.getFillTimeToStart(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListFillTime > linkedListFillTime);
    }

    @Test
    public void fillListRandomToMiddle() {
        long arrayListFillTime = collections.getFillTimeToMiddle(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListFillTime = collections.getFillTimeToMiddle(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListFillTime < linkedListFillTime);
    }

    @Test
    public void fillListRandomToEnd() {
        long arrayListFillTime = collections.getFillTimeToEnd(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListFillTime = collections.getFillTimeToEnd(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListFillTime < linkedListFillTime);
    }

    @Test
    public void deleteListElementsFromStart() {
        long arrayListDeleteTime = collections.getDeleteTimeFromStart(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListDeleteTime = collections.getDeleteTimeFromStart(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListDeleteTime > linkedListDeleteTime);
    }

    @Test
    public void deleteListElementsFromMiddle() {
        long arrayListDeleteTime = collections.getDeleteTimeFromMiddle(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListDeleteTime = collections.getDeleteTimeFromMiddle(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListDeleteTime < linkedListDeleteTime);
    }

    @Test
    public void deleteListElementsFromEnd() {
        long arrayListDeleteTime = collections.getDeleteTimeFromEnd(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListDeleteTime = collections.getDeleteTimeFromEnd(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListDeleteTime <= linkedListDeleteTime);
    }

    @Test
    public void getListElementFromStart() {
        long arrayListGetElementTime = collections.getListElementFromStartTime(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListGetElementTime = collections.getListElementFromStartTime(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void getListElementFromMiddle() {
        long arrayListGetElementTime = collections.getListElementFromMiddleTime(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListGetElementTime = collections.getListElementFromMiddleTime(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void getListElementFromEnd() {
        long arrayListGetElementTime = collections.getListElementFromEndTime(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListGetElementTime = collections.getListElementFromEndTime(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void setListElementToMiddle() {
        long arrayListSetElementTime = collections.getSetListElementToMiddleTime(arrayList, AMOUNT_OF_ELEMENTS);
        long linkedListSetElementTime = collections.getSetListElementToMiddleTime(linkedList, AMOUNT_OF_ELEMENTS);
        Assert.assertTrue(arrayListSetElementTime < linkedListSetElementTime);
    }
}