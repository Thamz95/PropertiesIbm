package com.aditi.insight.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString()
@Entity(name = "counts_by_division")
@NoArgsConstructor
public class CountsByDivision extends AbstractEntity{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "division_id", nullable = false)
	private Division division;	
	
	@Column(name="new_positions")
	private Integer newPositions;
	
	@Column(name="hires_count")
	private Integer hiresCount;
	
	@Column(name="open_positions")
	private Integer openPositions;
	
	@Column(name="filled_positions")
	private Integer filledPositions;
	
	@Column(name="interview_activities")
	private Integer interviewActivities;
	
	@Column(name="aging_of_positions")
	private Integer agingOfPositions;
	
	@Column(name="ended_assignments")
	private Integer endedAssignments;

	public CountsByDivision(Division division, Integer newPositions, Integer hiresCount, Integer openPositions,
			Integer filledPositions, Integer interviewActivities, Integer agingOfPositions, Integer endedAssignments) {
		super();
		this.division = division;
		this.newPositions = newPositions;
		this.hiresCount = hiresCount;
		this.openPositions = openPositions;
		this.filledPositions = filledPositions;
		this.interviewActivities = interviewActivities;
		this.agingOfPositions = agingOfPositions;
		this.endedAssignments = endedAssignments;
	}	
	
	
	

}
