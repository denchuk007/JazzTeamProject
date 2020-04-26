package patterns.iterator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;

public class IteratorTest {

    private static LinkedList<String> actualNames;
    private static LinkedList<String> expectedNames;
    private static NameRepository namesRepository;

    @BeforeClass
    public static void initialize() {
        namesRepository = new NameRepository();
        actualNames = new LinkedList<>();
        expectedNames = new LinkedList<>();
        expectedNames.addLast("Robert");
        expectedNames.addLast("John");
        expectedNames.addLast("Julie");
        expectedNames.addLast("Lora");
        namesRepository.addName("Robert");
        namesRepository.addName("John");
        namesRepository.addName("Julie");
        namesRepository.addName("Lora");
    }

    @Test
    public void iteratorPattern() {
        for (Iterator iterator = namesRepository.getIterator(); iterator.hasNext(); ) {
            actualNames.addLast((String) iterator.next());
        }
        Assert.assertEquals(expectedNames, actualNames);
    }
}
