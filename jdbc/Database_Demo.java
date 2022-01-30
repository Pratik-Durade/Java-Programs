package jdbc;
import java.sql.*;

public class Database_Demo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/mondee";
		String un="root";
		String pass="root";
		
		Connection con=DriverManager.getConnection(url, un, pass);
		
		if(con!=null)
			System.out.println("Database Connection Established Successfully");
		else
			System.out.println("Connection Failed");
		
		Statement st=con.createStatement();
		
		int x=st.executeUpdate("insert into student values (102,'Akshay','Nipani')");
		int y=st.executeUpdate("update student set sadd='NIPPANI' where sid=101");
		int z=st.executeUpdate("delete from student where sid=102");
		
		ResultSet rs=st.executeQuery("select * from student");
			
		if(z!=0)
			System.out.println(z+" record deleted.");
	}

}
 