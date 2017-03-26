package sadden.wenzhai.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.Picture;

public class UpdateAction extends ActionSupport {

	
	String PicID;
	String UserID;
	String Time;
	String Tag;
	String Content;
	String URL;
	
	public String ToUpdate()
	{
		PicID=PicID.replaceAll("/","");
		UserID=UserID.replaceAll("/","");
		Time=Time.replaceAll("/","");
		Tag=Tag.replaceAll("/","");
		Content=Content.replaceAll("/","");
		URL=URL.replaceAll("/","");
		
		System.out.println("to update: PicID="+PicID);
		Picture pic = new Picture(UserID, PicID, Time, URL, Tag);
		pic.setContent(Content);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("Picture", pic);
		return "ToUpdate";
	}
	
	public String Update()
	{
		Lucene_fuction luc =new Lucene_fuction();
		PicID=PicID.replaceAll("/","");
		UserID=UserID.replaceAll("/","");
		Time=Time.replaceAll("/","");
		Tag=Tag.replaceAll("/","");
		Content=Content.replaceAll("/","");
		URL=URL.replaceAll("/","");
		Picture pic =new Picture(UserID, PicID, Time, URL, Tag);
		pic.setContent(Content);
		System.out.println("******************now update****************");
		pic.show();
		luc.update_PicID(PicID, pic);
		
		return "UpdateOK";
	}
	
	
	
	
	public String getPicID() {
		return PicID;
	}
	public void setPicID(String picID) {
		PicID = picID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getTag() {
		return Tag;
	}
	
	public void setTag(String tag) {
		Tag = tag;
	}





	public String getContent() {
		return Content;
	}





	public void setContent(String content) {
		Content = content;
	}





	public String getURL() {
		return URL;
	}





	public void setURL(String uRL) {
		URL = uRL;
	}
	
}
