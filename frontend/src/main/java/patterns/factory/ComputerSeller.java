package patterns.factory;

public class ComputerSeller implements ProductSeller {

    @Override
    public Product sellProduct() {
        return new Computer();
    }
}
