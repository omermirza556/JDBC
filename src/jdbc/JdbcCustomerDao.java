package jdbc;

import inter.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class JdbcCustomerDao extends JdbcBaseDao implements CustomerDao {
	Connection myConn;

	public JdbcCustomerDao(String jdbc) {
		super(jdbc);
	}

	private List<Customer> statementHelper(ResultSet myRs) throws SQLException {

		List<Customer> theCustomerList = new ArrayList<Customer>();

		while (myRs.next()) {
			Customer c = new Customer();
			c.setCustId(myRs.getInt("custId")).setName(myRs.getString("name")).setAddress(myRs.getString("address"))
					.setCity(myRs.getString("city")).setState(myRs.getString("state")).setZip(myRs.getInt("zip"))
					.setAreaCode(myRs.getString("area")).setPhone(myRs.getString("phone"))
					.setRepId(myRs.getInt("repId")).setCreditLimit(myRs.getDouble("creditLimit"))
					.setComments(myRs.getString("comments"));

			theCustomerList.add(c);

		}
		return theCustomerList;

	}

	private List<Customer> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<Customer> theCustomerList = new ArrayList<Customer>();

		try {

			myConn = DriverManager.getConnection(jdbc);

			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(q);

			theCustomerList = statementHelper(myRs);

		} catch (SQLException e) {

			System.err.println("cannot connect ");
		} finally {
			try {
				myRs.close();
				myStmt.close();
				myConn.close();
			} catch (SQLException e) {

			}
		}

		return theCustomerList;

	}

	/**
	 * this method returns a customer based on a specific customer ID, which is a
	 * primary key in the customer table in
	 */
	@Override
	public Customer getCustomer(Integer custId) {
		Statement myStmt = null;
		ResultSet myRs = null;
		Customer c = new Customer();
		try {
			myConn = DriverManager.getConnection(this.jdbc);
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("Select * from customer where customer.custId=" + custId);
			c.setCustId(myRs.getInt("custId")).setName(myRs.getString("name")).setAddress(myRs.getString("address"))
					.setCity(myRs.getString("city")).setState(myRs.getString("state")).setZip(myRs.getInt("zip"))
					.setAreaCode(myRs.getString("area")).setPhone(myRs.getString("phone"))
					.setRepId(myRs.getInt("repId")).setCreditLimit(myRs.getDouble("creditLimit"))
					.setComments(myRs.getString("comments"));
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				myRs.close();
				myStmt.close();
				myConn.close();
			} catch (SQLException e) {

				System.err.println("Something went horribly wrong");
			}

		}

		return c;
	}

	/**
	 * This method returns a list of all customers in our database
	 */
	@Override
	public List<Customer> listAllCustomers() {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer");
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer");
	}

	@Override
	public List<Customer> listAllCustomersByCustId(Integer custId) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.custId = " + custId);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.custId = " + custId);
		// return queryHelper("select * from customer where customer.custId = " +
		// custId);

	}

	@Override
	public List<Customer> listAllCustomersByName(String name) {

//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.name= " + name);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.name = " + name);
	}

	@Override
	public List<Customer> listAllCustomersByAddress(String address) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.address= " + address);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.address = " + address);

	}

	@Override
	public List<Customer> listAllCustomersByCity(String city) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("Select * from customer where city= " + city);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where city = " +city);

	}

	@Override
	public List<Customer> listAllCustomersByState(String state) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.state = " + state);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.state = " + state);

	}

	@Override
	public List<Customer> listAllCustomersByZip(Integer zip) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.zip= " + zip);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.zip = " + zip);

	}

	@Override
	public List<Customer> listAllCustomersByArea(String Area) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.area= " + Area);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}
//
//		return theCustomerList;
		
		return queryHelper("select * from customer where customer.area = " + Area);

	}

	@Override
	public List<Customer> listAllCustomersByPhone(String Phone) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.phone= " + Phone);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.phone = " + Phone);

	}

	@Override
	public List<Customer> listAllCustomersByRepId(Integer repId) {
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.repId= " + repId);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.repId = "  +repId );

	}

	@Override
	public List<Customer> listAllCustomersByCreaditLimit(Double creditLimit) {

//		Statement myStmt = null;
//		ResultSet myRs = null;
//		List<Customer> theCustomerList = new ArrayList<Customer>();
//		try {
//			myConn = DriverManager.getConnection(this.jdbc);
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery("select * from customer where customer.creditLimit = " + creditLimit);
//			theCustomerList = statementHelper(myRs);
//
//		} catch (SQLException e) {
//
//			System.err.println("cannot Kinect ");
//		} finally {
//			try {
//				myConn.close();
//
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}

		return queryHelper("select * from customer where customer.creditLimit = " + creditLimit);

	}

	@Override
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCustomer(Customer c) {
		// TODO Auto-generated method stub

	}

}
