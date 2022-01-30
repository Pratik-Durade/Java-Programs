package jdbc;
import java.sql.*;

public class Insert {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/mondee";
		String un="root";
		String pass="root";
		String query="insert into student values(105,'Akshay','Pune')";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, un, pass);
		
		PreparedStatement ps=con.prepareStatement(query);
		int count=ps.executeUpdate();
		
		if(count!=0)
			System.out.println(count+ " row's inserted");
	}

}
