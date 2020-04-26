package patterns.locator;

public class ServiceLocator {

    private ServiceLocator() {

    }

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static boolean verifyServiceInCache(String name) {
        return cache.verifyServiceInCache(name);
    }

    public static Service getService(String name) {
        Service service = cache.getService(name);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service serviceOne = (Service) context.lookup(name);
        cache.addService(serviceOne);
        return serviceOne;
    }
}
