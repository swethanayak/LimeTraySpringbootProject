package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.model.UsersRegisterSignup;
import com.example.demo.model.UsersSignin;


@Repository
public class SignupDAO {
	
	public static Connection connectToDB() {
		Connection connection = null;
		try {// Register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Create Connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public void addusers(UsersRegisterSignup obj) {
		// TODO Auto-generated method stub
		System.out.println(obj);
		
		try {
			Connection con = connectToDB();
			//Create Statement
			PreparedStatement stmt=con.prepareStatement("insert into signup values(?,?,?,?)");
			stmt.setString(1,obj.getName());
			stmt.setString(2, obj.getUserid());
			stmt.setString(3, obj.getEmailid());
			stmt.setLong(4, obj.getPhonenumber());
			PreparedStatement stmt1=con.prepareStatement("insert into signin values(?,?)");
			stmt1.setString(1, obj.getUserid());
			stmt1.setString(2, obj.getPassword());
			// Execute SQL query
			int affectedrows = stmt.executeUpdate();
			System.out.println("Affected Rows in signup table = "+affectedrows);
			int affectedrows1 = stmt1.executeUpdate();
			System.out.println("Affected Rows in signin table  = "+affectedrows1);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<UsersRegisterSignup> displayusers() {
		// TODO Auto-generated method stub
		ArrayList<UsersRegisterSignup> usersList = new ArrayList<UsersRegisterSignup>();
		// TODO Auto-generated method stub
		try {
			Connection con = connectToDB();
			//Create Statement
			PreparedStatement stmt=con.prepareStatement("select * from signup");
			
			// Execute SQL query
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				UsersRegisterSignup obj=new UsersRegisterSignup();
				obj.setName(rs.getString(1));
				obj.setUserid(rs.getString(2));
				obj.setEmailid(rs.getString(3));
				obj.setPhonenumber(rs.getInt(4));
				usersList.add(obj);
			}
	
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usersList;
	}

	

	public boolean validate(String userid, String password) {
		
		try {
			Connection con = connectToDB();
			//Create Statement
			PreparedStatement stmt=con.prepareStatement("select * from signin where userid='"+ userid +"' and password='"+password+"'");
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
				return true;
			
			con.close();
		
		// TODO Auto-generated method stub
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}

	public String postRegisteredUsers(UsersRegisterSignup obj) {
		// TODO Auto-generated method stub
		try {
			Connection con = connectToDB();
			//Create Statement
			PreparedStatement stmt=con.prepareStatement("insert into signup values(?,?,?,?)");
			stmt.setString(1,obj.getName());
			stmt.setString(2, obj.getUserid());
			stmt.setString(3, obj.getEmailid());
			stmt.setLong(4, obj.getPhonenumber());
			PreparedStatement stmt1=con.prepareStatement("insert into signin values(?,?)");
			stmt1.setString(1, obj.getUserid());
			stmt1.setString(2, obj.getPassword());
			// Execute SQL query
						int affectedrows = stmt.executeUpdate();
						System.out.println("Affected Rows in signup table = "+affectedrows);
						int affectedrows1 = stmt1.executeUpdate();
						System.out.println("Affected Rows in signin table  = "+affectedrows1);
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		return "User Registered Successfully";
	}

	public boolean postValidateUsers(UsersSignin obj) {
		// TODO Auto-generated method stub
		System.out.println("Error in page");
try {
			
			Connection con = connectToDB();
			//Create Statement
			
			PreparedStatement stmt=con.prepareStatement("select * from signin where userid=? and password=?");
			stmt.setString(1, obj.getUserid());
			stmt.setString(2, obj.getPassword());
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
				return true;
			
			con.close();
		
		// TODO Auto-generated method stub
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}
	
	
}
