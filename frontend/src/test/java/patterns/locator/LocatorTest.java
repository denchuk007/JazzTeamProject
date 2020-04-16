package patterns.locator;

import org.junit.Assert;
import org.junit.Test;

public class LocatorTest {

    String serviceName = "EmailService";

    @Test
    public void serviceInCache() {
        ServiceLocator.getService(serviceName);
        boolean isServiceInCache = ServiceLocator.verifyServiceInCache(serviceName);
        Assert.assertTrue(isServiceInCache);
    }

    @Test
    public void serviceNotInCache() {
        boolean isServiceInCache = ServiceLocator.verifyServiceInCache(serviceName);
        Assert.assertFalse(isServiceInCache);
    }
}
