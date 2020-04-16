package patterns.factory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactoryTest {

    private static ProductSeller phoneSeller;

    @BeforeClass
    public static void initialize() {
        phoneSeller = new PhoneSeller();
    }

    @Test
    public void factoryPattern() {
        Product phoneFromPhoneSeller = phoneSeller.sellProduct();
        Phone phone = new Phone();
        Assert.assertEquals(phone.getClass(), phoneFromPhoneSeller.getClass());
    }
}
