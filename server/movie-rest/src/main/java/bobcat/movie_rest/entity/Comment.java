package bobcat.movie_rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Comment.findComments", query = "SELECT c FROM Comment c where c.video.id = :pVideoId")
})
public class Comment {

	@Id 
	@GenericGenerator(name= "CustomUUID", strategy ="uuid2" )
	@GeneratedValue(generator = "CustomUUID")
	private String commentId;
	
	private String comment;
	private String commentDate;
	private String commentBy;
	private int userRating;
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Video video;

	public Comment(String commentId, String comment, String commentDate, String commentBy, int userRating, User user,
			Video video) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commentDate = commentDate;
		this.commentBy = commentBy;
		this.userRating = userRating;
		this.user = user;
		this.video = video;
	}

	
	public Comment() {
		
	}

	
	public String getCommentId() {
		return commentId;
	}


	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getCommentDate() {
		return commentDate;
	}


	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}


	public String getCommentBy() {
		return commentBy;
	}


	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}


	public int getUserRating() {
		return userRating;
	}


	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Video getVideo() {
		return video;
	}


	public void setVideo(Video video) {
		this.video = video;
	}


	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentDate=" + commentDate
				+ ", commentBy=" + commentBy + ", userRating=" + userRating + ", user=" + user + ", video=" + video
				+ "]";
	}






	
}
