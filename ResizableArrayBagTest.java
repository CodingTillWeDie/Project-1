import java.util.*;

public class ResizableArrayBagTest
{
    public static void main(String[] args)
    {
        BagInterface <String> bag1 = new ResizableArrayBag <>(); //Create two new bags
        BagInterface <String> bag2 = new ResizableArrayBag <>();

        bag1.add("A");
        bag1.add("B"); //Add the test cases to bag1
        bag1.add("C");
        
        bag2.add("B");
        bag2.add("B"); //Add the test cases to bag2
        bag2.add("D");
        bag2.add("E");

        System.out.println(Arrays.toString(bag1.union(bag2).toArray())); //Prints the union of the two bags
        System.out.println(Arrays.toString(bag1.intersection(bag2).toArray())); //Prints the intersection of the two bags
        System.out.println(Arrays.toString(bag1.difference(bag2).toArray())); //Prints the difference of bag1 and bag2
        System.out.println(Arrays.toString(bag2.difference(bag1).toArray())); //Prints the difference of bag2 and bag1

    }
}
