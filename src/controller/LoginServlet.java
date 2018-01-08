package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import exception.DatabaseException;
import exception.LoginFailException;
import model.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		try {
			Login login = new Login(userName, password);
			User user = login.getUser();

			HttpSession session = request.getSession();
			session.setAttribute("name", user.getUserName());
			session.setAttribute("userId", user.getId());
			session.setAttribute("loginFlag", true);
			RequestDispatcher rd = request.getRequestDispatcher("SearchServlet");
			rd.forward(request,response);
		} catch(DatabaseException | LoginFailException e) {
			request.setAttribute("message", "ログイン失敗");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
		}


	}

}
