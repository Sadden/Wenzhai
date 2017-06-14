package andrew.retrieve.structure;

public class Paper{
	public String title;
	public String authors;
	public String description;
	public String subject;
	public String url;
	public String date;
	public Paper(){
		title="Titleless";
		authors="Anonymous";
		subject="unknown";
		url="no related resource";
	}
	public String getDate(){
		return date;
	}
	public void setDate(String d){
		date=d;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}