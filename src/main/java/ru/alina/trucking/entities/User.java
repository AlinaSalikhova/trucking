package ru.alina.trucking.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	@Id
	private String username;
	
	private String password;
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	private Boolean enabled;
	
	private User() {}
	
	public User(String username, String password, Boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
}
