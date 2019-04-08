package jdbc;

import inter.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class JdbcProductDao extends JdbcBaseDao implements ProductDao {

	@Override
	public String toString() {
		return "JdbcProductDao [myConn=" + myConn + "]";
	}

	Connection myConn;
	public JdbcProductDao(String jdbc) {
		super(jdbc);
		// TODO Auto-generated constructor stub
	}
	
	
	private List<Product> statementHelper(ResultSet myRs) throws SQLException {
		List<Product> theList = new ArrayList<Product>();

		while (myRs.next()) {
			Product p = new Product();
			p.setDescrip(myRs.getString("descrip")).setProdId(myRs.getInt("prodid"));
			theList.add(p);
		}

		return theList;

	}

	private List<Product> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<Product> theList = new ArrayList<Product>();
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
	public List<Product> getAllProducts() {
		return queryHelper("select * from product");
	}

	@Override
	public String returnDescriptionOfProduct(Integer prodId) {
		return queryHelper("select * from product where prodid = " + prodId ).get(0).getDescrip();
	}

	@Override
	public void createProduct(Product p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(Product p) {
		// TODO Auto-generated method stub

	}

}
