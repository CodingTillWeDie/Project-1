import java.util.*;

public class LinkedBagTest 
{
  public static void main(String[] args) 
  {
    
    BagInterface < String > bag1 = new LinkedBag < >(); //create two new bags

    BagInterface < String > bag2 = new LinkedBag < >();

    //add test cases to bag 1
    bag1.add("A");

    bag1.add("B");

    bag1.add("C");

    bag1.add("D");
    
    //add test cases to bag2
    bag2.add("A");

    bag2.add("B");

    bag2.add("E");

    bag2.add("F");

    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));//prints the union of the two bags

    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));//Prints the intersection of the two bags

    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));//Prints the difference of bag1 and bag2

  }

}
