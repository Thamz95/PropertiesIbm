package com.aditi.insight.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString()
@Entity(name = "user")
@NoArgsConstructor
public class User extends AbstractEntity{

	@Column(name = "name")
	private String name;
	
	@Column(name = "email" , unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	//optional but unique
	@Column(name = "mobile" )
	private String mobile;
	
	@Column(name = "joined_status")
	private Boolean joinedStatus;
	
	@Column(name = "role")
	private String userRole;

	public User(String name, String email, String password, String mobile) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}

}
