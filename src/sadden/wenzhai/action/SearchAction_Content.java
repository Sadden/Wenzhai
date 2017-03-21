package sadden.wenzhai.action;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.Picture;

public class SearchAction_Content extends ActionSupport {
	String Content;
	String flag;// in order to control jsp
	Lucene_fuction luc;//for manipulate lucene function
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Content:" + Content);
		luc = new Lucene_fuction();
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		// if the tag is empty
		
			ArrayList<Picture> PicList = new ArrayList<>();
			PicList = luc.queryIndex_Content(Content);
			request.setAttribute("PictureList", PicList);
			return "Content_Result";
	}
	
	
	
	
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
}
