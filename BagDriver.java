import java.util.*;
import java.util.Scanner;

public class BagDriver
{
    public static void main(String[] args)
    {
        // Create two new bags.
        BagInterface<String> bag1 = new LinkedBag<>();
        BagInterface<String> bag2 = new LinkedBag<>();

        char bagType;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please tell us if you would like to use ");
        System.out.println("a (R)esizableArrayBag or a (L)inkedBag: ");
        bagType = keyboard.next().charAt(0);
        bagType = Character.toUpperCase(bagType);
        switch(bagType)
        {
            case 'R' :

                break;

            case 'L' :
                break;

            default :
        }

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
