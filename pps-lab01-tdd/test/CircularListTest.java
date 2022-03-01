import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

    @Test
    void testNext(){
        list.add(1);
        list.add(2);
        Optional<Integer> v = list.next();
        if(v.isPresent()){
            assertEquals(v.get(), 1);
        }else{
            fail("No value returned");
        }
    }

    @Test
    void testCircularNext(){
        list.add(1);
        list.add(2);
        Optional<Integer> v1 = list.next();
        Optional<Integer> v2 = list.next();
        Optional<Integer> v3 = list.next();
        assertEquals(v1.get(), v3.get());
    }

    

}
