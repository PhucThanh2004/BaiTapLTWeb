package vn.iotstar.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.impl.UserServiceImpl;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = { "/forgotpass" })
public class ForgotpasswordController extends HttpServlet {
	
	

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpass.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		UserServiceImpl users = new UserServiceImpl();
		UserModel user = users.findByUserName(username);

		String alertMsg = "";
		
		if (user.getEmail().equals(email) && user.getUsername().equals(username)) {
			alertMsg = "Mật khẩu của bạn là: " + user.getPassword();
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/forgotpass.jsp").forward(req, resp);
			
			
		}
		else {
			
			alertMsg = "Username hoặc Email không tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgotpass.jsp").forward(req, resp);
			
			
		}				
	}
	

}
