package receipt;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemTest_general {

	@Test
	public void test() {
		//Item test
		Item item1 = new Item(1, "chocolate", "8.88", false);
		System.out.println(item1.getAmount());
		System.out.println(item1.getName());
		System.out.printf("%.2f\n", item1.getPrice());
		System.out.printf("%.2f\n", item1.getSalesPrice());
		System.out.println(item1);
		System.out.println();
				
		Item item2 = new Item(2, "cool chocolate", "10.22", true);
		System.out.println(item2.getAmount());
		System.out.println(item2.getName());
		System.out.printf("%.2f\n", item2.getPrice());
		System.out.printf("%.2f\n", item2.getSalesPrice());
		System.out.println(item1);
		System.out.println();
	}

}
