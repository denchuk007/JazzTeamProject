package patterns.factory;

public class PhoneSeller implements ProductSeller {

    @Override
    public Product sellProduct() {
        return new Phone();
    }
}
