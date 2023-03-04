package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.techpalle.model.Users;

public class DataAccess
{
	private static final String  dburl      = "jdbc:mysql://localhost:3306/servlet";
	private static final String  dbusername = "root";
	private static final String  dbpassword = "Admin";
	
	private static Connection con = null;
	private static Statement s   = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String insertqry = "insert into user(name,email,password,state) values(?,?,?,?)";
	
	private static final String updateqry = "update user set name=?,password=?,state=? where email=?";
	
	private static final String deleteqry = "delete from user where email=?";
	
	private static final String displayqry = "select * from user";
	
	public static void insertvalue(Users u)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dburl,dbusername,dbpassword);
			ps = con.prepareStatement(insertqry);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getState());
			
			
		    ps.executeUpdate();
		        
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updatedata(Users us)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dburl,dbusername,dbpassword);
			ps = con.prepareStatement(updateqry);
			ps.setString(1, us.getName());
			ps.setString(2, us.getPassword());
			ps.setString(3, us.getState());
			ps.setString(4, us.getEmail());
			ps.executeUpdate();
			}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
 public static void deleteData(String email)
 {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(dburl,dbusername,dbpassword);
		ps = con.prepareStatement(deleteqry);
		ps.setString(1, email);
		ps.executeUpdate();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 finally {
		 if( ps != null)
		 {
			 try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 if(con != null)
			 {
				 try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
		 }
	 }
 }
 public static ArrayList<Users> reading()
 {
	 ArrayList<Users> data = new ArrayList<Users>();
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(dburl,dbusername,dbpassword);
		s = con.createStatement();
		rs = s.executeQuery(displayqry);
		
		while(rs.next())
		{
			String e = rs.getString("email");
			String n = rs.getString("name");
			String p = rs.getString("password");
			String st = rs.getString("state");
			
			Users u = new Users(n, e, p, st);
			data.add(u);
		}
		
	} 
	 catch (ClassNotFoundException e)
	 {
		e.printStackTrace();
	}
	 catch (SQLException e)
	 {
		e.printStackTrace();
	}
	return data;
	 }
}
