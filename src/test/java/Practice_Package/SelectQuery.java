package Practice_Package;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuery {

	public static void main(String[] args) throws Throwable  {
		Connection con=null;
		try {
		//step1: create object for database
		Driver driver=new Driver();
		//step2: register the database
		DriverManager.registerDriver(driver);
		//step3: get connection for the database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sale", "root", "root");
		//step4: create statement
		Statement state=con.createStatement();
		String query="select * from ty;";
		//step 5: execute query
		ResultSet result=state.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
		}
		}
		catch (Exception e) {
			
		}
		//step 6: close database connection
		finally {
			con.close();
		}
	

	}
}
