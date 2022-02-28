public interface BagInterface<T>
{
    /** Combines two collections into a new collection.
     * The "union" does not affect the contents of two
     * bags and there will be no specific order of data
     * items in the returned bag.
     @return A new bag that is the union of two bags. */
    public BagInterface<T> union(BagInterface<T> aBag);

    /** Adds overlapping entries into a new collection
     * when they occur in two collections. The "intersection"
     * also does not affect the contents of two bags.
     @return A new bag that is the intersection of two bags. */
    public BagInterface<T> intersection(BagInterface<T> aBag);

    /** Removes entries in the second bag from the first bag
     * and puts the leftover entries in a new collection.
     * The entries that are in the second bag but not the
     * first bag will simply be disregarded, and the
     * "difference" does not affect the contents of two bags.
     @return A new bag that is the difference of two bags. */
    public BagInterface<T> difference(BagInterface<T> aBag);

    /** Gets the current number of entries in this bag.
     @return The integer number of entries currently in the bag. */
    public int getCurrentSize();

    /** Checks to see whether this bag is empty or not.
     @return True if the bag is empty, and false otherwise. */
    public boolean isEmpty();

    /** Adds a new entry to this bag.
     @param newEntry  The object to be added as a new entry.
     @return  True if the addition is successful, or false if not. */
    public boolean add(T newEntry);

    /** Removes one unspecified entry from this bag, if possible.
     @return  Either the removed entry, if the removal was successful, or null. */
    public T remove();

    /** Removes one occurrence of a given entry from this bag, if possible.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry);

    /** Removes all entries from this bag. */
    public void clear();

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry  The entry to be counted.
     @return  The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry);

    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to find.
     @return  True if the bag contains anEntry, or false if not. */
    public boolean contains(T anEntry);

    /** Retrieves all entries that are in this bag.
     @return  A newly allocated array of all the entries in the bag. Note: If the bag is empty, the returned array is empty. */
    public T[] toArray();



} // end of BagInterface
