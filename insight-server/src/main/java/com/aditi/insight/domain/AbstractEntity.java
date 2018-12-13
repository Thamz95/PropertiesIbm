package com.aditi.insight.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import com.aditi.insight.repository.event.AbstractEntityListener;
import com.aditi.insight.utils.DateDeSerializer;
import com.aditi.insight.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AbstractEntityListener.class)
public abstract class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
	
	@Column(name = "creation_date")
	protected Date creationDate;

	@Column(name = "modification_date")
	protected Date modificationDate;
	
	
	@JsonSerialize(using = DateSerializer.class)
	public Date getModificationDate() {
		return modificationDate;
	}

	@JsonDeserialize(using = DateDeSerializer.class)
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@JsonSerialize(using = DateSerializer.class)
	public Date getCreationDate() {
		return creationDate;
	}

	@JsonDeserialize(using = DateDeSerializer.class)
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/*// status =1,2,3,4,5,6...9
	@Column(name = "status")
	protected int status ; 
	
	// filled information has verified or not
	@Column(name = "verified")
	protected Boolean verified = false;*/
}