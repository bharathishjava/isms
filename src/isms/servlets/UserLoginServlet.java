package isms.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import isms.hibernate.models.User;
import isms.hibernate.utils.HibernateUtils;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/oxford_login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("oxford_home.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("oxford_user");
		String passWord = request.getParameter("user_password");
		if(userName.equals("bharat")&&passWord.equals("123")) {
			Session hbSession = HibernateUtils.getSessionFactory().openSession();
			hbSession.beginTransaction();
			User user = hbSession.get(User.class, userName);
			if(user.getUserType().equals(request.getParameter("user_type"))) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				request.getRequestDispatcher("homepage.jsp").forward(request, response);
			} else {
				response.sendRedirect("oxford_home.html");				
			}
		} else {
			response.sendRedirect("oxford_home.html");
		}
	}

}
