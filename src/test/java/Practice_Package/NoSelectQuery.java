package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSelectQuery {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		int result=0;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sale", "root", "root");
		Statement state=con.createStatement();
		String query="insert into ty values('109','rajesh','309','er','mp);";
		 result = state.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		finally {
			if(result==1) {
				System.out.println("data updated");
			}
			else {
				System.err.println("data not updated");
			}
		}
	}

}
