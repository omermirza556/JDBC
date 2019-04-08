package inter;

import java.util.List;
import domain.*;

public interface OrdDao {

	public List<Ord> listAllOrders();

	public List<Ord> listAllOrdersByCustId(Integer custId);

	public List<Ord> listAllOrdersLessThan(Double price);

	public List<Ord> listAllOrdersGreaterThan(Double price);

	public List<Ord> listAllOrdersBeforeDate(String date);

	public List<Ord> listAllOrdersAfterDate(String date);

	public List<Ord> listAllOrdersOnDate(String date);

	public Ord getOrderById(Integer ordId);

	public void updateOrd(Ord o);

	public void createOrd(Ord o);

	public void deleteOrd(Ord o);

}
