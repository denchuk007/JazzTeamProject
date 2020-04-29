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

    public long getFillTimeToTheBeginning(List<Integer> inputList, int amountOfElements) {
        long startTime = System.currentTimeMillis();
        fillListRandomToTheBeginning(inputList, amountOfElements);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getFillTimeInTheMiddle(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        fillListRandomInTheMiddle(inputList, amountOfElements);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getFillTimeToTheEnd(List<Integer> inputList, int amountOfElements) {
        long startTime = System.currentTimeMillis();
        fillListRandomToTheEnd(inputList, amountOfElements);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getDeleteTimeFromTheBeginning(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        deleteListElementFromTheBeginning(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getDeleteTimeFromTheMiddle(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        deleteListElementFromTheMiddle(inputList, amountOfElements);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getDeleteTimeFromTheEnd(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        deleteListElementFromTheEnd(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getListElementFromTheBeginningTime(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        getListElementFromTheBeginning(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getListElementFromTheMiddleTime(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        getListElementFromTheMiddle(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getListElementFromTheEndTime(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        getListElementFromTheEnd(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getTimeToSetListElementsInTheMiddle(List<Integer> inputList, int amountOfElements) {
        CollectionsUtil.fillListRandom(inputList, amountOfElements);
        long startTime = System.currentTimeMillis();
        setListElementInTheMiddle(inputList);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private void fillListRandomToTheBeginning(List<Integer> inputList, int amountOfElements) {
        if (inputList instanceof LinkedList) {
            for (int i = 0; i < amountOfElements; i++) {
                ((LinkedList<Integer>) inputList).addFirst(random.nextInt());
            }
        } else if (inputList instanceof ArrayList) {
            for (int i = 0; i < amountOfElements; i++) {
                inputList.add(0, random.nextInt());
            }
        }
    }

    private void fillListRandomInTheMiddle(List<Integer> inputList, int amountOfElements) {
        int middle = inputList.size() / 2;
        for (int i = middle; i < middle + amountOfElements / 10; i++) {
            inputList.add(i, random.nextInt());
        }
    }

    private void fillListRandomToTheEnd(List<Integer> inputList, int amountOfElements) {
        if (inputList instanceof LinkedList) {
            for (int i = 0; i < amountOfElements; i++) {
                ((LinkedList<Integer>) inputList).addLast(random.nextInt());
            }
        } else if (inputList instanceof ArrayList) {
            inputList.add(random.nextInt());
        }
    }

    private void deleteListElementFromTheBeginning(List<Integer> inputList) {
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

    private void deleteListElementFromTheMiddle(List<Integer> inputList, int amountOfElements) {
        int amountOfDeletedElements = 0;
        while(amountOfDeletedElements < amountOfElements) {
            int middleIndex = inputList.size() / 2;
            inputList.remove(middleIndex);
            amountOfDeletedElements++;
        }
    }

    private void deleteListElementFromTheEnd(List<Integer> inputList) {
        while (!inputList.isEmpty()) {
            inputList.remove(inputList.size() - 1);
        }
    }

    private void getListElementFromTheBeginning(List<Integer> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            inputList.get(i);
        }
    }

    private void getListElementFromTheMiddle(List<Integer> inputList) {
        int middleIndex = inputList.size() / 2;
        for (int i = middleIndex; i < middleIndex + middleIndex / 2; i++) {
            inputList.get(i);
        }
    }

    private void getListElementFromTheEnd(List<Integer> inputList) {
        for (int i = inputList.size() - 1; i >= 0; i--) {
            inputList.get(i);
        }
    }

    private void setListElementInTheMiddle(List<Integer> inputList) {
        int middle = inputList.size() / 2;
        for (int i = middle; i < middle + middle / 2; i++) {
            inputList.set(i, random.nextInt());
        }
    }
}
