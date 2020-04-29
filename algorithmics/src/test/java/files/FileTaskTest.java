package files;

import files.util.FilesUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class FileTaskTest {

    private static FileTask fileTask;
    private static final String FILES_PATH = "src/main/resources/files/";
    private static final String DEFAULT_LINES_FILE_PATH = FILES_PATH + "originalLines";
    private static final String EDITED_LINES_FILE_PATH = FILES_PATH + "editedLines";
    private static final String EDITED_LINES_WITH_SAME_NOT_EXPECTED_FILE_PATH = FILES_PATH +
            "editedLinesWithSameNotExpected";
    private static final String COMBINED_LINES_FILE_PATH = FILES_PATH + "combinedLines";
    private static final String EMPTY_FILE_PATH = FILES_PATH + "empty";
    private static final String COMBINED_LINES_FROM_EMPTY_FILE_PATH = FILES_PATH + "combinedLinesFromEmptyFile";
    private static List<String> firstListWithEmptyLines;
    private static List<String> secondListWithEmptyLines;
    private static List<String> editedLinesWithSameNotExpected;
    private static List<String> combinedLinesFromEmptyFile;

    @BeforeClass
    public static void initialize() {
        fileTask = new FileTask();
        firstListWithEmptyLines = FilesUtil.readFromFile(EMPTY_FILE_PATH);
        secondListWithEmptyLines = FilesUtil.readFromFile(EMPTY_FILE_PATH);
        editedLinesWithSameNotExpected = FilesUtil.readFromFile(EDITED_LINES_WITH_SAME_NOT_EXPECTED_FILE_PATH);
        combinedLinesFromEmptyFile = FilesUtil.readFromFile(COMBINED_LINES_FROM_EMPTY_FILE_PATH);
    }

    @Test
    public void restoreOriginalFile() throws SameNotExpectedException, SameTwiceInARowException {
        List<String> combinedLines = FilesUtil.readFromFile(COMBINED_LINES_FILE_PATH);
        List<String> originalLines = FilesUtil.readFromFile(DEFAULT_LINES_FILE_PATH);
        List<String> editedLines = FilesUtil.readFromFile(EDITED_LINES_FILE_PATH);
        Assert.assertEquals(fileTask.restoreOriginalFile(originalLines, editedLines), combinedLines);
    }

    @Test
    public void restoreOriginalFileWithEmptyLines() throws SameNotExpectedException, SameTwiceInARowException {
        Assert.assertEquals(fileTask.restoreOriginalFile(firstListWithEmptyLines, secondListWithEmptyLines),
                combinedLinesFromEmptyFile);
    }

    @Test(expected = NullPointerException.class)
    public void restoreOriginalFileWithNullList() throws SameNotExpectedException, SameTwiceInARowException {
        fileTask.restoreOriginalFile(null, null);
    }

    @Test(expected = SameTwiceInARowException.class)
    public void restoreOriginalFileWithSameTwiceInARowException()
            throws SameNotExpectedException, SameTwiceInARowException {
        List<String> originalLines = FilesUtil.readFromFile(DEFAULT_LINES_FILE_PATH);
        fileTask.restoreOriginalFile(originalLines, originalLines);
    }

    @Test(expected = SameNotExpectedException.class)
    public void restoreOriginalFileWithSameNotExpectedException()
            throws SameNotExpectedException, SameTwiceInARowException {
        List<String> originalLines = FilesUtil.readFromFile(DEFAULT_LINES_FILE_PATH);
        fileTask.restoreOriginalFile(originalLines, editedLinesWithSameNotExpected);
    }
}