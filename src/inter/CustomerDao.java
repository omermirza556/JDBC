package inter;

import java.util.List;
import domain.*;

/**
 * 
 * @author omer
 *
 */
public interface CustomerDao {

	public Customer getCustomer(Integer custId);

	public List<Customer> listAllCustomers();

	public List<Customer> listAllCustomersByCustId(Integer custId);

	public List<Customer> listAllCustomersByName(String name);

	public List<Customer> listAllCustomersByAddress(String address);

	public List<Customer> listAllCustomersByCity(String city);

	public List<Customer> listAllCustomersByState(String state);

	public List<Customer> listAllCustomersByZip(Integer zip);

	public List<Customer> listAllCustomersByArea(String Area);

	public List<Customer> listAllCustomersByPhone(String Phone);

	public List<Customer> listAllCustomersByRepId(Integer repId);

	public List<Customer> listAllCustomersByCreaditLimit(Double creditLimit);

	public void updateCustomer(Customer c);

	public void deleteCustomer(Customer c);

	public void createCustomer(Customer c);

}
