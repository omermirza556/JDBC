package jdbc;

import inter.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class JdbcEmpDao extends JdbcBaseDao implements EmpDao {
	@Override
	public String toString() {
		return "JdbcEmpDao [myConn=" + myConn + "]";
	}

	Connection myConn;

	public JdbcEmpDao(String jdbc) {
		super(jdbc);
		// TODO Auto-generated constructor stub
	}

	private List<Emp> statementHelper(ResultSet myRs) throws SQLException {
		List<Emp> theList = new ArrayList<Emp>();
		while (myRs.next()) {
			Emp e = new Emp();
			e.setComm(myRs.getDouble("comm")).setDeptNo(myRs.getInt("deptno")).setEmpNo(myRs.getInt("empno"))
					.seteName(myRs.getString("ename")).setHireDate(myRs.getString("hiredate"))
					.setJob(myRs.getString("job")).setMgr(myRs.getInt("mgr")).setSal(myRs.getDouble("sal"));
			theList.add(e);
		}

		return theList;
	}

	private List<Emp> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<Emp> theList = new ArrayList<Emp>();
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
	public Emp getEmployee(Integer empNo) {
		
		return queryHelper("select * from emp where emp.empno = " + empNo).get(0);
		
	}

	@Override
	public List<Emp> listAllEmployees() {
		
		return queryHelper("select * from emp");
		

	}

	@Override
	public List<Emp> listAllEmployeesByEmpNo(Integer empNo) {
		// TODO Auto-generated method stub
		
		return queryHelper("select * from emp where emp.empno=" + empNo );
	}

	@Override
	public List<Emp> listAllEmployeesByEName(String eName) {
		// TODO Auto-generated method stub
		return queryHelper("select * from emp where emp.ename=" + eName);
		
	}

	@Override
	public List<Emp> listAllEmployeesByJob(String job) {
		return queryHelper("select * from emp where emp.job=" + job );
		
	}

	@Override
	public List<Emp> listAllEmployeesByMgr(Integer mgr) {
		return queryHelper("select * from emp where emp.mgr=" + mgr );
		
	}

	@Override
	public List<Emp> listAllEmployeesByHireDate(String hireDate) {
		return queryHelper("select * from emp where emp.hiredate=" + hireDate );
		
	}

	@Override
	public List<Emp> listAllEmployeesBySal(Integer sal) {
		return queryHelper("select * from emp where emp.sal=" + sal );
		
	}

	@Override
	public List<Emp> listAllEmployeesByComm(Integer comm) {
		return queryHelper("select * from emp where emp.comm=" + comm );
		
	}

	@Override
	public List<Emp> listAllEmployeesByDeptNo(Integer deptNo) {
		return queryHelper("select * from emp where emp.deptNo=" + deptNo );
		
	}

	@Override
	public List<Emp> listAllEmployeesByDept(Dept d) {
		return queryHelper("select * from emp where emp.deptno=" + d.getDeptNo() );
		
	}

	@Override
	public List<Emp> listAllEmployeesByDeptNoWhenSalaryLessThan(Integer deptNo, Integer salLevel) {
		return null;
	}

	@Override
	public void updateEmployee(Emp e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(Emp e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createEmployee(Emp e) {
		// TODO Auto-generated method stub

	}

}
