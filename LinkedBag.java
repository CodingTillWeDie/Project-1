
public class LinkedBag < T > implements BagInterface < T > 
{
	
	private Node firstNode;
	private int numberofEntries;
	
	public LinkedBag() 
	{
		firstNode = null;
		numberofEntries = 0;
	}
	//implementation of methods based on bagInterface>>>
	
	/** Removes one unspecified entry from this bag, if possible.
     	@return The removed entry if the removal was successful, or null otherwise. */
    	public T remove()
    	{
		
    	} // end of "remove"
	/** Sees whether this bag is empty.

	@return True if this bag is empty, or false if not. */

	public boolean isEmpty()

	{

		return numberofEntries == 0;

	} // end isEmpty
	/** Adds a new entry to this bag.

	@param newEntry The object to be added as a new entry

	@return True if the addition is successful, or false if not. */

	public boolean add(T newEntry) // OutOfMemoryError possible

	{

	// Add to beginning of chain:

		Node newNode = new Node(newEntry);

		newNode.next = firstNode; // Make new node reference rest of chain

					// (firstNode is null if chain is empty)   

		firstNode = newNode; // New node is at beginning of chain

		numberofEntries++;

		return true;

	} // end add
	/** Removes one unspecified entry from this bag, if possible.

	@return Either the removed entry, if the removal

	was successful, or null. */

	public T remove()

	{

		T result = null;

		if (firstNode != null)

		{

			result = firstNode.data;

			firstNode = firstNode.next; // Remove first node from chain

			numberofEntries--;

		} // end if

		return result;

	} // end remove
	/** Removes one occurrence of a given entry from this bag, if possible.

	@param anEntry The entry to be removed.

	@return True if the removal was successful, or false otherwise. */

	public boolean remove(T anEntry)

	{

		boolean result = false;

		Node nodeN = getReferenceTo(anEntry);

		if (nodeN != null)

		{

			nodeN.data = firstNode.data; // Replace located entry with entry in first node

			firstNode = firstNode.next; // Remove first node

			numberofEntries--;

			result = true;

		} // end if

		return result;

	} // end remove
	/** Retrieves all entries that are in this bag.

	@return A newly allocated array of all the entries in this bag. */

	public T[] toArray()

	{

	// The cast is safe because the new array contains null entries

		@SuppressWarnings("unchecked")

		T[] result = (T[]) new Object[numberofEntries]; // Unchecked cast

		int index = 0;

		Node currentNode = firstNode;

		while ((index < numberofEntries) && (currentNode != null))

		{

		result[index] = currentNode.data;

		index++;

		currentNode = currentNode.next;

		} // end while

		return result;

	} // end toArray
	private class Node
	{
		private T data;
		private Node next;
		
		private Node(T dataPortion) 
		{
			this(dataPortion, null);
			
		}
		private Node(T dataPortion, Node nextNode) 
		{
			data = dataPortion;
			next = nextNode;
		}
	}
	
	
	

}
