import java.util.*;

public class ResizableArrayBag<T> implements BagInterface<T>{
    private T[] bag1;
    private static final int DEFAULT_CAPACITY = 25;
    private int numOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    // Constructor1 creates an empty bag with a default cap of 25
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    } //end constructor1

    // Constructor2 creates and initializes an empty bag
    public ResizableArrayBag(int capacity)
    {
        if (capacity <= MAX_CAPACITY) {
            numOfEntries = 0;
            // the case is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capacity];
            bag1 = tempBag;
            integrityOK = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag whose"
                    +  "capacity exceeds allowed maximum.");
    } //end constructor2

    public int getCurrentSize() //Return the number of entries in the bag
    {
        return numOfEntries;
    } //end getCurrentSize

    private void checkIntegrity() // Throws an exception if this object is not initialized
    {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    } // end checkIntegrity

    public boolean isEmpty() //Return true if the bag is empty, return false if it isn't
    {
        return numOfEntries == 0;
    } //end isEmpty

    public boolean isFull() //Return true if bag is full, return false if it isn't
    {
        if (numOfEntries == DEFAULT_CAPACITY)
        {
            return true;
        }
        return false;
    } //end isFull

    private void checkCapacity(int capacity)
    // Throws an exception if the client requests a capacity that is too large.
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose " +
                    "capacity exceeds allowed " +
                    "maximum of " + MAX_CAPACITY);
    } // end checkCapacity

    private void doubleCapacity()
    // Doubles the size of the array bag.
    // Precondition: checkIntegrity has been called.
    {
        int newCapacity = 2 * DEFAULT_CAPACITY;
        checkCapacity(newCapacity);
        bag1 = Arrays.copyOf(bag1, newCapacity);
    } // end doubleCapacity

    public boolean add(T newEntry) {
        checkIntegrity();
        boolean result = true;
        if (isFull()) {
            doubleCapacity();
        } //end if statement
        bag1[numOfEntries] = newEntry;
        numOfEntries++;

        return result;
    } //end add

    private int getIndexOf(T anEntry)
    // Locates a given entry within the array bag.
    // Returns the index of the entry, if located, or -1 otherwise.
    // Precondition: checkIntegrity has been called.
    {
        int where = -1;
        boolean found = false;
        int i = 0;
        while (!found && (i < numOfEntries))
        {
            if (anEntry.equals(bag1[i]))
            {
                found = true;
                where = i;
            } // end if
            i++;
        } // end while
        // Assertion: If where > -1, anEntry is in the array bag, and it equals bag[where]; otherwise, anEntry is not in the array
        return where;
    } //end getIndexOf

    private T removeEntry(int givenIndex)
    // Removes and returns the entry at a given index within the array bag.
    // If no such entry exists, returns null.
    // Preconditions: 0 <= givenIndex < numberOfEntries; checkIntegrity has been called.
    {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag1[givenIndex];                   // Entry to remove
            bag1[givenIndex] = bag1[numOfEntries - 1]; // Replace entry with last entry
            bag1[numOfEntries - 1] = null;            // Remove last entry
            numOfEntries--;
        } // end if

        return result;
    } // end removeEntry

    public T remove() //Removes one unspecified entry from this bag, if possible.
    {
        checkIntegrity();
        T result = removeEntry(numOfEntries - 1);
        return result;
    } // end remove

    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    } // end remove

    public void clear() //Removes all entries from the bag
    {
        while (!isEmpty())
            remove();
    } // end clear

    public int getFrequencyOf(T anEntry) //Counts the number of times a given entry appears in this bag.
    {
        checkIntegrity();
        int counter = 0;

        for (int i = 0; i < numOfEntries; i++)
        {
            if (anEntry.equals(bag1[i]))
            {
                counter++;
            } // end if
        } // end for
        return counter;
    } // end getFrequencyOf

    public boolean contains(T anEntry) //Tests whether the bag contains a given entry
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1; // or >= 0
    } // end contains

    public T[] toArray() {
        //the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numOfEntries];
        for (int i = 0; i < numOfEntries; i++)
        {
            result[i] = bag1[i];
        } //end for loop
        return result;
    } //end toArray




    @Override
    public BagInterface<T> union(BagInterface<T> UnionBag) {
        return null;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> InterBag) {
        return null;
    }

    @Override
    public BagInterface<T> difference(BagInterface<T> DiffBag) {
        return null;
    }
}
