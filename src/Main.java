import java.util.ArrayList;
import java.util.List;

import domain.*;
import inter.*;
import jdbc.*;

/**
 * PLEASE NOTE: I will be adding comments for the other classes in due time.
 * Most of them are similar in concept. I.E. to have two private helper methods
 * for single point of maintence that execute a query based on the actual method
 * and then iterating through the result set
 * 
 * @author omer
 *
 */
public class Main {

	public static void main(String[] args) {
		/*
		 * This is establishing our connections
		 */
		JdbcCustomerDao jC = new JdbcCustomerDao("jdbc:sqlite:company.db");
		JdbcOrdDao jO = new JdbcOrdDao("jdbc:sqlite:company.db");
		JdbcProductDao jP = new JdbcProductDao("jdbc:sqlite:company.db");
		JdbcItemDao jI = new JdbcItemDao("jdbc:sqlite:company.db");
		/*
		 * creating array lists from our tables
		 */
		List<Customer> custArray = jC.listAllCustomers();
		List<Ord> ordArray = jO.listAllOrders();
		List<Product> prodArray = jP.getAllProducts();
		List<Item> itemArray = jI.getListOfItems();

		String s = "";

		Integer prevOid = null;
		double total = 0;
		ArrayList<String> iter = new ArrayList<String>();
		ArrayList<String> itemIter = new ArrayList<String>();

		/*
		 * This is going to be a group of nested for loops that represent our sql
		 * queries,
		 */
		for (Customer c : custArray) {
			for (Ord o : ordArray) {

				if (c.getCustId().equals(o.getCustId())) {
					Integer prevOid2 = null;

					if (!c.getCustId().equals(prevOid)) {
						/*
						 * print the first query
						 */
						total = 0;
						System.out.println("\n" + s);
						/*
						 * print the second query
						 */
						for (String s41 : iter) {
							System.out.println("\n" + s41);
							/*
							 * print the third
							 */
							for (String s42 : itemIter) {
								System.out.println(s42);
							}

						}
						/*
						 * this for loop creates a list for our second query
						 */
						iter = new ArrayList<String>();
						for (Ord o2 : ordArray) {
							if (c.getCustId().equals(o2.getCustId())) {
								iter.add(new String(String.format("ORDER ID : %s, ORDER DATE: %s, TOTAL: %s",
										o2.getOrdId(), o2.getOrderDate(), o2.getTotal())));
								itemIter = new ArrayList<String>();
								/*
								 * these for loops create a list for our third query
								 */
								for (Ord o3 : ordArray) {
									for (Product p : prodArray) {
										for (Item i : itemArray) {
											if (i.getOrdId().equals(o3.getOrdId())
													&& p.getProdId().equals(i.getProdId())
													&& o3.getOrdId().equals(o2.getOrdId())) {

												itemIter.add(new String(String.format(
														"DESCRIPTION %s, QTY %s, ACTUAL PRICE %s, ITEM TOTAL %s",
														p.getDescrip(), i.getQty(), i.getActualPrice(),
														i.getItemTotal())));

											}

										}
									}
								}

							}
							prevOid2 = o2.getCustId();
						}

					}
					/*
					 * method for adding the total amount of purchases
					 */

					total += o.getTotal();
					s = String.format("CUSTOMER ID:%s			NAME:%s			TOTAL:%s", c.getCustId(), c.getName(),
							total);

					prevOid = o.getCustId();

					// }
				}

			}
		}
		System.out.println("\n" + s);
		/*
		 * couldnt quite get these straglers to fit into the loop wihtout something
		 * going horribly wrong
		 */
		for (String s41 : iter) {
			System.out.println(s41);
			for (String s42 : itemIter) {
				System.out.println(s42);
			}

		}

	}

}
