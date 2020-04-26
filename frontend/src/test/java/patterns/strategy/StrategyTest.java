package patterns.strategy;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StrategyTest {

    private static Context context;
    private static final int firstNumber = 10;
    private static final int secondNumber = 5;
    private static final int addResult = 15;
    private static final int substractResult = 5;
    private static final int multiplyResult = 50;


    @BeforeClass
    public static void initialize() {

    }

    @Test
    public void operationAdd() {
        context = new Context(new OperationAdd());
        Assert.assertEquals(addResult, context.executeStrategy(firstNumber, secondNumber));
    }

    @Test
    public void operationSubstract() {
        context = new Context(new OperationSubstract());
        Assert.assertEquals(substractResult, context.executeStrategy(firstNumber, secondNumber));
    }

    @Test
    public void operationMultiply() {
        context = new Context(new OperationMultiply());
        Assert.assertEquals(multiplyResult, context.executeStrategy(firstNumber, secondNumber));
    }
}

