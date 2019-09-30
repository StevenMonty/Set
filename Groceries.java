/**
 * @author Steven Montalbano
 * 4173105 ~ SMM285@pitt.edu 
 * September 26, 2018
 * 
 * CS 445 Data Structures
 * 
 * The purpose of this program is to create a grocery list using the Set class that contains GroceryItems. 
 * 
 * @see A1.GoceryItem
 */

package A1; //TODO FIX ALL PACKAGES AND TEST RUN FROM CONSOLE BEFORE TURNING IN

public class Groceries implements GroceriesInterface
{
	private Set<GroceryItem> contents = null;
	
	public Groceries()
	{
		contents = new Set<GroceryItem>();
	}
	
	@Override
	public void addItem(GroceryItem item)
	{
		if (item == null)
			return;		//Throw NullPointer Exception?
		
		if (contents.contains(item))
			{
				//remove old item and store its quantity
				int oldQuan = contents.remove(item).getQuantity();

				try
					{
						contents.add(new GroceryItem(item.getDescription(), item.getQuantity() + oldQuan));
					}
				catch (NullPointerException | SetFullException e)
					{
						e.printStackTrace();
					}
			
				return;
			}
			
		try
			{
				contents.add(item);
			}
		catch (NullPointerException | SetFullException e)
			{
				e.printStackTrace();
			}
	}

	@Override
	public void removeItem(GroceryItem item)
	{
		if (item == null)
			return;
		
		if (contents.contains(item))
		{
			GroceryItem tmp = contents.remove(item);
			
			if (tmp.getQuantity() > item.getQuantity())	//More exist than wishing to remove
			{
				int newQuantity = tmp.getQuantity() - item.getQuantity();	//Subtract quantity of the item in set from the item being passed in
				
				GroceryItem newItem = new GroceryItem(item.getDescription(), newQuantity);
				
				try
					{
						contents.add(newItem);
					}
				catch (NullPointerException | SetFullException e)
					{
						e.printStackTrace();
					}
			}
			
			if (tmp.getQuantity() <= item.getQuantity())	//Trying to remove all or more than already exists, removes all
				contents.remove(item);
		}
	}

	@Override
	public int modifyQuantity(GroceryItem item)
	{
		//update current item passed in's quantity in the set with the  input items new quantity 
		if (item == null || !contents.contains(item))	//to allow short circuiting 
			return -1; 
		
		GroceryItem tmp = contents.remove(item);
		
		int initQuantity = tmp.getQuantity();	//Initial quantity
		
		GroceryItem newItem = new GroceryItem(item.getDescription(), item.getQuantity());
		
		try
			{
				contents.add(newItem);
			}
		catch (NullPointerException | SetFullException e)
			{
				e.printStackTrace();
			}

		return initQuantity;
	}

	@Override
	public void printAll()
	{
		System.out.println("Groceries:");
		System.out.println("----------");
	
		if (contents.getSize() == 0)
		{
			System.out.println("No Grocery Items in Set");
			return;
		}

		Object[] list = contents.toArray();
		
		for (int i = 0; i < list.length; i++ )
			System.out.println(list[i]);
	}
}