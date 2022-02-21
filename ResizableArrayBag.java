public class ResizableArrayBag<T> implements BagInterface<T>
{
    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;


    public ResizableArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    public ResizableArrayBag(int capacity)
    {
        numberOfEntries = 0;

        // the case is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[capacity];
        bag = tempBag;
    }

    public T[] union(ResizableArrayBag<T> aBag)
    {
        // the case is safe because the new array contains null entries.
        @SuppressWarnings("unchecked")
        T[] newBag = (T[])new Object[numberOfEntries + aBag.getNumberOfEntries()];
        int index = 0;

        for (; index < getNumberOfEntries(); index++)
        {
            newBag[index] = bag[index];
        }

        for (index = 0; index < aBag.getNumberOfEntries(); index++)
        {
            newBag[getNumberOfEntries() + index] = aBag[index];
        }

        return newBag;
    }

    public T[] intersection(ResizableArrayBag<T> aBag)
    {
        // check to see if both of the bags are empty.
        if (isEmpty() && aBag.isEmpty())
        {
            // if so, simply return an empty array.
            @SuppressWarnings("unchecked")
            T[] newBag = null;
        }

        // otherwise, return a new array that contains overlapping entries.
        @SuppressWarnings("unchecked")
        T[] newBag = (T[])new Object[DEFAULT_CAPACITY];
        T entry;
        int index = 0;
        // iteration of the outer loop will represent the first bag's entries.
        for (int i = 0; i < getCurrentSize(); i++)
        {
            entry = bag[i];
            // iteration of the inner loop will represent the second bag's entries.
            for (int j = 0; j < aBag.getNumberOfEntries(); j++)
            {
                // check to see if the second bag's entries
                // match any of the first bag's entries.
                if (entry == aBag[j])
                {
                    newBag[index] = entry;
                    ++index;
                }
            }
        }

        return newBag;
    }

    public T[] difference(ResizableArrayBag<T> aBag)
    {

    }

    public int getNumberOfEntries()
    {
        return numberOfEntries;
    }

}
