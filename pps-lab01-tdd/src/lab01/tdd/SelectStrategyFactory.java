package lab01.tdd;

public interface SelectStrategyFactory {

    /**
     * Provides the implementation of a SelectStrategy to get the next even element
     * @return the next even element
     */
    SelectStrategy createEvenStrategy();


    /**
     * Provides the implementation of a SelectStrategy to get the next element multiple of a given number
     * @param element the element used as divisor
     * @return the next element that complies with the strategy
     */
    SelectStrategy createMultipleOfStrategy(int element);

    /**
     * Provides the implementation of a SelectStrategy to get the next equal element of a given one
     * @param element the element used for comparison
     * @return the next element that complies with the strategy
     */
    SelectStrategy createEqualsStrategy(int element);
}
