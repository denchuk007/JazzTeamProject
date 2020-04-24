package patterns.builder;

import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {

    @Test
    public void personsAreSame() {
        Person firstPeron = new Person.Builder()
                .withName("Mike")
                .withSurname("Crawford")
                .withAge(20)
                .build();

        Person secondPerson = new Person.Builder()
                .withName("Mike")
                .build();

        Assert.assertEquals(firstPeron, secondPerson);
    }

    @Test
    public void personsAreNotSame() {
        Person firstPeron = new Person.Builder()
                .build();

        Person secondPerson = new Person.Builder()
                .withAge(32)
                .build();

        Assert.assertNotEquals(firstPeron, secondPerson);
    }
}
