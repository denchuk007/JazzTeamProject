package patterns.iterator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;

public class IteratorTest {

    private static LinkedList<String> expectedNames;
    private static LinkedList<String> actualNames;
    private static NameRepository namesRepository;

    @BeforeClass
    public static void initialize() {
        namesRepository = new NameRepository();
        expectedNames = new LinkedList<>();
        actualNames = new LinkedList<>();
        actualNames.addLast("Robert");
        actualNames.addLast("John");
        actualNames.addLast("Julie");
        actualNames.addLast("Lora");
        namesRepository.addName("Robert");
        namesRepository.addName("John");
        namesRepository.addName("Julie");
        namesRepository.addName("Lora");
    }

    @Test
    public void iteratorPattern() {
        for(Iterator iterator = namesRepository.getIterator(); iterator.hasNext();) {
            expectedNames.addLast((String)iterator.next());
        }
        Assert.assertEquals(expectedNames, actualNames);
    }
}
