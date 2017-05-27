package sadden.wenzhai.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Picture;

import andrew.retrieve.function.AnalyseFunction;
import andrew.retrieve.structure.Paper;

public class RetrieveAction extends ActionSupport{
	
	public String Content;
	
	
	
	
	
	public String FindPaper()
	{
		
		AnalyseFunction fun=new AnalyseFunction();
		List<Paper> list=fun.KddSearchTitleCode(Content, 300);

		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setAttribute("ResultList", list);
		return "FindOK";
	}





	public String getContent() {
		return Content;
	}





	public void setContent(String content) {
		Content = content;
	}

}
