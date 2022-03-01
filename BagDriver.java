import java.util.*;
import java.util.Scanner;

public class BagDriver
{
    public static void main(String[] args) throws NullPointerException
    {
        int choice1;
        int counter = 10000;
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        BagInterface<String> bag4 = new LinkedBag<>();
        Scanner keyboard = new Scanner(System.in);

        // prompt the user to enter his or her choice.
        System.out.println("Enter 1 for ResizableArrayBag or 2 for LinkedBag: ");
        choice1 = keyboard.nextInt();
        // clear the buffer.
        keyboard.nextLine();

        for (int i = 0; i < counter; i++)
        {
            // allow the user to perform union, intersection, and
            // difference methods on two ResizableArrayBags.
            if (choice1 == 1)
            {
                int choice2;

                // prompt the user to choose a test case that demonstrates the
                // execution of the union, intersection, and difference methods.
                System.out.println("\nPlease enter a number for your desired test case: ");
                System.out.println("(1) Test Case #1: Two Different Bags");
                System.out.println("(2) Test Case #2: Two of the Same Bags #1");
                System.out.println("(3) Test Case #3: Two of the Same Bags #2");
                System.out.println("(4) Test Case #4: Two Distinct Bags");
                System.out.println("(5) Test Case #5: Two Empty Bags");
                System.out.println("(6) Test Case #6: Null Bags");
                System.out.println("(7) Exit the Program");
                choice2 = keyboard.nextInt();
                // clear the buffer.
                keyboard.nextLine();

                // check to see if the user wishes to perform the operations on two different bags.
                if (choice2 == 1)
                {
                    bag1.clear();
                    bag2.clear();
                    bag1.add("A");
                    bag1.add("B");
                    bag1.add("C");
                    bag2.add("B");
                    bag2.add("B");
                    bag2.add("D");
                    bag2.add("E");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag1.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag2.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                }
                // check to see if the user wishes to perform the operations on two of the same bags.
                else if (choice2 == 2)
                {
                    bag1.clear();
                    bag2.clear();
                    bag1.add("A");
                    bag1.add("A");
                    bag1.add("A");
                    bag1.add("A");
                    bag2.add("A");
                    bag2.add("A");
                    bag2.add("A");
                    bag2.add("A");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag1.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag2.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                }
                // check to see if the user wishes to perform more operations on two of the same bags.
                else if (choice2 == 3)
                {
                    bag1.clear();
                    bag2.clear();
                    bag1.add("A");
                    bag1.add("A");
                    bag1.add("B");
                    bag1.add("B");
                    bag2.add("A");
                    bag2.add("A");
                    bag2.add("B");
                    bag2.add("B");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag1.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag2.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                }
                // check to see if the user wishes to perform the operations on two distinct bags.
                else if (choice2 == 4)
                {
                    bag1.clear();
                    bag2.clear();
                    bag1.add("A");
                    bag1.add("B");
                    bag1.add("C");
                    bag1.add("D");
                    bag2.add("E");
                    bag2.add("F");
                    bag2.add("G");
                    bag2.add("H");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag1.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag2.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                }
                // check to see if the user wishes to perform the operations on two empty bags.
                else if (choice2 == 5)
                {
                    bag1.clear();
                    bag2.clear();

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag1.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag2.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                }
                else if (choice2 == 6)
                {
                    bag1.clear();
                    bag2.clear();


                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(null).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(null).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(null).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(null).toArray()));
                }
                // check to see if the user wishes to terminate the program.
                else if (choice2 == 7)
                {
                    bag1.clear();
                    bag2.clear();
                    System.out.println("Terminating the program... Goodbye!");
                    break;
                }
                // check to see if the user has entered an invalid response.
                else
                {
                    System.out.println("Invalid user response... Terminating the program.");
                    break;
                }
            }
            // allow the user to perform union, intersection, and
            // difference methods on two LinkedBags.
            else if (choice1 == 2)
            {
                int choice2;

                // prompt the user to choose a test case that demonstrates the
                // execution of the union, intersection, and difference methods.
                System.out.println("\nPlease enter a number for your desired test case: ");
                System.out.println("(1) Test Case #1: Two Different Bags");
                System.out.println("(2) Test Case #2: Two of the Same Bags #1");
                System.out.println("(3) Test Case #3: Two of the Same Bags #2");
                System.out.println("(4) Test Case #4: Two Distinct Bags");
                System.out.println("(5) Test Case #5: Two Empty Bags");
                System.out.println("(6) Test Case #6: Null Bags");
                System.out.println("(7) Exit the Program");
                choice2 = keyboard.nextInt();
                // clear the buffer.
                keyboard.nextLine();

                // check to see if the user wishes to perform the operations on two different bags.
                if (choice2 == 1)
                {
                    bag3.clear();
                    bag4.clear();
                    bag3.add("A");
                    bag3.add("B");
                    bag3.add("C");
                    bag4.add("B");
                    bag4.add("B");
                    bag4.add("D");
                    bag4.add("E");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag3.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag4.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
                }
                // check to see if the user wishes to perform the operations on two of the same bags.
                else if (choice2 == 2)
                {
                    bag3.clear();
                    bag4.clear();
                    bag3.add("A");
                    bag3.add("A");
                    bag3.add("A");
                    bag3.add("A");
                    bag4.add("A");
                    bag4.add("A");
                    bag4.add("A");
                    bag4.add("A");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag3.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag4.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
                }
                // check to see if the user wishes to perform more operations on two of the same bags.
                else if (choice2 == 3)
                {
                    bag3.clear();
                    bag4.clear();
                    bag3.add("A");
                    bag3.add("A");
                    bag3.add("B");
                    bag3.add("B");
                    bag4.add("A");
                    bag4.add("A");
                    bag4.add("B");
                    bag4.add("B");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag3.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag4.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
                }
                // check to see if the user wishes to perform the operations on two distinct bags.
                else if (choice2 == 4)
                {
                    bag3.clear();
                    bag4.clear();
                    bag3.add("A");
                    bag3.add("B");
                    bag3.add("C");
                    bag3.add("D");
                    bag4.add("E");
                    bag4.add("F");
                    bag4.add("G");
                    bag4.add("H");

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag3.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag4.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
                }
                // check to see if the user wishes to perform the operations on two empty bags.
                else if (choice2 == 5)
                {
                    bag3.clear();
                    bag4.clear();

                    System.out.println("Displaying the contents...");
                    System.out.println("Bag #1: " + Arrays.toString(bag3.toArray()));
                    System.out.println("Bag #2: " + Arrays.toString(bag4.toArray()));
                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
                }
                else if (choice2 == 6)
                {
                    bag3.clear();
                    bag4.clear();

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(null).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(null).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(null).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(null).toArray()));
                }
                // check to see if the user wishes to terminate the program.
                else if (choice2 == 7)
                {
                    bag3.clear();
                    bag4.clear();
                    System.out.println("Terminating the program... Goodbye!");
                    break;
                }
                // check to see if the user has entered an invalid response.
                else
                {
                    System.out.println("Invalid user response... Terminating the program.");
                    break;
                }
            }
            // check to see if the user has entered an invalid response.
            else
            {
                System.out.println("Invalid user response... Terminating the program.");
                break;
            }
        } // end of for loop.
    } // end of main.
} // end of "BagDriver"
