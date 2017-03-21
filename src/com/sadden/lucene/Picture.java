package com.sadden.lucene;

public class Picture {
	private String userId;
	private String picId;
	private String Time;
	private String URL;
	private String Tag;
	private String Content;
	
	public Picture(String UserID, String PicID, String Time, String URL, String Tag)
	{
		this.setUserId(UserID);
		this.setPicId(PicID);
		this.setTag(Tag);
		this.setTime(Time);
		this.setURL(URL);
		this.setContent("empty");
	}

	public void show()
	{
		System.out.println("UserID: "+ userId);
		System.out.println("PicID: "+ picId);
		System.out.println("Time: "+ Time);
		System.out.println("URL: "+ URL);
		System.out.println("Tag: "+ Tag);
		System.out.println("Content: "+ Content);
	}
	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
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
	
	
	
}

