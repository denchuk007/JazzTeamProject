package patterns.facade;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FacadeTest {

    private static ShapeMaker shapeMaker;

    @BeforeClass
    public static void initialize() {
        shapeMaker = new ShapeMaker();
    }

    @Test
    public void drawCircle() {
        Assert.assertEquals(shapeMaker.drawCircle(), "Circle");
    }

    @Test
    public void drawRectangle() {
        Assert.assertEquals(shapeMaker.drawRectangle(), "Rectangle");
    }

    @Test
    public void drawSquare() {
        Assert.assertEquals(shapeMaker.drawSquare(), "Square");
    }
}
