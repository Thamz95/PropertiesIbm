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
@Entity(name = "division")
@NoArgsConstructor
public class Division extends AbstractEntity{

	@Column(name = "divId")
	private Long divId;
	@Column(name = "name")
	private String name;
	

	public Division(Long divId,String name) {
		this.divId=divId;
		this.name = name;
	}

}
