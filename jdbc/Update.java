package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/mondee";
		String un="root";
		String pass="root";
		String query="update student set sname='Shree' where sid=103";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, un, pass);
		
		PreparedStatement ps=con.prepareStatement(query);
		int count=ps.executeUpdate();
		
		if(count!=0)
			System.out.println(count+ " row's inserted");
	}

}