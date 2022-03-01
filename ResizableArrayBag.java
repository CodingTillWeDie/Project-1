import java.util.*;

public class ResizableArrayBag<T> implements BagInterface<T>
{
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    /** Creates an empty bag with an initial capacity of 25. */
    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    } // end of default constructor

    /** Creates an empty bag with a given initial capacity.
     @param capacity : An integer value of desired capacity. */
    public ResizableArrayBag(int capacity)
    {
        if (capacity <= MAX_CAPACITY)
        {
            numberOfEntries = 0;
            // the case is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[capacity];
            bag = tempBag;
            integrityOK = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag whose"
                    +  "capacity exceeds allowed maximum.");
    } // end of type constructor

    /** Combines two collections consisting their contents into a new collection.
     @return A newly allocated collection that combined two bags. */
    public BagInterface<T> union(BagInterface<T> aBag)
    {
        // allow interoperability for this union method.
        BagInterface<T> newBag = new ResizableArrayBag<>();

        // check to see if either one of the two bags is null.
        if ((null == this) || (null == aBag))
        {
            // if so, return an empty bag because the union of
            // these two bags does not exist.
            System.out.print("A null bag was found...");
            return newBag;
        }
        // then check to see if both bags are empty.
        if (isEmpty() && aBag.isEmpty())
        {
            // if so, return an empty bag because the union of
            // these two bags does not exist.
            System.out.println("Both bags are empty.");
            return newBag;
        }
        
        // otherwise, return a newly allocated array bag that is
        // a combination of the entries from both of the bags.
        int index = 0;

        // copy the first bag.
        T[] bag1 = this.toArray();
        for (; index < this.getCurrentSize(); index++)
        {
            newBag.add(bag1[index]);
        }

        // copy the second bag.
        T[] bag2 = aBag.toArray();
        for (index = 0; index < aBag.getCurrentSize(); index++)
        {
            newBag.add(bag2[index]);
        }

        // return the union of the two bags.
        return newBag;
    } // end of "union"

    /** Determines whether the first bag's entries match any of the second bag's entries.
     @return A new collection of the overlapping entries. */
    public BagInterface<T> intersection(BagInterface<T> aBag)
    {
        // allow interoperability for this intersection method.
        BagInterface<T> newBag = new ResizableArrayBag<>();

        // check to see if either one of the two bags is null.
        if ((null == this) || (null == aBag))
        {
            // if so, return an empty bag because the
            // intersection of these two bags does not exist.
            System.out.print("A null bag was found...");
            return newBag;
        }
        // then check to see if both bags are empty.
        if (isEmpty() && aBag.isEmpty())
        {
            // if so, simply return an empty bag because the
            // intersection of these two bags does not exist.
            System.out.println("Both bags are empty.");
            return newBag;
        }

        // otherwise, copy the two bags into arrays.
        T[] bag1 = this.toArray();
        T[] bag2 = aBag.toArray();

        // iteration of the outer loop will represent the first bag's entries.
        for (int i = 0; i < this.getCurrentSize(); i++)
        {
            int counter1 = this.getFrequencyOf(bag1[i]);

            // iteration of the inner loop will represent the second bag's entries.
            for (int j = 0; j < aBag.getCurrentSize(); j++)
            {
                int counter2 = aBag.getFrequencyOf(bag2[j]);

                // check to see if the second bag's entries
                // match any of the first bag's entries.
                if (bag1[i] == bag2[j])
                {
                    // then check to see if all the overlapping
                    // entries have been added to the bag already.
                    if ((newBag.getFrequencyOf(bag1[i]) == counter1) ||
                            (newBag.getFrequencyOf(bag2[j]) == counter2))
                    {
                        // if so, break out of the inner for loop
                        // in order to prevent re-adding the entry.
                        break;
                    }
                    // otherwise, add the overlapping entry
                    // into the intersection bag.
                    else
                    {
                        newBag.add(bag1[i]);
                    }
                }
            }
        }

        // return the intersection of the two bags.
        return newBag;
    } // end of "intersection"


    /** Removes entries in the second bag from the first bag.
     * NOTE: The entries that are in the second bag but
     *       not in the first bag will simply be disregarded.
     @return A copy of the first bag that simply contains the leftover entries. */
    public BagInterface<T> difference(BagInterface<T> aBag)
    {
        // allow interoperability for this difference method.
        BagInterface <T> newBag = new ResizableArrayBag<>();

        // check to see if either one of the two bags is null.
        if ((null == this) || (null == aBag))
        {
            // if so, return an empty bag because the
            // difference of these two bags does not exist.
            System.out.print("A null bag was found...");
            return newBag;
        }
        // then check to see if both bags are empty.
        if (isEmpty() && aBag.isEmpty())
        {
            // if so, return an empty bag because the difference
            // of these two bags does not exist.
            System.out.println("Both bags are empty.");
            return newBag;
        }
        // otherwise, return a newly allocated array bag that is
        // the result of removing the entries that occur in both bags.
        int index = 0;

        // copy the entire first bag into the new bag.
        T[] bag1 = this.toArray();
        for (; index < this.getCurrentSize(); index++)
        {
            newBag.add(bag1[index]);
        }

        // copy the second bag.
        T[] bag2 = aBag.toArray();
        for (index = 0; index < aBag.getCurrentSize(); index++)
        {
            // check to see if the second bag's entries
            // match the first bag's entry.
            if (newBag.contains(bag2[index]))
            {
                // if so, remove it from the new bag before
                // returning the new bag back to the caller.
                newBag.remove(bag2[index]);
            }
        }

        // return the copy of the first bag that simply contains
        // leftover entries after removing the second bag's entries
        // from the first bag and disregarding the entries that are
        // in the second bag but not the first bag.
        return newBag;
    } // end of "difference"

    /** Gets the current number of entries in this bag.
     @return The integer number of entries in the bag currently. */
    public int getCurrentSize()
    {
        return numberOfEntries;
    } // end of "getCurrentSize"

    /** Throws an exception if this object is not initialized. */
    private void checkIntegrity()
    {
        if (!integrityOK)
            throw new SecurityException("ArrayBag object is corrupt.");
    } // end of "checkIntegrity"

    /** Determines whether the bag is empty or not.
     @returns true if the bag is empty, false otherwise. */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end of "isEmpty"

    /** Throws an exception if the client requests a capacity that is too large. */
    private void checkCapacity(int capacity)
    {
        if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose " +
                    "capacity exceeds allowed " +
                    "maximum of " + MAX_CAPACITY);
    } // end of "checkCapacity"

    /** Doubles the size of the array bag. */
    private void doubleCapacity()
    {
        int newCapacity = 2 * DEFAULT_CAPACITY;
        checkCapacity(newCapacity);
        bag = Arrays.copyOf(bag, newCapacity);
    } // end of "doubleCapacity"

    /** Adds a new entry to the bag.
     @param newEntry : The object to be added as a new entry.
     @return true if the addition is successful, false otherwise. */
    public boolean add(T newEntry)
    {
        checkIntegrity();

        // check to see if the bag is full.
        if (numberOfEntries == bag.length)
        {
            // if so, double the capacity.
            doubleCapacity();
        } // end of if-statement

        // add the new entry to the bag.
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;

        return true;
    } // end of "add"

    /** Locates a given entry within the array bag.
     @return The index of the entry if located, or -1 otherwise. */
    private int getIndexOf(T anEntry)
    {
        int where = -1;
        boolean found = false;
        int i = 0;

        while (!found && (i < numberOfEntries))
        {
            if (anEntry.equals(bag[i]))
            {
                found = true;
                where = i;
            } // end if
            i++;
        } // end while

        // Assertion: If where > -1, anEntry is in the array bag;
        // otherwise, anEntry was not found in this array bag.
        return where;
    } // end of "getIndexOf"

    /** Removes and returns the entry at a given index within the array bag.
    @returns An entry that is being removed, or null uf bi such entry exists. */
    private T removeEntry(int givenIndex)
    {
        T result = null;

        if (!isEmpty() && (givenIndex >= 0))
        {
            result = bag[givenIndex];                   // Entry to remove
            bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry
            bag[numberOfEntries - 1] = null;            // Remove last entry
            numberOfEntries--;
        } // end if

        // return the entry that was removed.
        return result;
    } // end of "removeEntry"

    /** Removes one unspecified entry from this bag, if possible.
     @return The removed entry if the removal was successful, or null otherwise. */
    public T remove()
    {
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);

        return result;
    } // end of "remove"

    /** Removes one occurence of a given entry from this bag.
     @param anEntry : The entry to be removed.
     @return True if the removal was successful, false otherwise. */
    public boolean remove(T anEntry)
    {
        checkIntegrity();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);

        return anEntry.equals(result);
    } // end of "remove"

    /** Removes all entries from the bag. */
    public void clear()
    {
        while (!isEmpty())
            remove();
    } // end of "clear"

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry : The entry to be counted.
     @return The number of times anEntry appears in this bag. */
    public int getFrequencyOf(T anEntry)
    {
        checkIntegrity();
        int counter = 0;

        for (int i = 0; i < numberOfEntries; i++)
        {
            if (anEntry.equals(bag[i]))
            {
                counter++;
            } // end if
        } // end for

        return counter;
    } // end of "getFrequencyOf"

    /** Tests whether the bag contains a given entry.
     @param anEntry : The entry to locate.
     @return True if the bag contains anEntry, or false otherwise. */
    public boolean contains(T anEntry)
    {
        checkIntegrity();
        return getIndexOf(anEntry) > -1;
    } // end of "contains"

    /** Retrieves all entries that are in this bag.
     @return A newly allocated array of all the entries in this bag. */
    public T[] toArray() 
    {
        //the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];
        
        for (int i = 0; i < numberOfEntries; i++)
        {
            result[i] = bag[i];
        } //end for loop
        
        return result;
    } // end of "toArray"

} // end of "ResizableArrayBag"
