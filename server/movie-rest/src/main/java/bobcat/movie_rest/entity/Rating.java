package bobcat.movie_rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Table
@RequestMapping(path="ratings")
public class Rating {

	@Id
	@GenericGenerator(name="CustomUUID", strategy ="uuid2")
	@GeneratedValue(generator = "CustomUUID")
	private String ratingId;
	
	private float userRating;
	private int userVotes;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Video video;

	public Rating(String ratingId, float userRating, int userVotes, User user, Video video) {
		super();
		this.ratingId = ratingId;
		this.userRating = userRating;
		this.userVotes = userVotes;
		this.user = user;
		this.video = video;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", userRating=" + userRating + ", userVotes=" + userVotes + ", user="
				+ user + ", video=" + video + "]";
	}

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public float getUserRating() {
		return userRating;
	}

	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}

	public int getUserVotes() {
		return userVotes;
	}

	public void setUserVotes(int userVotes) {
		this.userVotes = userVotes;
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
	
	
	
}
