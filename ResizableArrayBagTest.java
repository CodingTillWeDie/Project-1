import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizableArrayBagTest {
    BagInterface <String> bag1 = new ResizableArrayBag <>();
    @Test
    void union() {

    }

    @Test
    void intersection() {
    }

    @Test
    void difference() {
    }

    @Test
    void getCurrentSize() {

    }

    @Test
    void isEmpty() {
        if(bag1.isEmpty()){
            System.out.println("bag is empty");
        }
    }

    @Test
    void isFull() {
        int DCap = 25;
        for(int i = 0; i < DCap; i++){
            bag1.add("A");
        }
        if(bag1.isFull()){
            System.out.println("bag is full");
        }
    }

    @Test
    void add() {
        int DCap = 25;
        int numberOfEntries = 0;
        for(int i = 0; i < DCap; i++){
            bag1.add("A");
            numberOfEntries++;
        }

        if(bag1.isFull()){
            System.out.println("Number of Entries: " +  numberOfEntries);
            System.out.println("adding works");
        }
    }

    @Test
    void remove() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void clear() {
    }

    @Test
    void getFrequencyOf() {
    }

    @Test
    void contains() {
    }

    @Test
    void toArray() {
    }
}
