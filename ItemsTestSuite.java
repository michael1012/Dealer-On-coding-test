package receipt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	ItemTest_general.class, 
	ItemListTest_general.class
})
public class ItemsTestSuite {

}
