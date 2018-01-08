package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Items;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("通りました");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3305/kindergartenDB";
		String user = "root";
		String pass = "";
		ArrayList<Items> items = new ArrayList<Items>();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("接続成功");
			ps = conn.prepareStatement("SELECT * FROM item");
			rs = ps.executeQuery();
			while (rs.next()){
				Items item = new Items();
				item.setItem_id(rs.getString("item_id"));
				item.setItem_name(rs.getString("item_name"));
				item.setPrice(rs.getInt("price"));
				item.setQuality(rs.getString("quality"));
				item.setRank(rs.getString("rank"));
				items.add(item);
			}
		}catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
			e.printStackTrace();
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
			} //覚えてください。
		}
		request.setAttribute("items", items);
		RequestDispatcher rd = request.getRequestDispatcher("itemList.jsp");
		rd.forward(request,response);
	}

}