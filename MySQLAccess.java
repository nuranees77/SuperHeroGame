package Downasour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;  

public class MySQLAccess{  
public static int highscore;  
public static void main(String args[]) {

	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/trexScore","root","Database2019");  
		//here sonoo is database name, root is username and password  

		}catch(Exception e){ System.out.println("fault at main");}  
	 

}

public void readData() throws  SQLException, ClassNotFoundException{
	
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/trexScore","root","Database2019");  
	
	try{  
		

		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("show tables");  
		ResultSet rs1=stmt.executeQuery("select highestscore from score");  
		
		 while (rs1.next()) {
		highscore=rs1.getInt(1);
		 }

		System.out.println(highscore);

		}catch(Exception e){ System.out.println("fault at readData");}  
	
}

public void writeData(int newScore) throws  SQLException{
	
 
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/trexScore","root","Database2019");  
	//here sonoo is database name, root is username and password  
	
	try{  

		Statement stmt=con.createStatement();  
		//ResultSet rs2=stmt.executeUpdate(sql)
		int rs=stmt.executeUpdate("update score set highestscore=" + newScore);  


		}catch(Exception e){ System.out.println("fault at writeData");}  
}
}