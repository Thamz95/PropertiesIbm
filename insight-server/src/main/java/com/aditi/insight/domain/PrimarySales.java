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
@Entity(name = "primary_sales")
@NoArgsConstructor
public class PrimarySales extends AbstractEntity{

	@Column(name = "primary_sales_id")
	private Long primarySalesId;
	@Column(name = "name")
	private String name;
	

	public PrimarySales(Long primarySalesId,String name) {
		this.primarySalesId=primarySalesId;
		this.name = name;
	}

}
