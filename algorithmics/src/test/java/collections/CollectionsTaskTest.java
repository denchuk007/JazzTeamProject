package collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class CollectionsTaskTest {

    private static CollectionsTask collections;
    private static final int ELEMENTS_COUNT = 30000;
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
        long arrayListFillTime = collections.getFillTimeToStart(arrayList, ELEMENTS_COUNT);
        long linkedListFillTime = collections.getFillTimeToStart(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListFillTime > linkedListFillTime);
    }

    @Test
    public void fillListRandomToMiddle() {
        long arrayListFillTime = collections.getFillTimeToMiddle(arrayList, ELEMENTS_COUNT);
        long linkedListFillTime = collections.getFillTimeToMiddle(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListFillTime < linkedListFillTime);
    }

    @Test
    public void fillListRandomToEnd() {
        long arrayListFillTime = collections.getFillTimeToEnd(arrayList, ELEMENTS_COUNT);
        long linkedListFillTime = collections.getFillTimeToEnd(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListFillTime < linkedListFillTime);
    }

    @Test
    public void deleteListElementsFromStart() {
        long arrayListDeleteTime = collections.getDeleteTimeFromStart(arrayList, ELEMENTS_COUNT);
        long linkedListDeleteTime = collections.getDeleteTimeFromStart(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListDeleteTime > linkedListDeleteTime);
    }

    @Test
    public void deleteListElementsFromMiddle() {
        long arrayListDeleteTime = collections.getDeleteTimeFromMiddle(arrayList, ELEMENTS_COUNT);
        long linkedListDeleteTime = collections.getDeleteTimeFromMiddle(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListDeleteTime < linkedListDeleteTime);
    }

    @Test
    public void deleteListElementsFromEnd() {
        long arrayListDeleteTime = collections.getDeleteTimeFromEnd(arrayList, ELEMENTS_COUNT);
        long linkedListDeleteTime = collections.getDeleteTimeFromEnd(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListDeleteTime <= linkedListDeleteTime);
    }

    @Test
    public void getListElementFromStart() {
        long arrayListGetElementTime = collections.getListElementFromStartTime(arrayList, ELEMENTS_COUNT);
        long linkedListGetElementTime = collections.getListElementFromStartTime(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void getListElementFromMiddle() {
        long arrayListGetElementTime = collections.getListElementFromMiddleTime(arrayList, ELEMENTS_COUNT);
        long linkedListGetElementTime = collections.getListElementFromMiddleTime(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void getListElementFromEnd() {
        long arrayListGetElementTime = collections.getListElementFromEndTime(arrayList, ELEMENTS_COUNT);
        long linkedListGetElementTime = collections.getListElementFromEndTime(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListGetElementTime < linkedListGetElementTime);
    }

    @Test
    public void setListElementToMiddle() {
        long arrayListSetElementTime = collections.getSetListElementToMiddleTime(arrayList, ELEMENTS_COUNT);
        long linkedListSetElementTime = collections.getSetListElementToMiddleTime(linkedList, ELEMENTS_COUNT);
        Assert.assertTrue(arrayListSetElementTime < linkedListSetElementTime);
    }
}