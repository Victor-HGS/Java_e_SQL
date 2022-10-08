package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	//private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	private static final String dbms = "mysql";
	private static final String serverName = "localhost";
	private static final Object userName = "root";
	private static final Object password = "1234";
	private static final String portNumber = "3306";
	private static final String dbName = "atividade_conexao_db";

	// Método de conexão entre o programa e o DB via connector/driver
	public static Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", userName);
	    connectionProps.put("password", password);

	    if (dbms.equals("mysql")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + dbms + "://" +
	                   serverName +
	                   ":" + portNumber + "/",
	                   connectionProps);
	    } else if (dbms.equals("derby")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + dbms + ":" +
	                   dbName +
	                   ";create=true",
	                   connectionProps);
	    }
	    System.out.println("Connected to database");
	    return conn;
	}
	
	// Métodos para encerramento da conexão com o DB
	public static void closeConnection(Connection con) {
		try {
			if(con != null) {
				con.close();
			}
		}
		catch (SQLException error) {
			throw new RuntimeException(error);
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		}
		catch (SQLException error) {
			throw new RuntimeException(error);
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
		
		try {
			if(rs != null) {
				rs.close();
			}
		}
		catch (SQLException error) {
			throw new RuntimeException(error);
		}
	}
}
