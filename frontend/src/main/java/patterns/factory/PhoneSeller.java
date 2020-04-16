package patterns.factory;

public class PhoneSeller extends ProductSeller {

    @Override
    public Product sellProduct() {
        return new Phone();
    }
}
