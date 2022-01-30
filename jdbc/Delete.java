package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Delete {
	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/mondee";
		String un="root";
		String pass="root";
		String query="delete from student where sid=105";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, un, pass);
		
		PreparedStatement ps=con.prepareStatement(query);
		int count=ps.executeUpdate();
		
		if(count!=0)
			System.out.println(count+ " row's deleted");
	}

}