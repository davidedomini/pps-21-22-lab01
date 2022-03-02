package lab01.tdd;

public class SelectStrategyFactoryImpl implements SelectStrategyFactory{
    @Override
    public SelectStrategy createEvenStrategy() {
        return (e)-> e % 2 == 0;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int element) {
        return (e)-> e % element == 0;
    }

    @Override
    public SelectStrategy createEqualsStrategy(int element) {
        return (e)-> e == element;
    }
}
