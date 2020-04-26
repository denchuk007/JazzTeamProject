package files;

import java.util.LinkedList;
import java.util.List;

public class FileTask {

    public List<String> restoreOriginalFile(List<String> originalLines, List<String> editedLines)
            throws SameTwiceInARowException, SameNotExpectedException {
        listNotNullVerification(originalLines, editedLines);
        if (listAreEmptyAndEqual(originalLines, editedLines)) {
            List<String> combinedLines = new LinkedList<>();
            combinedLines.add(Status.SAME.name());
            return combinedLines;
        }
        List<String> combinedLines = combineLines((LinkedList<String>) originalLines, (LinkedList<String>) editedLines);
        sameTwiceInARowVerification(combinedLines);
        sameNotExpectedVerification(combinedLines);
        return combinedLines;
    }

    private enum Status {
        SAME,
        ADDED,
        REMOVED
    }

    private List<String> combineLines(LinkedList<String> originalLines, LinkedList<String> editedLines) {
        List<String> combinedLines = new LinkedList<>();
        while (!originalLines.isEmpty() || !editedLines.isEmpty()) {
            if (editedLines.isEmpty()) {
                combinedLines.add(fillCorrectRow(originalLines.getFirst(), Status.REMOVED));
                return combinedLines;
            } else if (originalLines.isEmpty()) {
                combinedLines.add(fillCorrectRow(editedLines.getFirst(), Status.ADDED));
                return combinedLines;
            } else {
                String currentRow = getCorrectRow(originalLines, editedLines);
                combinedLines.add(currentRow);
            }
        }
        return combinedLines;
    }

    private String getCorrectRow(LinkedList<String> originalLines, LinkedList<String> editedLines) {
        if (originalLines.getFirst().equals(editedLines.getFirst())) {
            String correctRow = fillCorrectRow(originalLines.getFirst(), Status.SAME);
            originalLines.removeFirst();
            editedLines.removeFirst();
            return correctRow;
        }
        if (originalLines.getFirst().equals(editedLines.get(1))) {
            String correctRow = fillCorrectRow(editedLines.getFirst(), Status.ADDED);
            editedLines.removeFirst();
            return correctRow;
        } else {
            String correctRow = fillCorrectRow(originalLines.getFirst(), Status.REMOVED);
            originalLines.removeFirst();
            return correctRow;
        }
    }

    private String fillCorrectRow(String row, Status status) {
        String stringFormat = "%s %s";
        switch (status) {
            case SAME:
                return String.format(stringFormat, Status.SAME, row);
            case ADDED:
                return String.format(stringFormat, Status.ADDED, row);
            case REMOVED:
                return String.format(stringFormat, Status.REMOVED, row);

            default:
                return null;
        }
    }

    private boolean listAreEmptyAndEqual(List<String> firstLines, List<String> secondLines) {
        return firstLines.isEmpty() && secondLines.isEmpty();
    }

    @SafeVarargs
    private final void listNotNullVerification(List<String>... lists) {
        for (List<String> list : lists) {
            if (list == null) {
                throw new NullPointerException("Expected list is null");
            }
        }
    }

    private void sameTwiceInARowVerification(List<String> combinedLines) throws SameTwiceInARowException {
        for (int i = 0; i < combinedLines.size() - 1; i++) {
            if (combinedLines.get(i).startsWith(Status.SAME.name()) &&
                    combinedLines.get(i + 1).startsWith(Status.SAME.name())) {
                throw new SameTwiceInARowException("Same expected twice in a row");
            }
        }
    }

    private void sameNotExpectedVerification(List<String> combinedLines) throws SameNotExpectedException {
        for (int i = 0; i < combinedLines.size() - 1; i++) {
            if (!combinedLines.get(i).startsWith(Status.SAME.name()) &&
                    !combinedLines.get(i + 1).startsWith(Status.SAME.name())) {
                throw new SameNotExpectedException("Same not expected after ADDED or REMOVED");
            }
        }
    }
}
