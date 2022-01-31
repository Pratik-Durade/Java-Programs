package jdbc;

import java.sql.*;
import java.util.Scanner;

class Crud
{
	Connection con;
	Crud() throws Exception
	{
		String url="jdbc:mysql://localhost:3306/mondee";
		String un="root";
		String pass="root";
		String query="select * from student";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url, un, pass);
	}
	
		void insert() throws Exception
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Employee ID : ");
			int eid=sc.nextInt();
			
			System.out.println("Enter Employee Name : ");
			String ename=sc.next();
			
			System.out.println("Enter Employee Salary : ");
			int esal=sc.nextInt();
			
			PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setInt(3, esal);
			
			int count=ps.executeUpdate();
			
			if(count!=0)
				System.out.println(count+ " row's inserted");
		}
		
		
		void select() throws Exception
		{
			PreparedStatement st=con.prepareStatement("select * from employee");
			ResultSet rs=st.executeQuery();
			System.out.print("EID   ENAME\tESALARY");
			System.out.print("\n========================\n");
		
			while(rs.next())
			{
				String data=rs.getInt("eid")+" : "+rs.getString("ename")+" : "+rs.getString(3);
				System.out.println(data);
			}	
			
			System.out.print("========================\n");
		}
		
		
		void delete() throws Exception
		{
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter Employee ID to delete : ");
			int eid=sc.nextInt();
			
			//PreparedStatement ps=con.prepareStatement(query);
			
			PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
			ps.setInt(1, eid);
			
			int count=ps.executeUpdate();
			
			if(count!=0)
				System.out.println(count+ " row's deleted");
		}
		
		
		void update() throws Exception
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("ENTER CHOICE : \n\t1. to update Name \n\t2. to update Salary \n\t3. to update Name and Salary\n\t4. Add Bonus to all Employees");
			int ch=sc.nextInt();
			
			if(ch==1)
			{
				System.out.println("Enter your Employee ID to update your details : ");
				int eid=sc.nextInt();
				System.out.println("Enter new Name :");
				String u_name=sc.next();
				PreparedStatement name=con.prepareStatement("update employee set ename=? where eid=?");
				name.setString(1,u_name);
				name.setInt(2, eid);
				int count=name.executeUpdate();
				
				if(count!=0)
					System.out.println(count+ " row's updated");
			}
			else if(ch==2)
			{
				System.out.println("Enter your Employee ID to update your details : ");
				int eid=sc.nextInt();
				System.out.println("Enter new Salary :");
				int e_sal=sc.nextInt();
				PreparedStatement add=con.prepareStatement("update employee set esal=? where eid=?");
				add.setInt(1,e_sal);
				add.setInt(2, eid);
				int count=add.executeUpdate();
				
				if(count!=0)
					System.out.println(count+ " row's updated");
			}
			else if(ch==3)
			{
				System.out.println("Enter your Employee ID to update your details : ");
				int eid=sc.nextInt();
				System.out.println("Enter new Name :");
				String e_name=sc.next();
				
				System.out.println("Enter new Salary :");
				int e_sal=sc.nextInt();
				
				PreparedStatement name_sal=con.prepareStatement("update employee set ename=? , esal=? where eid=?");
				name_sal.setString(1,e_name);
				name_sal.setInt(2, e_sal);
				name_sal.setInt(3,eid);
				int count=name_sal.executeUpdate();
				
				if(count!=0)
					System.out.println(count+ " row's updated");
			}
			else if(ch==4)
			{
				System.out.println("Enter Bonus :");
				int b=sc.nextInt();
				PreparedStatement name=con.prepareStatement("update employee set esal=esal+?");
				name.setInt(1,b);
				int count=name.executeUpdate();
				
				if(count!=0)
					System.out.println(count+ " row's updated");
			}
			else
				System.out.println("Wrong Choice...");	
			}
	
}
public class Crud_Demo {

	public static void main(String[] args) throws Exception {
		Crud c=new Crud();
//		c.insert();
//		System.out.println();
//		c.select();
//		System.out.println();
//		c.delete();
//		System.out.println();
//		c.select();
		//c.insert();
//		 c.select();
//		c.update();
//		//c.delete();
//		c.select();
		Scanner sc=new Scanner(System.in);	
	
		while(true)
		{
			System.out.println("\nEMPLOYEE DATABASE");
			System.out.println("Enter Choice : \n1.INSERT  2.UPDATE  3.DELETE  4.SELECT  5.EXIT");
			int ch=sc.nextInt();
			
			switch(ch)
			{
				case 1:
						c.insert();
						while(true)
						{
							System.out.println("Do you want to continue y/n?");
							char ch1=sc.next().charAt(0);
							if(ch1=='y' || ch1=='Y')
								c.insert();
							else 
								break;
						}	
					break;
				
				case 2:
					c.update();
					break;
					
				case 3:
					c.delete();
					break;
				
				case 4:
					c.select();
					break;
					
				case 5: 
					System.out.println("Program Closed...");
					System.exit(0);
				
				default : System.out.println("INVALID CHOICE TRY AGAIN.....");
			}
		}

	}

}
