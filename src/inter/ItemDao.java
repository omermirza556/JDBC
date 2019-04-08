package inter;

import java.util.List;
import domain.*;

/**
 * 
 * @author omer
 *
 */
public interface ItemDao {
	public Item getItem(Integer orderId, Integer itemId);
	
	
	public List<Item> getListOfItems();
	public List<Item> getListOfItemByOrderId(Integer orderId);

	public List<Item> getListOfItemByitemId(Integer itemId);

	/*
	 * 
	 * THIS IS WHERE YOU STOPPED ON TUES OCTOBER 23
	 */

	public void updateItem(Item i);

	public void deleteItem(Item i);

	public void createItem(Item i);

}
