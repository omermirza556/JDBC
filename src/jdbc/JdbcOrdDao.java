package jdbc;

import inter.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class JdbcOrdDao extends JdbcBaseDao implements OrdDao {

	Connection myConn;

	public JdbcOrdDao(String jdbc) {
		super(jdbc);
		// TODO Auto-generated constructor stub
	}

	private List<Ord> statementHelper(ResultSet myRs) throws SQLException {
		List<Ord> theList = new ArrayList<Ord>();

		while (myRs.next()) {
			Ord o = new Ord();
			o.setCommPlan(myRs.getString("commplan")).setCustId(myRs.getInt("custId"))
					.setOrderDate(myRs.getString("orderdate")).setOrdId(myRs.getInt("ordid"))
					.setShipDate(myRs.getString("shipdate")).setTotal(myRs.getDouble("total"));
			theList.add(o);
		}
		return theList;
	}
	
	
	@Override
	public String toString() {
		return "JdbcOrdDao [myConn=" + myConn + "]";
	}

	private List<Ord> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<Ord> theList = new ArrayList<Ord>();
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
	public List<Ord> listAllOrders() {
		return queryHelper("select * from ord");
	}

	@Override
	public List<Ord> listAllOrdersByCustId(Integer custId) {
		return queryHelper("select * from ord where custId =" + custId);
	}

	@Override
	public List<Ord> listAllOrdersLessThan(Double price) {
		return queryHelper("select * from ord where price <" + price);
	}

	@Override
	public List<Ord> listAllOrdersGreaterThan(Double price) {
		return queryHelper("select * from ord where custId >" + price);
	}

	@Override
	public List<Ord> listAllOrdersBeforeDate(String date) {
		return queryHelper("select * from ord where orderdate <" + date);
	}

	@Override
	public List<Ord> listAllOrdersAfterDate(String date) {
		return queryHelper("select * from ord where orderdate >" + date);
	}

	@Override
	public List<Ord> listAllOrdersOnDate(String date) {
		return queryHelper("select * from ord where orderdate =" + date);
	}

	@Override
	public Ord getOrderById(Integer ordId) {
		return queryHelper("select * from ord where ordId =" + ordId).get(0);
	}

	@Override
	public void updateOrd(Ord o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createOrd(Ord o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOrd(Ord o) {
		// TODO Auto-generated method stub

	}

}
