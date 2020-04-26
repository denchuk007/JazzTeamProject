package patterns.factory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FactoryTest {

    private static ProductSeller phoneSeller;
    private static ProductSeller computerSeller;

    @BeforeClass
    public static void initialize() {
        phoneSeller = new PhoneSeller();
        computerSeller = new ComputerSeller();
    }

    @Test
    public void createPhone() {
        Product phoneFromPhoneSeller = phoneSeller.sellProduct();
        Phone phone = new Phone();
        Assert.assertEquals(phone.getClass(), phoneFromPhoneSeller.getClass());
    }

    @Test
    public void createComputer() {
        Product computerFromComputerSeller = computerSeller.sellProduct();
        Computer computer = new Computer();
        Assert.assertEquals(computer.getClass(), computerFromComputerSeller.getClass());
    }
}
