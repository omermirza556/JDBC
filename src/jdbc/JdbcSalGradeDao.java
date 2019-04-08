package jdbc;

import inter.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class JdbcSalGradeDao extends JdbcBaseDao implements SalGradeDao {
	@Override
	public String toString() {
		return "JdbcSalGradeDao [myConn=" + myConn + "]";
	}

	Connection myConn;
	
	public JdbcSalGradeDao(String jdbc) {
		super(jdbc);
		// TODO Auto-generated constructor stub
	}
	private List<SalGrade> statementHelper(ResultSet myRs) throws SQLException {
		List<SalGrade> theList = new ArrayList<SalGrade>();

		while (myRs.next()) {
			SalGrade s = new SalGrade();
			s.setGrade(myRs.getInt("grade")).setHiSal(myRs.getInt("hisal")).setLoSal(myRs.getInt("lowsal"));
			theList.add(s);
		}

		return theList;

	}

	private List<SalGrade> queryHelper(String q) {
		Statement myStmt = null;
		ResultSet myRs = null;
		List<SalGrade> theList = new ArrayList<SalGrade>();
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
	public List<SalGrade> returnAllSalGrades() {
		return queryHelper("select * from salgrade");
	}

	@Override
	public SalGrade getSalGrade(Integer grade) {
		return queryHelper("select * from salgrade where grade = " + grade).get(0);
	}

	@Override
	public void createSalGrade(SalGrade s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSalGrade(SalGrade s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteSalGrade(SalGrade s) {
		// TODO Auto-generated method stub

	}

}
