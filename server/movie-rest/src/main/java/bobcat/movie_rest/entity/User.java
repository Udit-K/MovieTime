package bobcat.movie_rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT e FROM User e ORDER BY e.firstName ASC" ),
	@NamedQuery(name = "User.findByEmail", query = "SELECT e FROM User e WHERE e.emailId=:pEmail")
})
public class User {

	
	@Id 
	@GenericGenerator(name= "CustomUUID", strategy ="uuid2" )
	@GeneratedValue(generator = "CustomUUID")
	private String userId;
	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String emailId;
	
	private String password;
	

	public User(String userId, String firstName, String lastName, String emailId, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}
	
	public User() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", password=" + password + "]";
	}
	
	
	
	
	
}
