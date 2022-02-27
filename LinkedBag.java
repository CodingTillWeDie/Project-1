import java.util.*;

public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;    // Reference to first node
    private int numberOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end of default constructor

    /** Combines two collections consisting their contents into a new collection.
     @return A newly allocated collection that combined two bags. */
    public BagInterface<T> union(BagInterface<T> aBag)
    {
        // check to see if both bags are empty.
        BagInterface<T> newBag = new LinkedBag<>();
        if (isEmpty() && aBag.isEmpty())
        {
            // if so, return null because the union of
            // these two bags do not exist.
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
        for (index = 0; index < aBag.getCurrentSize(); ++index)
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
        BagInterface<T> newBag = new LinkedBag<>();
        // check to see if both of the bags are empty.
        if (isEmpty() && aBag.isEmpty())
        {
            // if so, simply return null because the
            // intersection of these two bags do not exist.
            System.out.println("Both bags are empty.");
            return newBag;
        }

        // allow interoperability.
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
                    // check to see if all the overlapping entries
                    // have been to the bag already.
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
        BagInterface <T> newBag = new ResizableArrayBag<>();
        // check to see if both of the bags are empty.
        if (isEmpty() && aBag.isEmpty())
        {
            // if so, simply return null because the
            // difference of these two bags do not exist.
            System.out.println("Both bags are empty.");
            return newBag;
        }
        // otherwise, return a newly allocated array bag that is
        // the result of removing the entries that occur in both bags.

        // allow interoperability for this union method.
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
            if (newBag.contains(bag2[index]))
            {
                newBag.remove(bag2[index]);
            }
        }

        // return the copy of the first bag that simply contains
        // leftover entries after removing the second bag's entries.
        return newBag;
    } // end of "difference"

    /** Adds a new entry to this bag.
     @param newEntry  The object to be added as a new entry.
     @return  True. */
    public boolean add(T newEntry) // OutOfMemoryError possible
    {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;  // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode;       // New node is at beginning of chain
        numberOfEntries++;

        return true;
    } // end of "add"

    /** Removes one unspecified entry from this bag, if possible.
     @return  Either the removed entry, if the removal
     was successful, or null. */
    public T remove()
    {
        T result = null;

        if (firstNode != null)
        {
            result = firstNode.data;
            firstNode = firstNode.next; // Remove first node from chain
            numberOfEntries--;
        } // end if

        return result;
    } // end of "remove"

    /** Removes one occurrence of a given entry from this bag.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false otherwise. */
    public boolean remove(T anEntry)
    {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null)
        {
            nodeN.data = firstNode.data; // Replace located entry with entry in first node.
            firstNode = firstNode.next; // Remove first node
            numberOfEntries--;
            result = true;
        } // end if
        return result;

    } // end of "remove"

    /** Sees whether this bag is empty.
     @return  True if the bag is empty, or false if not. */
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end of "isEmpty"

    /** Gets the number of entries currently in this bag.
     @return  The integer number of entries currently in the bag. */
    public int getCurrentSize()
    {
        return numberOfEntries;
    } // end of "getCurrentSize"


    /** Removes all entries from this bag. */
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    } // end of "clear"

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry  The entry to be counted.
     @return  The number of times anEntry appears in the bag. */
    public int getFrequencyOf(T anEntry)
    {
        int frequency = 0;

        int counter =0;
        Node currentNode = firstNode;
        while((counter<numberOfEntries)&&(currentNode!=null))
        {
            if(anEntry.equals(currentNode.getData()))
            {
                frequency++;
            }//end if
            counter++;
            currentNode=currentNode.getNextNode();
        }//end while
        return frequency;

    } // end of "getFrequencyOf"

    /** Tests whether this bag contains a given entry.
     @param anEntry  The entry to locate.
     @return  True if the bag contains anEntry, or false otherwise. */
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next;
            }
        } // end while

        return found;
    } // end of "contains"

    /** Retrieves all entries that are in this bag.
     @return  A newly allocated array of all the entries in this bag. */
    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while

        return result;
    } // end of "toArray"

    /** Locates a given entry within this bag.
     @return a reference to the node containing the entry if located, or null otherwise. */
    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while

        return currentNode;
    } // end getReferenceTo

    private class Node
    {
        private T    data;    // Entry in bag
        private Node next;    // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end of type constructor #1

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end of type constructor #2
        private T getData()
        {
            return data;
        }// end getData
        private Node getNextNode()
        {
            return next;
        }//end getNextNode
    } // end of "Node" class

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
    }
}
