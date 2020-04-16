package patterns.factory;

public class ComputerSeller extends ProductSeller {

    @Override
    public Product sellProduct() {
        return new Computer();
    }
}
