package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;






import java.sql.Statement;

import com.models.Ask;
import com.models.RegistrationModel;
import com.models.UpdateModel;



public class ConnectionMake {
	public static String username="Akshit";
	public static String password="akshit";
	public static String driver="com.ibm.db2.jcc.DB2Driver";
	public static String url="jdbc:db2://localhost:50000/PROJECTQ";
	public static Connection con=null;
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	static            
	{         //whenever a progarm is made run,,,,always class is first loaded....in static block all connections r made because it is made at d time of loading of class even before main is run
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url, username, password);
			System.out.println("connection successfull with Q$A db");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String insertValues(String sql,RegistrationModel obj)
	{
		try{
			
			ps=con.prepareStatement(sql);
			ps.setString(1,obj.getFirstname());//same firstname,lastname... will be attributes of table reg
			ps.setString(2,obj.getLastname());
			ps.setString(3,obj.getEmail());
			ps.setString(4,obj.getPhone());
			ps.setString(5,obj.getPassword());
			ps.setString(6,obj.getSex());
			int i=ps.executeUpdate();
			if(i>=1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	
	public static String userValidation(String sql,RegistrationModel obj)
	{
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,obj.getEmail());
			ps.setString(2,obj.getPassword());
			rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				i++;
			}
			if(i>=1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return "";
	}
	public static ResultSet FetchUserDataByName(String sql,String uname)
	{
		
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,uname);
			rs=ps.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rs;
	}
	
	public static String updateValues(String sql,UpdateModel obj)
	{
		try{
			
			ps=con.prepareStatement(sql);
			ps.setString(1,obj.getFname());//same firstname,lastname... will be attributes of table reg
			ps.setString(2,obj.getLname());
			ps.setString(3,obj.getEmail());
			ps.setString(4,obj.getPhone());
			ps.setString(5,obj.getPwd());
			ps.setString(6,obj.getEmail());
			int i=ps.executeUpdate();
			if(i>=1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	public static String askQuestion(String sql,Ask obj)
	{
		try{
			
			ps=con.prepareStatement(sql);
			ps.setString(1,obj.getEmail());
			ps.setString(2,obj.getQuestion());
			ps.setString(3,obj.getDetails());
			ps.setString(4,obj.getDatetime());
			int i=ps.executeUpdate();
			if(i>=1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}

	public static ResultSet FetchQuestionDetails(String sql)
	{
		
		try
		{
			//ps=con.prepareStatement(sql);
			Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = s.executeQuery(sql);

			boolean bool=rs.last(); //Moves the curser to the end of the ResultSet object
			//rs=ps.executeQuery();
			if(bool==true)
			{
				return rs;
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rs;
	}
	public static String makeTable(String count)
	{
		try{
			Statement stmt=null;
			stmt=con.createStatement();
			int coun=Integer.parseInt(count);
			String sql1="create table Tb"+coun+"(Answer varchar(4000)) in default1";
			int i=stmt.executeUpdate(sql1);
			if(i>=1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	public static String makeTableSpace(String sql)
	{
		try{
			Statement stmt=null;
			stmt=con.createStatement();
			int i=stmt.executeUpdate(sql);
			if(i>=1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
	public static String fetchCount(String sql,Ask obj)
	{
		String c=null;
		try
		{
			ps=con.prepareStatement(sql);
			ps.setString(1,obj.getEmail());
			ps.setString(2,obj.getQuestion());
			rs=ps.executeQuery();
			int i=0;
			while(rs.next())
			{
				 c=rs.getString(5);
				i++;
			}
			if(i>=1)
			{
				return c;
				
			}
			else
			{
				System.out.println("cant return count");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return "";
	}
	public static String enterAnswer(int count,String answer)
	{
try{
			String sql="insert into Tb"+count+"(answer)values(?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,answer);
			int i=ps.executeUpdate();
			if(i>=1)
			{
				return "success";
			}
			else
			{
				return "fail";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}
		
	public static ResultSet FetchDetails(int coun)
	{
		
		try
		{
			String sql="select * from questiondetails where count="+coun;
			ps=con.prepareStatement(sql);
		//	ps.setInt(1,obj.getCount());
			rs=ps.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rs;
	}
	public static ResultSet FetchAnswers(int count)
	{
		
		try
		{
			String sql="select * from Tb"+count;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rs;
	}
	public static ResultSet FetchQuestion(String username)
	{
		
		try
		{
			
			String sql="select * from questiondetails where email="+username;
			
		
			//rs=ps.executeQuery();
			

			ps=con.prepareStatement(sql);
			//ps.setInt(1,obj.getCount());
			rs=ps.executeQuery();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rs;
	}
public static void main(String[] args) {
		

	}

}
