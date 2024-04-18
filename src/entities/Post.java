package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {

	private LocalDateTime moment;
	private String title;
	private String content;
	private Integer likes;
	private List <Comment> comments = new ArrayList<>();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
	
	public Post (LocalDateTime moment, String title, String content, int likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}
	
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		
		string.append(this.title + "\n");
		string.append(this.likes);
		string.append(" Likes - ");
		string.append(formatter.format(moment) + "\n");
		string.append(this.getContext()+"\n");
		string.append("Comments:"+"\n");
		
		for (Comment c : comments) {
			string.append(c.getText()+"\n");
		}
		
		return string.toString();
	}
	
	public LocalDateTime getMoment() {
		return moment;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	
	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return content;
	}
	public void setContext(String context) {
		this.content = context;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	
	
}
