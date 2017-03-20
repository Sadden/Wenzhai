package sadden.wenzhai.action;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.Picture;

public class AddAction extends ActionSupport {

	String UserID;
	String PicID;
	String Time;
	String URL;
	String Tag;
	private File image; // �ϴ����ļ�
	private String imageFileName; // �ļ�����
	private String imageContentType; // �ļ�����
		
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
	 * @throws Exception 
	 */
	public String AddPic() throws Exception
	{
		//upload path
		String realpath = "G:\\Workspace\\WenZhai\\images";
		UploadPicture(realpath);
		URL = realpath+"\\"+imageFileName;
		System.out.println(URL);
		Picture pic  =new Picture(UserID, PicID, Time, URL, Tag);
		Lucene_fuction luc = new Lucene_fuction();
		luc.AddIndex(pic);
		return "AddSuccess";
	}
	
	/**
	 * upload a picture in G:/workspace path
	 * @throws Exception
	 */
	public void UploadPicture(String realpath )throws Exception
	{
		//	String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		
		System.out.println("realpath: " + realpath);
		if (image != null) {
			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�");
		}
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
	
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
}
