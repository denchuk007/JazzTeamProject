package collections;

import collections.util.CollectionsUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TagTaskTest {

    private static TagTask tagTask;
    private static String tagsString;
    private static final String COLLECTIONS_FILE_PATH = "src/main/resources/collections/";
    private static final String INSERTED_TAGS_FILE_PATH =  COLLECTIONS_FILE_PATH + "insertedTags";
    private static final String CORRECT_INSERTED_TAGS_FILE_PATH = COLLECTIONS_FILE_PATH + "correctInsertedTags";
    private static final String NOT_INSERTED_TAGS_FILE_PATH = COLLECTIONS_FILE_PATH + "notInsertedTags";
    private static final String CORRECT_NOT_INSERTED_TAGS_FILE_PATH = COLLECTIONS_FILE_PATH + "correctNotInsertedTags";
    private static final String TAGS_WITH_ANOTHER_TAG_FILE_PATH = COLLECTIONS_FILE_PATH + "tagsWithAnotherTag";
    private static final String TAGS_WITHOUT_ANOTHER_TAG_FILE_PATH = COLLECTIONS_FILE_PATH + "tagsWithoutAnotherTag";
    private static final String EMPTY_FILE = COLLECTIONS_FILE_PATH + "empty";
    private static final String TAG_NAME = "tag";

    @BeforeClass
    public static void initializeBeforeClass() {
        tagTask = new TagTask();
    }

    @Test
    public void findInsertedTags() {
        tagsString = CollectionsUtil.readFromFile(INSERTED_TAGS_FILE_PATH);
        String inputTags = tagTask.findTag(TAG_NAME, tagsString);
        String correctTags =  CollectionsUtil.readFromFile(CORRECT_INSERTED_TAGS_FILE_PATH);
        Assert.assertEquals(inputTags, correctTags);
    }

    @Test
    public void findNotInsertedTags() {
        tagsString = CollectionsUtil.readFromFile(NOT_INSERTED_TAGS_FILE_PATH);
        String inputTags = tagTask.findTag(TAG_NAME, tagsString);
        String correctTags =  CollectionsUtil.readFromFile(CORRECT_NOT_INSERTED_TAGS_FILE_PATH);
        Assert.assertEquals(inputTags, correctTags);
    }

    @Test
    public void findCorrectTags() {
        tagsString = CollectionsUtil.readFromFile(TAGS_WITH_ANOTHER_TAG_FILE_PATH);
        String inputTags = tagTask.findTag(TAG_NAME, tagsString);
        String correctTags =  CollectionsUtil.readFromFile(TAGS_WITHOUT_ANOTHER_TAG_FILE_PATH);
        Assert.assertEquals(inputTags, correctTags);
    }

    @Test(expected = NullPointerException.class)
    public void findTagsInEmptyFile() {
        tagsString = CollectionsUtil.readFromFile(EMPTY_FILE);
        tagTask.findTag(TAG_NAME, tagsString);
    }


    @Test(expected = NullPointerException.class)
    public void findEmptyTag() {
        tagsString = CollectionsUtil.readFromFile(INSERTED_TAGS_FILE_PATH);
        tagTask.findTag("", tagsString);
    }
}