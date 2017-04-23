package sadden.wenzhai.action;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.Picture;

public class SearchAction_UserID extends ActionSupport {
	String UserID;
	String flag;// in order to control jsp
	Lucene_fuction luc;// for manipulate lucene function

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();

		String Sol_ID = (String)request.getSession().getAttribute("sol_id"); 
		

		if(Sol_ID==null)
		{
			System.out.println("empty session");
			Sol_ID ="Sadden";
		}
		
		
		//for test I set UserID as sadden
		UserID= Sol_ID;
		System.out.println("Search UserID:" + UserID);
		luc = new Lucene_fuction();
		ArrayList<Picture> PicList = new ArrayList<>();
		PicList = luc.queryIndex_UserID(UserID);
		request.setAttribute("PictureList", PicList);
		return "UserID_Result";
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

}
