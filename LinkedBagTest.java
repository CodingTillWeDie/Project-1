import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class LinkedBagTest 
{
    BagInterface <String> bag1 = new LinkedBag<>();
    BagInterface <String> bag2 = new LinkedBag<>();
    @Test
    void union() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        bag2.add("B");
        bag2.add("B");
        bag2.add("D");
        bag2.add("E");
        System.out.println(Arrays.toString(bag1.union(bag2).toArray())); //Prints the union of the two bags
    }

    @Test
    void intersection() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        bag2.add("B");
        bag2.add("B");
        bag2.add("D");
        bag2.add("E");
        System.out.println(Arrays.toString(bag1.intersection(bag2).toArray())); //Prints the intersection of the two bags
    }

    @Test
    void difference() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        bag2.add("B");
        bag2.add("B");
        bag2.add("D");
        bag2.add("E");
        System.out.println("Difference of bag1 to bag2");
        System.out.println(Arrays.toString(bag1.difference(bag2).toArray())); //Prints the difference of bag1 to bag2
        System.out.println("Difference of bag2 to bag1");
        System.out.println(Arrays.toString(bag2.difference(bag1).toArray())); //Prints the difference of bag2 to bag1
    }

    @Test
    void add() 
    {
        bag1.add("A");
        System.out.println(Arrays.toString(bag1.toArray())); //Prints [A]
    }

    @Test
    void remove() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.remove("A");
        System.out.println(Arrays.toString(bag1.toArray())); //Prints [B]
    }

    @Test
    void testRemove() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.remove();
        System.out.println(Arrays.toString(bag1.toArray())); //Prints [A]
    }

    @Test
    void isEmpty() 
    {
        if (bag1.isEmpty())
        {
            System.out.println("bag is empty");
        }
    }

    @Test
    void getCurrentSize() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        bag1.add("D");
        System.out.println(Arrays.toString(new int[]{bag1.getCurrentSize()})); //Prints [4]
    }

    @Test
    void clear() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        bag1.add("D");
        bag1.add("E");
        bag1.add("F");
        bag1.clear();
        System.out.println(Arrays.toString(bag1.toArray())); //Prints []
    }

    @Test
    void getFrequencyOf() 
    {
        bag1.add("A");
        bag1.add("A");
        bag1.add("B");
        bag1.add("B");
        System.out.println(Arrays.toString(new int[]{bag1.getFrequencyOf("A")})); //Prints [2]
    }

    @Test
    void contains() 
    {
        bag1.add("A");
        if (bag1.contains("A"))
        {
            System.out.println("Bag1 Contains Entry A");
        }
    }

    @Test
    void toArray() 
    {
        bag1.add("A");
        bag1.add("B");
        bag1.add("C");
        bag1.add("D");
        bag1.add("E");
        bag1.add("F");
        System.out.println(Arrays.toString(bag1.toArray())); //Prints [A, B, C, D, E, F]
    }
} // end of "LinkedBagTest"
