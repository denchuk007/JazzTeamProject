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
        Assert.assertEquals("Circle", shapeMaker.drawCircle());
    }

    @Test
    public void drawRectangle() {
        Assert.assertEquals("Rectangle", shapeMaker.drawRectangle());
    }

    @Test
    public void drawSquare() {
        Assert.assertEquals("Square", shapeMaker.drawSquare());
    }
}
