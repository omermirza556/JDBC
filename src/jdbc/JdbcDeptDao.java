package jdbc;

import inter.*;
import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeptDao extends JdbcBaseDao implements DeptDao {
	Connection myConn;

	public JdbcDeptDao(String jdbc) {
		super(jdbc);
		// TODO Auto-generated constructor stub
	}

	private List<Dept> statementHelper(ResultSet myRs) throws SQLException {
		List<Dept> theList = new ArrayList<Dept>();
		while(myRs.next()) {
			Dept d = new Dept();
			d.setDeptNo(myRs.getInt("deptno")).setdName(myRs.getString("dname")).setLoc(myRs.getString("loc"));
			theList.add(d);
		}
		
		return theList;
	}

	private List<Dept> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<Dept> theList = new ArrayList<Dept>();
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
	public Dept getDept(Integer deptNo) {
		return queryHelper("select * from dept where dept.deptno = " + deptNo).get(0);
		
	}

	@Override
	public Dept getDeptByName(String dName) {
		return queryHelper("select * from dept where dept.dname = " + dName).get(0);
	}

	@Override
	public Dept getDeptByLoc(String Loc) {
		return queryHelper("select * from dept where dept.loc = " + Loc).get(0);
	}

	@Override
	public void updateDept(Dept d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDept(Dept d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createDept(Dept d) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Dept> getAllDepts() {
		return queryHelper("select * from dept");
		
	}

	@Override
	public String toString() {
		return "JdbcDeptDao [myConn=" + myConn + "]";
	}
	
	

}
