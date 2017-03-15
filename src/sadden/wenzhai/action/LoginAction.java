package sadden.wenzhai.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	String phone;//User ID
	String password;//User password
	
	
	 public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.print("excute:");
		System.out.println(phone + " " + password);

		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		//if the user is an administer
		if (phone.equals("1") && password.equals("1")) {
			System.out.println("into admin");
			return "admin";
		}
		else {
			// wrong password
//			HttpServletResponse response = ServletActionContext.getResponse();
//			PrintWriter out = response.getWriter();
			System.out.println("ID or password erro");
			String flag = "IDErro";
			request.setAttribute("FromFlag", flag);
			return "IDErro";
		}
	}
	public String Login() {
		// TODO Auto-generated constructor stub
		//print result
		
		 return SUCCESS;
	}

}
