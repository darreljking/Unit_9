import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
	private Connection conn = null;
	private String dbURL;
	public DB() {
		dbURL = "jdbc:sqlserver://IRONMAN\\SQLEXPRESS03;"
				+ "database=Northwind;"
				+ "user=sa;"
				+ "password=GetOffMyLawn;"
				+ "encrypt=false;"
				+ "trustServerCertificate=false;"
				+ "loginTimeout=30;";
		
	}
	public DB(String connection) {
		dbURL = connection;
	}
	
	public String getCustomerCount() {
		String count = null;
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "SELECT COUNT(*) AS COUNT FROM Customers;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while(rs.next()) {
					count = rs.getString("COUNT");
				}
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return count;
	}
	
	public String getCompanyNames() {
		String result = "";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "SELECT companyname FROM customers;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while (rs.next()) {
					result += rs.getString("companyname")+"\n";
				}
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}			
		}
		return result;
	}
	
	public String getOrderCount() {
		String result = "";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "SELECT COUNT(*) AS COUNT FROM Orders;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while (rs.next()) {
					result += rs.getString("COUNT")+"\n";
				}
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}			
		}
		return result;
	}
	
	public String getShipNames() {
		String result = "";
		
		try {
			conn = DriverManager.getConnection(dbURL);
			
			if(conn != null) {
				String countQuery = "SELECT ShipName FROM Orders;";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(countQuery);
				
				while (rs.next()) {
					result += rs.getString("ShipName")+"\n";
				}
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}			
		}
		return result;
	}
		
		public String getEmployeeCount() {
			String result = "";
			
			try {
				conn = DriverManager.getConnection(dbURL);
				
				if(conn != null) {
					String countQuery = "SELECT COUNT(*) AS COUNT FROM Employees;";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(countQuery);
					
					while (rs.next()) {
						result += rs.getString("COUNT")+"\n";
					}
				}
			}catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
					if(conn != null && !conn.isClosed()) {
						conn.close();
					}
				}catch(SQLException ex) {
					ex.printStackTrace();
				}			
			}
			return result;
	}
		public String getEmployeeNames() {
			String result = "";
			
			try {
				conn = DriverManager.getConnection(dbURL);
				
				if(conn != null) {
					String countQuery = "SELECT LastName + ', ' + FirstName AS FullName FROM Employees;";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(countQuery);
					
					while (rs.next()) {
						result += rs.getString("FullName")+"\n";
					}
				}
			}catch (SQLException ex) {
				ex.printStackTrace();
			}finally {
				try {
					if(conn != null && !conn.isClosed()) {
						conn.close();
					}
				}catch(SQLException ex) {
					ex.printStackTrace();
				}			
			}
			return result;
		}
}
