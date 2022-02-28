import java.util.*;
import java.util.Scanner;

public class BagDriver {
    public static void main(String[] args) throws NullPointerException {

        int cap = 25;
        int choice1;
        int counter = 10000;
        BagInterface<String> bag1 = new ResizableArrayBag<>();
        BagInterface<String> bag2 = new ResizableArrayBag<>();
        BagInterface<String> bag3 = new LinkedBag<>();
        BagInterface<String> bag4 = new LinkedBag<>();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter 1 for ResizableArrayBag or 2 for LinkedBag: ");
        choice1 = keyboard.nextInt();
        keyboard.nextLine();
        for(int i = 0; i < counter; i++) {
            if (choice1 == 1) {
                int choice2;
                System.out.println("Please enter the number of the desired test case: ");
                System.out.println("1: Test Case 1 ");
                System.out.println("2: Test Case 2 ");
                System.out.println("3: Test Case 3 ");
                System.out.println("4: Test Case 4 ");
                System.out.println("5: Test Case 5 ");
                System.out.println("6: Exit Program ");
                choice2 = keyboard.nextInt();
                keyboard.nextLine();

                if (choice2 == 1) {
                    bag1.clear();
                    bag2.clear();
                    bag1.add("A");
                    bag1.add("B");
                    bag1.add("C");
                    bag2.add("B");
                    bag2.add("B");
                    bag2.add("D");
                    bag2.add("E");

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));

                } else if (choice2 == 2) {
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

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));

                } else if (choice2 == 3) {
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

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));

                } else if (choice2 == 4) {
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

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                } else if (choice2 == 5) {
                    bag1.clear();
                    bag2.clear();

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag1.union(bag2).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag1.intersection(bag2).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag1.difference(bag2).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag2.difference(bag1).toArray()));
                }
                else if (choice2 == 6) {
                    bag1.clear();
                    bag2.clear();

                    System.out.println("GoodBye");
                    break;
                }
            }
            else if (choice1 == 2) {
                int choice2;
                System.out.println("Please enter the number of the desired test case: ");
                System.out.println("1: Test Case 1 ");
                System.out.println("2: Test Case 2 ");
                System.out.println("3: Test Case 3 ");
                System.out.println("4: Test Case 4 ");
                System.out.println("5: Test Case 5 ");
                System.out.println("6: Exit Program ");
                choice2 = keyboard.nextInt();
                keyboard.nextLine();

                if (choice2 == 1) {
                    bag3.clear();
                    bag4.clear();
                    bag3.add("A");
                    bag3.add("B");
                    bag3.add("C");
                    bag4.add("B");
                    bag4.add("B");
                    bag4.add("D");
                    bag4.add("E");

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));

                } else if (choice2 == 2) {
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

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));

                } else if (choice2 == 3) {
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

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));

                } else if (choice2 == 4) {
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

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
                } else if (choice2 == 5) {
                    bag3.clear();
                    bag4.clear();

                    System.out.print("Result of Union: ");
                    System.out.println(Arrays.toString(bag3.union(bag4).toArray()));
                    System.out.print("Result of Intersection: ");
                    System.out.println(Arrays.toString(bag3.intersection(bag4).toArray()));
                    System.out.print("Result of Difference from the first bag to the second: ");
                    System.out.println(Arrays.toString(bag3.difference(bag4).toArray()));
                    System.out.print("Result of Difference from the second bag to the first: ");
                    System.out.println(Arrays.toString(bag4.difference(bag3).toArray()));
                }
                else if (choice2 == 6) {
                    bag3.clear();
                    bag4.clear();

                    System.out.println("Goodbye");
                    break;
                }


            }
        }
    }
}
