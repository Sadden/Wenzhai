package sadden.wenzhai.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sadden.lucene.Lucene_fuction;
import com.sadden.lucene.OCR_function;
import com.sadden.lucene.Picture;

public class AddAction extends ActionSupport {

	String UserID;
	String PicID;
	String Time;
	String URL;
	String Tag;
	private File image; // upload picture file
	private String imageFileName; 
	private String imageContentType; 
		
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
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		request.getSession();
		
		String path = ServletActionContext.getServletContext().getRealPath("/images");
//		String path = request.getServletContext().getContextPath()+"/images";
		UploadPicture(path);
		URL = imageFileName;
		System.out.println("**************URL:"+URL);
		Picture pic  =new Picture(UserID, URL, Tag);
		
		String content = DoOCR(path+"/"+URL);
		content = WashOutCH(content);
		pic.setContent(content);
		
		Lucene_fuction luc = new Lucene_fuction();
		luc.AddIndex(pic);
		
		request.setAttribute("ViewPicture", pic);
		
		return "AddSuccess";
	}
	
	/**
	 * use OCR_fucntion to read picture	
	 * @param pic
	 * @return read result
	 */
	public String DoOCR(String realpath)
	{
		String Result = null;
		OCR_function ocr = new OCR_function();
		Result = ocr.ReadPicture(realpath, 0);		
		return Result;
	}
	
	/**
	 * this function for wash out the chinese character in the ocr content
	 * @param OcrResult 
	 * @return FinResult
	 */
	public String WashOutCH(String OcrResult)
	{
		String FinResult = null;
	    int n = 0;
	    for(int i = 0; i < OcrResult.length(); i++) {
	        n = (int)OcrResult.charAt(i);
	        if(19968 <= n && n <40869) {
	        	//the nth character in string is Chinese
	            OcrResult=OcrResult.substring(0, i)+OcrResult.substring(i+1);
	            i--;
	        }
	    }
		FinResult = OcrResult;		
		return FinResult;
	}
	
	/**
	 * upload a picture in G:/workspace path
	 * @throws Exception
	 */
	public void UploadPicture(String realpath )throws Exception
	{
			
		
		System.out.println("path: " + realpath);
		if (image != null) {
			File savefile = new File(new File(realpath), imageFileName);
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);
			ActionContext.getContext().put("message", "upload successfully");
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
