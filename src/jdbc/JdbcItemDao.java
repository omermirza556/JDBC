package jdbc;

import inter.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class JdbcItemDao extends JdbcBaseDao implements ItemDao {
	@Override
	public String toString() {
		return "JdbcItemDao [myConn=" + myConn + "]";
	}

	Connection myConn;

	public JdbcItemDao(String jdbc) {
		super(jdbc);
	}

	private List<Item> statementHelper(ResultSet myRs) throws SQLException {
		List<Item> theList = new ArrayList<Item>();

		while (myRs.next()) {
			Item i = new Item();
			i.setActualPrice(myRs.getDouble("actualprice")).setItemId(myRs.getInt("ItemId"))
					.setItemTotal(myRs.getDouble("itemtot")).setOrdId(myRs.getInt("ordid"))
					.setProdId(myRs.getInt("prodId")).setQty(myRs.getInt("qty"));
			theList.add(i);
		}

		return theList;

	}

	private List<Item> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<Item> theList = new ArrayList<Item>();
		try {
			myConn = DriverManager.getConnection(jdbc);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(q);

			theList = statementHelper(myRs);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				myRs.close();
				myStmt.close();
				myConn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return theList;
	}

	@Override
	public Item getItem(Integer orderId, Integer itemId) {
		
		return queryHelper("select * from Item where orderId=" +orderId +"and itemId =" +itemId ).get(0);
	
	}

	@Override
	public List<Item> getListOfItemByOrderId(Integer orderId) {
		return queryHelper("select * from Item where orderId = " + orderId);
		
	}

	@Override
	public List<Item> getListOfItemByitemId(Integer itemId) {
		return queryHelper("select * from Item where itemId =" + itemId);
		
	}

	@Override
	public void updateItem(Item i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteItem(Item i) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createItem(Item i) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Item> getListOfItems() {
		// TODO Auto-generated method stub
		return queryHelper("select * from Item");
	}

}
