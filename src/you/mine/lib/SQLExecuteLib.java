package you.mine.lib;
import java.sql.*;
public class SQLExecuteLib {
	private SQLExecuteLib() {}
	public static void singleSQLExecute(Connection connection, String sql) throws SQLException {
		Statement stat = connection.createStatement();
		stat.execute(sql);
		stat.close();
	}
	public static ResultSet singleSQLResultSet(Connection connection, String sql) throws SQLException {
		Statement stat = connection.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		stat.close();
		return rs;
	}
}
