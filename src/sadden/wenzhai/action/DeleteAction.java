package sadden.wenzhai.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;

public class DeleteAction extends ActionSupport {

	String PicID;
	String UserID;
	
	/**
	 * delete the index with the picId
	 * @return to admin_Index.jsp
	 */
	public String DeleteIndex()
	{

		PicID=PicID.replaceAll("/","");
		UserID=UserID.replaceAll("/","");
		System.out.println("delete Id:"+PicID);
		
		Lucene_fuction luc = new Lucene_fuction();
		luc.delete_PicID(PicID);
		
		return "DeleteOK";
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
	
}
