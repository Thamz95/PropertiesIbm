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
@Entity(name = "primaryrecruiter")
@NoArgsConstructor
public class PrimaryRecruiter extends AbstractEntity{

	@Column(name = "name")
	private String name;
	

	public PrimaryRecruiter(String name) {
		this.name = name;
	}

}
