
public class LinkedBag < T > implements BagInterface {
	
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedBag() 
	{
		firstNode = null;
		numberofEntries = 0;
	}
	//implementation of methods based on bagInterface>>>
	
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
