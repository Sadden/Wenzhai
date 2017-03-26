package com.sadden.lucene;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Picture {
	private String userId;
	private String picId;
	private String Time;
	private String URL;
	private String Tag;
	private String Content;
	
	/**
	 * normal constructor
	 * @param UserID
	 * @param PicID
	 * @param Time
	 * @param URL
	 * @param Tag
	 */
	public Picture(String UserID, String PicID, String Time, String URL, String Tag)
	{
		this.setUserId(UserID);
		this.setPicId(PicID);
		this.setTag(Tag);
		this.setTime(Time);
		this.setURL(URL);
		this.setContent("empty");
	}
	/**
	 * simple constructor
	 */
	public Picture()
	{
		this.setUserId("Unknow");
		this.setPicId("Unknow");
		this.setTag("Unknow");
		this.setTime("Unknow");
		this.setURL("Unknow");
		this.setContent("empty");
	}
	/**
	 * advanced constructor
	 */
	public Picture(String UserID, String URL, String Tag )
	{
		this.setUserId(UserID);
		this.setTag(Tag);
		this.setURL(URL);
		this.setContent("empty");
		String PicID = MakePicID();
		this.setPicId(PicID);
		String Time = MakeTime();
		this.setTime(Time);
		
	}
	
	
	
	
	
	
	/**
	 * show all characters of a picture
	 */
	public void show()
	{
		System.out.println("UserID: "+ userId);
		System.out.println("PicID: "+ picId);
		System.out.println("Time: "+ Time);
		System.out.println("URL: "+ URL);
		System.out.println("Tag: "+ Tag);
		System.out.println("Content: "+ Content);
	}
	
	/**
	 * generate a unique PicID
	 * @return PicID
	 */
	public String MakePicID()
	{
		
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND); 
		String PicID = userId+year+month+date+hour+minute+second;
		return PicID;
	}
	
	
	public String MakeTime()
	{
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND); 
		String Time = year+"/"+month+"/"+date+"/"+hour+"/"+minute;
		return Time;
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

