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
        assertEquals(oldSize + 1, list.size());
    }

    @Test
    void testNext(){
        list.add(1);
        list.add(2);
        Optional<Integer> v = list.next();
        if(v.isPresent()){
            assertEquals(1, v.get());
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

    @Test
    void testPrevious(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.next();
        list.next();
        Optional<Integer> v = list.previous();
        if(v.isPresent()){
            assertEquals(2, v.get());
        }else{
            fail("No value returned");
        }
    }

    @Test
    void testCircularPrevious(){
        list.add(1);
        list.add(2);
        list.add(3);
        Optional<Integer> v1 = list.previous();
        assertEquals(3, v1.get());
    }

    @Test
    void testReset(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.next();
        list.next();
        list.next();
        list.previous();
        list.reset();
        Optional<Integer> v1 = list.next();
        assertEquals(1, v1.get());
    }

}
