package A1;	//TODO FIX ALL PACKAGES AND TEST RUN FROM CONSOLE BEFORE TURNING IN

public class TestClient
{

	public static void main(String[] args) throws NullPointerException, SetFullException
	{
		System.out.println("creating and populating String set");
		
		Set<String> stringSet = new Set<String>();
		
		System.out.println("Is String set empty? " + stringSet.isEmpty());
		
		stringSet.add("Aab");
		stringSet.add("bbc");
		stringSet.add("ccd");
		stringSet.add("dde");
		//stringSet.add(null);	PASS - Exception thrown successfully 
		stringSet.add("ffg");
		
		System.out.println(stringSet);
		
		System.out.println("Testing arbitrary remove method");
		
		stringSet.remove();
		
		System.out.println(stringSet);
		
		System.out.println("Testing specified remove method");
		
		stringSet.remove("ccd");
		
		System.out.println(stringSet);
		
		System.out.print("testing contains method for 'bbc' : ");
		
		System.out.println(stringSet.contains("bbc"));
		
		System.out.println("Is String set empty? " + stringSet.isEmpty());
		
		
		//intentionallt give null and other errors etc. 
		//loop to add 1000 ints to force resize
		//set to string
		
		System.out.println("creating and populating int set");
		
		Set<Integer> intSet = new Set<Integer>();
		
		
		//Fill set with 1000 ints to test resize method
		for (int i = 0 ; i < 1000; i++)
		{
			intSet.add(i);
		}
		
		System.out.println(intSet);
	
	
		intSet.clear();
		
		
		
		System.out.println(intSet);
		
		
		String[] strArr = new String[1000];
		
		for (int i = 0 ; i < 1000; i++)
		{
			strArr[i] = "Memes";
		}
		
		Set <String> strSet = new Set<>(strArr);
		
		
		System.out.println(strSet);

		System.out.println("Creating and populating Groceries item");
		
		//TODO	Create list - Constructor test
		Groceries myList = new Groceries();
		
		//TODO	Create Grocery Items and add to list.
		myList.addItem(new GroceryItem("Ground Beef", 1));
	
		myList.addItem(new GroceryItem("Apple", 2));

		myList.addItem(new GroceryItem("Peaches", 3));

		myList.addItem(new GroceryItem("Apple", 2));

		myList.addItem(new GroceryItem("Peaches", 2));
		
		myList.addItem(new GroceryItem("Apple", 2));
		
		myList.addItem(new GroceryItem("Peaches", 2));
		
		myList.addItem(null);	
		
		myList.addItem(new GroceryItem("White Wine", 2));
		
		myList.printAll();
		
		System.out.println();
		
		myList.modifyQuantity(new GroceryItem("Peaches", 1));
		
		myList.removeItem(new GroceryItem("Ground Beef"));	//Test removal of first entry //TODO fix Duplicate entry
		
		myList.removeItem(new GroceryItem("White Wine"));	//Test removal of last entry
		
		myList.printAll();

		
		
		
		
		
	}

}
