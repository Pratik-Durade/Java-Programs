package jdbc;
import java.sql.*;

public class Select {

	public static void main(String[] args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/mondee";
		String un="root";
		String pass="root";
		String query="select * from student";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, un, pass);
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
//		rs.next();
//		System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
//		rs.next();
//		System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
//		rs.next();
//		System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
//		rs.next();
//		System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
		
		System.out.print("SID   SNAME\tSADD");
		System.out.print("\n========================\n");
		while(rs.next())
		{
			String data=rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
			System.out.println(data);
		}
		
	}

}
