package com.aditi.insight.dto.models;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString()
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 2742926091788978851L;

	private long id;
	
	private String name;

	private String email;

	private String password;
	
	private String mobile;
	
	private Boolean joinedStatus;
	
	private String userRole;
	
}
