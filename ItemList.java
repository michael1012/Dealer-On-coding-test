package receipt;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemList {
	
	private Item[] itemList;
	private int length;
	private int max;
	private ArrayList<String> taxedItems;
	
	/**
	 * Default constructor max length 10
	 */
	public ItemList(){
		
		this.itemList = new Item[5];
		this.length = 0;
		this.max = 5;
		taxedItems = new ArrayList<String>();
	}
	
	/**
	 * Constructor to include a premade list of taxed items
	 * @param taxedItems a list of taxed items
	 */
	public ItemList(String[] taxedItems){
		
		this.itemList = new Item[5];
		this.length = 0;
		this.max = 5;
		this.taxedItems = new ArrayList<String>(Arrays.asList(taxedItems));
	}
	
	/**
	 * Checks if the Item list is full
	 * @return true if Item list is full
	 */
	private boolean isFull(){
		
		return length == max;
	}
	
	/**
	 * Adds an item to the item list. Doubles the max size of the array if it is full
	 * @param item
	 */
	public void add(Item item){
		
		if(this.isFull()){
			
			Item newList[] = new Item[max * 2];
			for(int i=0; i<max; i++){
				newList[i] = this.itemList[i];
			}
			max = max*2;
			this.itemList = newList;
		}
		
		int checkName = exists(item.getName());; //checking the location of an existing item
		
		if(checkName == -1){
			if(taxedItem(item))
				item.setTaxed();
			itemList[length] = item;
			length++;
		}
		else{
			itemList[checkName].incAmount(item.getAmount());
		}	
	}
	
	/**
	 * returns the length of the item list
	 * @return length
	 */
	public int size(){
		return length;
	}
	
	/**
	 * Checks if an item with the same name already exists in the list
	 * @param name of an item
	 * @return the array location of where the item is, -1 otherwise
	 */
	private int exists(String name){
		
		for(int i=0; i<length; i++){
			if(itemList[i].getName().equals(name))
				return i;
		}
		return -1;
	}
	
	/**
	 * Checks if the name is in the list of taxed items
	 * @return true if item is taxed
	 */
	private boolean taxedItem(Item item){
		return taxedItems.contains(item.getName().toLowerCase());
	}
	
	/**
	 * Returns an item at the location given returns null if the location is too high
	 * @param location
	 * @return item at location, null otherwise
	 */
	public Item get(int location){
		if(location >= length)
			throw new IndexOutOfBoundsException("Location " + location + " is out of bounds!");
		return itemList[location];
	}
	
	/**
	 * Adds an item to the list of taxed items
	 * @param name of taxed item
	 */
	public void addTaxedItem(String name){
		taxedItems.add(name);
	}
	
	public void printReceipt(){
		
		double totalTax = 0;
		double total = 0; 
		for(int i=0 ;i<length; i++){
			System.out.println(itemList[i]);
			totalTax += itemList[i].getSalesTax() * itemList[i].getAmount();
			total += itemList[i].getPrice();
		}
		System.out.printf("Sales Taxes: %.2f\n", totalTax);
		System.out.printf("Total: %.2f\n", total);
		System.out.println();
	}
	
	

}
