
public class LinkedBag < T > implements BagInterface < T > 
{
	
	private Node firstNode;
	private int numberOfEntries;
	
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
        checkIntegrity();
        T result = removeEntry(numberOfEntries - 1);
        return result;
    } // end of "remove"
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
