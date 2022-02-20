public interface BagInterface<T>
{
    /** Combines two collections into a new collection.
        The "union" does not affect the contents of two
        bags and there will be no specific order of data
        items in the returned bag.
        @return A new bag that is the union of two bags. */
    public BagInterface<T> union(BagInterface<T> aBag);

    /** Adds overlapping entries into a new collection
        when they occur in two collections. The "intersection"
        also does not affect the contents of two bags.
        @return A new bag that is the intersection of two bags. */
    public BagInterface<T> intersection(BagInterface<T> aBag);

    /** Removes entries in the second bag from the first bag
        and puts the leftover entries in a new collection.
        The entries that are in the second bag but not the
        first bag will simply be disregarded, and the
        "difference" does not affect the contents of two bags.
     @return A new bag that is the difference of two bags. */
    public BagInterface<T> difference(BagInterface<T> aBag);

} // end of BagInterface
