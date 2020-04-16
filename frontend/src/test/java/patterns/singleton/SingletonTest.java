package patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void singletonPattern() {
        Singleton singleton = Singleton.getInstance(1);
        Singleton anotherSingleton = Singleton.getInstance(2);
        Assert.assertEquals(singleton.getValue(), anotherSingleton.getValue());
    }
}
