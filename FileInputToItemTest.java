package receipt;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class FileInputToItemTest {

	@Test
	public void test() {
		
		//Taxed items file
		String taxedFile = "List_of_taxed_items.txt";
		List<String> taxedList = Collections.emptyList();
		try
		{ 
			taxedList = Files.readAllLines(Paths.get(taxedFile)); 
		} 
			  
		catch (IOException e) 
		{ 
			// do something 
			e.printStackTrace(); 
		} 
		String[] taxedItems = taxedList.toArray(new String[0]);

		
		String fileName = "input3.txt";
		List<String> lines = Collections.emptyList(); 
	    try
	    { 
	      lines = Files.readAllLines(Paths.get(fileName)); 
	    } 
	  
	    catch (IOException e) 
	    { 
	      // do something 
	      e.printStackTrace(); 
	    } 
	    
	    //variables to input into items
	    ItemList itemListInput1 = new ItemList(taxedItems);
	    int amount;
	    String itemName = "";
	    boolean imported;
	    String price;
	    
	    //parsing lines into items
	    String[] lineSplit;
	    for(int i=0; i<lines.size(); i++){
	    	
	    	lineSplit = lines.get(i).split(" ");
	    	amount = Integer.parseInt(lineSplit[0]);
	    	price = lineSplit[lineSplit.length-1];
	    	if(lineSplit[1].equals("Imported")){
	    		
	    		imported = true;
	    		for(int j=2; j<lineSplit.length-3; j++){
	    			itemName = itemName + lineSplit[j] + " ";
	    		}
	    	}
	    	else{
	    		
	    		imported = false;
	    		for(int j=1; j<lineSplit.length-3; j++){
	    			itemName = itemName + lineSplit[j] + " ";
	    		}	    		
	    	}
	    	itemName += lineSplit[lineSplit.length-3];
	    	itemListInput1.add(new Item(amount, itemName, price, imported));
	    	itemName = "";
	    }
	    
	    itemListInput1.printReceipt();
		
	}

}
