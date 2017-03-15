package sadden.wenzhai.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.Picture;


public class SearchAction extends ActionSupport {

	String tag;
	String flag;// in order to control jsp
	Lucene_fuction luc;//for manipulate lucene function
	public SearchAction()
	{
		
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("tag:" + tag);
		luc = new Lucene_fuction();
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		request.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		// if the tag is empty
		if (tag.equals("0")) {
			
			flag = "NoTag";
			System.out.println("tag is 0, return to IDErro");
			request.setAttribute("FromFlag", flag);
			return "NoTag";
			
		} else {
			ArrayList<Picture> PicList = new ArrayList<>();
			PicList = luc.queryIndex_Tag(tag);
			request.setAttribute("PictureList", PicList);
			return "Result";
		}

	}

}
