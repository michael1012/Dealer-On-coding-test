package receipt;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {
	
	private int amount;
	private String name;
	private BigDecimal shelfPrice;
	private boolean imported;
	private boolean taxed;
	
	
	/**
	 * Default constructor
	 * @param amount
	 * @param name
	 * @param shelfPrice
	 * @param imported
	 * @param imported
	 */
	public Item(int amount, String name, String shelfPrice, boolean imported){
		
		this.amount = amount;
		this.name = name;
		this.shelfPrice = new BigDecimal(shelfPrice);
		this.imported = imported;
		this.taxed = false;
	}
		
	
	/**
	 * Returns the amount of the item
	 * @return amount
	 */
	public int getAmount(){
		return amount;
	}
	
	/**
	 * Returns the price of the item
	 * @return total price
	 */
	public double getPrice(){
		
		return getSalesPrice() * amount;
	}
	
	/**
	 * Returns the sales price of an individual item adds 5% for imported and 10% for taxed on the base price of the item
	 * @return sales price of 1 item
	 */
	public double getSalesPrice(){
		return shelfPrice.doubleValue() + getSalesTax();
	}
	
	/**
	 * Returns the tax of the item 5% for imported and 10% for sales tax
	 * @return sales tax of 1 item
	 */
	public double getSalesTax(){
		if(imported && taxed){
			return shelfPrice.multiply(new BigDecimal(".15")).multiply(new BigDecimal("20")).setScale(0, RoundingMode.CEILING).divide(new BigDecimal("20")).doubleValue();
		}
		else if(imported){
			return shelfPrice.setScale(0, RoundingMode.CEILING).divide(new BigDecimal("20")).doubleValue();
		}
		else if(taxed){
			return shelfPrice.multiply(new BigDecimal(".10")).multiply(new BigDecimal("20")).setScale(0, RoundingMode.CEILING).divide(new BigDecimal("20")).doubleValue();
		}
		return 0;
	}
	
	
	
	/**
	 * Returns the name of the item
	 * @return name of item
	 */
	public String getName(){
		return name;
	}
	

	/**
	 * Returns a string displaying information for the receipt
	 */
	public String toString(){
		
		if(imported){
			if(amount == 1){
				return "Imported " + getName() +": " + String.format("%.2f", getPrice());
			}
			else{
				return "Imported " + getName() + ": " + String.format("%.2f", getPrice()) + " (" + amount + " @ " + String.format("%.2f", getSalesPrice()) + ")";
			}
		}
		if(amount == 1){
			return getName() +": " + String.format("%.2f", getPrice());
		}
		else{
			return getName() + ": " + String.format("%.2f", getPrice()) + " (" + amount + " @ " + String.format("%.2f", getSalesPrice()) + ")";
		}
			
	}
	
	/**
	 * Increases the amount of an item when duplicates are found
	 * @param amount
	 */
	public void incAmount(int amount){
		this.amount += amount;
	}
	
	/**
	 * Sets the item as taxed
	 */
	public void setTaxed(){
		taxed = true;
	}
	
	
	
	

}
