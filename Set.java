/**
 * @author Steven Montalbano
 * 4173105 ~ SMM285@pitt.edu 
 * September 26, 2018
 * 
 * CS 445 Data Structures
 * 
 * The purpose of this program is to replicate the Set interface included in the Java library. 
 */

package A1; //TODO FIX ALL PACKAGES AND TEST RUN FROM CONSOLE BEFORE TURNING IN

import java.util.Arrays;

public class Set<E> implements SetInterface<E>
{
	private final static int INITIAL_SIZE = 25;
	private int size;
	private E[] contents;
	
	public Set() 
	{
		this(INITIAL_SIZE);	
	}
	
	@SuppressWarnings("unchecked")
	public Set (int initialCapacity) 
	{
		if (initialCapacity == 0)
			throw new IllegalArgumentException("Cannot initialize set to size 0");
		
		contents = (E[]) new Object[initialCapacity];
		size = 0;
	}
	
	public Set (E[] entries)
	{
		this();
	
		for (int i = 0; i < entries.length; i++)
		{
			try
			{
				this.add(entries[i]);
			}
			catch (NullPointerException | SetFullException e )
			{
				e.printStackTrace();
			}
	
		}
	}

	@Override
	public int getSize()
	{
		return contents.length;
	}

	@Override
	public boolean isEmpty()
	{
		return (size == 0);
	}

	@Override
	public boolean add(E newEntry) throws SetFullException, NullPointerException
	{
		if (newEntry == null)
			throw new NullPointerException();
		
		if (this.contains(newEntry))
			return false;
		
		// Dynamic upsize array if full
		if (size == contents.length - 1)
			contents = Arrays.copyOf(contents, contents.length*2);
		
		//My implementation is not fixed size so the below code is un needed
		
		//If the array were to fill up, would throw a SetFullException. Shouldnt be possible because of the 
		//the last if statement on line 76 but the Exception was outlined in the proveided interface. 
		if (size == contents.length)
			throw new SetFullException();
		
		contents[size++] = newEntry;
		
		return true;
	}

	@Override
	public E remove(E entry) throws NullPointerException
	{
		if (entry == null)
			throw new NullPointerException();
		
		for (int i = 0; i < size; i++)
		{
			E tmp = contents[i];
			
			if (tmp.equals(entry))
			{
				contents[i] = contents[size-1];	//Over write ref to specified entry to remove with ref of object at end of array
				contents[size--] = null;		//Set last ref to null to avoid duplicates, decriment size to maintain consistency 
				
				return tmp;
			}
		}
		
		return null;
	}

	@Override
	public E remove()
	{
		E tmp = contents[size];
		contents[size--] = null;
		
		return tmp;
	}

	@Override
	public void clear()	
	{
		for (int i = 0; i < contents.length; i++)
		{
			contents[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean contains(E entry) throws NullPointerException
	{
		if (entry == null) 
			throw new NullPointerException();

		for (int i = 0; i < size; i++)
		{
			E tmp = contents[i];

			if (tmp.equals(entry))
				return true;
		}
		
		return false;
	}

	@Override
	public Object[] toArray()
	{
		Object[] arr = new Object[size];
		
		for (int i = 0; i < size; i++)
		{	
			arr[i] = contents[i];
		}
		return arr;
	}
		
    public String toString() 
    {
        StringBuilder result = new StringBuilder("Set Contents[ ");

        for (int index = 0; index < size; index++) {
            result.append(contents[index].toString());
            result.append(' ');
        }

        result.append(']');
        return result.toString();
    }
}