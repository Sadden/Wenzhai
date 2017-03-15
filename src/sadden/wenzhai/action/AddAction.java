package sadden.wenzhai.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.Picture;

public class AddAction extends ActionSupport {

	String UserID;
	String PicID;
	String Time;
	String URL;
	String Tag;

		
	/**
	 * from admin_index.jsp tp AddNew.jsp
	 * @return
	 */
	public String ToAdd()
	{
		return "ToAdd";
	}

	/**
	 * add a picture to index
	 */
	public String AddPic()
	{
 
		Picture pic  =new Picture(UserID, PicID, Time, URL, Tag);
		Lucene_fuction luc = new Lucene_fuction();
		luc.AddIndex(pic);
		return "AddSuccess";
	}
	
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String UserID) {
		this.UserID = UserID;
	}

	public String getPicID() {
		return PicID;
	}

	public void setPicID(String PicID) {
		this.PicID = PicID;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String Time) {
		this.Time = Time;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String Tag) {
		this.Tag = Tag;
	}
	
	
	
}
