package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import exception.DatabaseException;
import exception.LoginFailException;

public class Login {
	private User user;

	public Login(String userName,String password) throws DatabaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3305/kindergartenDB";
		String user = "root";
		String pass = "";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("接続OK");
			ps = conn.prepareStatement("SELECT * FROM users WHERE name = ? AND pass = ?");
			ps.setString(1,userName);
			ps.setString(2,password);
			rs = ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("pass"));
				System.out.println("認証OK");
				this.user = new User();
				this.user.setId(rs.getInt("userid"));
				this.user.setUserName(rs.getString("name"));
				this.user.setPassword(rs.getString("pass"));
			}
		}catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
			e.printStackTrace();
			throw new DatabaseException();
		}finally{
			if (rs != null){
				try{
					rs.close();
				}catch(SQLException e){
				}
			}
			if (ps != null){
				try{
					ps.close();
				}catch(SQLException e){
				}
			}
			if (conn != null){
				try{
					conn.close();
				}catch(SQLException e){
				}
			}
		}
	}

	public User getUser() throws LoginFailException {
		if(this.user == null) {
			throw new LoginFailException();
		}
		return this.user;
	}
}