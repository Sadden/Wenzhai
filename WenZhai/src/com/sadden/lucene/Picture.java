package com.sadden.lucene;

public class Picture {
	private String userId;
	private String picId;
	private String Time;
	private String URL;
	private String Tag;
	
	public Picture(String UserID, String PicID, String Time, String URL, String Tag)
	{
		this.setUserId(UserID);
		this.setPicId(PicID);
		this.setTag(Tag);
		this.setTime(Time);
		this.setURL(URL);
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
	
}

