package receipt;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemListTest_general {

	@Test
	public void test() {
		
		Item item1 = new Item(1, "chocolate", "8.88", false);
		Item item2 = new Item(2, "cool chocolate", "10.22", true);
		Item item3 = new Item(1, "bottle of perfume", "12.55", false);
		Item item4 = new Item(1, "Hot nuts", "13.51", false);
		Item item5 = new Item(1, "Potato", "1.22", false);
		Item item6 = new Item(1, "Pain pills", "7.55", false);
		Item item7 = new Item(1, "Book 1", "12.99", false);
		Item item8 = new Item(1, "Music CD", "15.48", false);
		Item item9 = new Item(1, "Book 2", "12.99", false);
		Item item10 = new Item(1, "book on fire", "10.99", false);
		Item item11 = new Item(1, "Hammer", "5.74", false);
		Item item12 = new Item(1, "Sugar", "3.45", false);
		
		//ItemList test
		ItemList itemList = new ItemList();
		itemList.add(item1);
		itemList.add(item2);
		System.out.println(itemList.get(0).getName());
				
				
		itemList.add(item1);
		itemList.add(item2);
		System.out.println(itemList.get(1));
		System.out.println();
		
		//adding list of taxed items
		String[] taxedItems = {"bottle of perfume", "music cd", "hammer"};
		ItemList itemList2 = new ItemList(taxedItems);
		itemList2.add(item1);
		itemList2.add(item2);
		itemList2.add(item3);
		itemList2.add(item4);
		itemList2.add(item5);
		itemList2.add(item6);
		itemList2.add(item7);
		itemList2.add(item8);
		itemList2.add(item9);
		itemList2.add(item10);
		itemList2.add(item11);
		itemList2.add(item12);
		itemList2.add(item7);
		itemList2.add(item8);
		itemList2.add(item9);
		itemList2.add(item10);
		itemList2.add(item11);
		itemList2.add(item12);
		
		itemList2.printReceipt();
	}

}
