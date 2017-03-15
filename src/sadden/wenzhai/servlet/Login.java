package sadden.wenzhai.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

public class Login extends HttpServlet{
	
	String phone;//User ID
	String password;//User password
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.doPost(request, response);
	}protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("phone") != null) {
			phone = (String) request.getParameter("phone");
		}
		if (request.getParameter("password") != null) {
			password = (String) request.getParameter("password");
		}
		
		//print result
		System.out.println(phone + " " + password);
		
		//if the user is an administer
		if (phone.equals("sadden") && password.equals("123456")) {
			System.out.println("into admin");
			
			response.sendRedirect("/WenZhai/admin_index.jsp");
		}

//		else if (dbfunc.IsUserExist(phone)) {
//			System.out.println("user exist");
//
//			if (dbfunc.CheckLogin(phone, password)) {
//				// login successfully
//				user = new User();
//				user.setPhone(phone);
//				user.setPassword(password);
//				user.setAddress(dbfunc.GetUserAdd(phone));
//				user.setUsername(dbfunc.GetUsername(phone));
//
//				System.out.println(user.getUsername());
//				System.out.println(user.getPhone());
//				System.out.println(user.getPassword());
//				System.out.println(user.getAddress());
//
//				sess = request.getSession();
//				sess.setAttribute("User", user);
//
//				response.sendRedirect("/Weapay/index.jsp");
//
//			} 
		else {
				// wrong password
				PrintWriter out = response.getWriter();
				out.println("<h1>password or user name is incorrect!</h1>");
				out.println("<a href=" + "/WenZhai/login.jsp" + ">Return to Login</a>");

			}
		} 
//	else {
//			// goto register page
//			response.sendRedirect("/Weapay/register.html");
//		}

	}
	

