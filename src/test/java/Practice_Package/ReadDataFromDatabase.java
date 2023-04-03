package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabase {

	public static void main(String[] args) throws Throwable  {
		Connection con=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sale", "root", "root");
		Statement state=con.createStatement();
		String query="select * from ty;";
		ResultSet result=state.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1));
		}
		}catch(Exception e) {
				
			}
		finally {
			con.close();
		}
	}
}
