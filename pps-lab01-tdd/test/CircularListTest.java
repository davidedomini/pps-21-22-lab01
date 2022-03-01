import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList list;

    @BeforeEach
    void beforeEach() {
        list = new SimpleCircularList();
    }

    @Test
    void testIsEmpty() {
       assertTrue(list.isEmpty());
    }

    @Test
    void testAddDoesNotThrowAnException() {
        assertDoesNotThrow(()-> list.add(1));
    }

    @Test
    void testAddInsertTheElement(){
        int oldSize = list.size();
        list.add(1);
        assertEquals(list.size(), oldSize + 1);
    }
}
