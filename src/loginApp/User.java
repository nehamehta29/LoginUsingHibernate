package loginApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@Column(name = "USER_ID")
	
	//@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name = "USER_NAME")
	String username;
	
	@Column(name = "USER_PASS")
	String password;
	
	@Column(name = "USER_EMAIL")
	String email;
	
	
	public User(int id,String username, String password, String email) {
		this.id =id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
