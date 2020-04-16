package patterns.singleton;

public final class Singleton {
    private static Singleton instance;
    private Integer value;

    private Singleton(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static Singleton getInstance(Integer value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}