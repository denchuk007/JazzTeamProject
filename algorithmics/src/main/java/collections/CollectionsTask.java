package collections;

import collections.util.CollectionsUtil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTask {

    private final SecureRandom random;

    public CollectionsTask() {
        random = new SecureRandom();
    }

    public long getFillTimeToStart(List<Integer> inputList, int elementsCount) {
        long startTime = System.currentTimeMillis();
        fillListRandomToStart(inputList, elementsCount);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getFillTimeToMiddle(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        fillListRandomToMiddle(inputList, elementsCount);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getFillTimeToEnd(List<Integer> inputList, int elementsCount) {
        long startTime = System.currentTimeMillis();
        fillListRandomToEnd(inputList, elementsCount);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getDeleteTimeFromStart(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        deleteListElementFromStart(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getDeleteTimeFromMiddle(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        deleteListElementFromMiddle(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getDeleteTimeFromEnd(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        deleteListElementFromEnd(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getListElementFromStartTime(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        getListElementFromStart(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getListElementFromMiddleTime(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        getListElementFromMiddle(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getListElementFromEndTime(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        getListElementFromEnd(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getSetListElementToMiddleTime(List<Integer> inputList, int elementsCount) {
        CollectionsUtil.fillListRandom(inputList, elementsCount);
        long startTime = System.currentTimeMillis();
        setListElementToMiddle(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private void fillListRandomToStart(List<Integer> inputList, int elementsCount) {
        if (inputList instanceof LinkedList) {
            for (int i = 0; i < elementsCount; i++) {
                ((LinkedList<Integer>) inputList).addFirst(random.nextInt());
            }
        } else if (inputList instanceof ArrayList) {
            for (int i = 0; i < elementsCount; i++) {
                inputList.add(0, random.nextInt());
            }
        }
    }

    private void fillListRandomToMiddle(List<Integer> inputList, int elementsCount) {
        int middle = inputList.size() / 2;
        for (int i = middle; i < middle + elementsCount / 10; i++) {
            inputList.add(i, random.nextInt());
        }
    }

    private void fillListRandomToEnd(List<Integer> inputList, int elementsCount) {
        if (inputList instanceof LinkedList) {
            for (int i = 0; i < elementsCount; i++) {
                ((LinkedList<Integer>) inputList).addLast(random.nextInt());
            }
        } else if (inputList instanceof ArrayList) {
            inputList.add(random.nextInt());
        }
    }

    private void deleteListElementFromStart(List<Integer> inputList) {
        if (inputList instanceof LinkedList) {
            while (!inputList.isEmpty()) {
                ((LinkedList<Integer>) inputList).removeFirst();
            }
        } else if (inputList instanceof ArrayList) {
            while (!inputList.isEmpty()) {
                inputList.remove(0);
            }
        }
    }

    private void deleteListElementFromMiddle(List<Integer> inputList) {
        int middleIndex = inputList.size() / 2;
        for (int i = middleIndex; i < middleIndex + middleIndex / 2; i++) {
            inputList.remove(i);
        }
    }

    private void deleteListElementFromEnd(List<Integer> inputList) {
        while (!inputList.isEmpty()) {
            inputList.remove(inputList.size() - 1);
        }
    }

    private void getListElementFromStart(List<Integer> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            inputList.get(i);
        }
    }

    private void getListElementFromMiddle(List<Integer> inputList) {
        int middleIndex = inputList.size() / 2;
        for (int i = middleIndex; i < middleIndex + middleIndex / 2; i++) {
            inputList.get(i);
        }
    }

    private void getListElementFromEnd(List<Integer> inputList) {
        for (int i = inputList.size() - 1; i >= 0; i--) {
            inputList.get(i);
        }
    }

    private void setListElementToMiddle(List<Integer> inputList) {
        int middle = inputList.size() / 2;
        for (int i = middle; i < middle + middle / 2; i++) {
            inputList.set(i, random.nextInt());
        }
    }
}
