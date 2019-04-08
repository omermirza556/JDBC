package jdbc;

import java.sql.*;
import inter.*;
import domain.*;

/**
 * This is an abstract class that connects our database to whatever jdbc is used
 * to our database for a single point of maintainenence
 * 
 * @author omer
 *
 */
public abstract class JdbcBaseDao {
	String jdbc;

	public JdbcBaseDao(String jdbc) {
		this.jdbc = jdbc;

	}

}
