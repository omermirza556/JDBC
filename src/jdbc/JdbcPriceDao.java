package jdbc;

import inter.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class JdbcPriceDao extends JdbcBaseDao implements PriceDao {
	@Override
	public String toString() {
		return "JdbcPriceDao [myConn=" + myConn + "]";
	}

	Connection myConn;

	public JdbcPriceDao(String jdbc) {
		super(jdbc);
		// TODO Auto-generated constructor stub
	}

	private List<Price> statementHelper(ResultSet myRs) throws SQLException {
		List<Price> theList = new ArrayList<Price>();

		while (myRs.next()) {
			Price p = new Price();
			p.setEndDate(myRs.getString("Enddate")).setMinPrice(myRs.getDouble("minprice"))
					.setProdId(myRs.getInt("prodid")).setStartDate(myRs.getString("startdate"))
					.setStdPrice(myRs.getDouble("stdprice"));

			theList.add(p);
		}

		return theList;

	}

	private List<Price> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<Price> theList = new ArrayList<Price>();
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
	public void updatePrice(Price p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePrice(Price p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPrice(Price p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Double returnMinimumPriceAfterDate(Integer prodId, String startDate) {
		return queryHelper("select * from price where prodid =" + prodId + " and startdate = " +startDate).get(0).getMinPrice();
	}

	@Override
	public Double returnStdPriceAfterDate(Integer prodId, String startDate) {
		return queryHelper("select * from price where prodid =" + prodId + " and startdate = " +startDate).get(0).getStdPrice();
	}

	@Override
	public Double returnMinimumPriceBeforeDate(Integer prodId, String endDate) {
		return queryHelper("select * from price where prodid =" + prodId + " and enddate = " + endDate).get(0).getMinPrice();
	}

	@Override
	public Double returnStdPriceBeforeDate(Integer prodId, String endDate) {
		return queryHelper("select * from price where prodid =" + prodId + " and endDate = " +endDate).get(0).getStdPrice();
	}

	@Override
	public List<Price> returnListOfPrices() {
		
		return queryHelper("select * from Price");
		
	}

}
