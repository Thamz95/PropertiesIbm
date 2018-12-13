package com.aditi.insight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.insight.domain.Division;
import com.aditi.insight.repository.DivisionRepository;

@Service
public class DivisionService extends AbstractService<Division, Long> {

	private DivisionRepository divisionRepository;

	@Autowired
	public DivisionService(DivisionRepository divisionRepository) {
		super(divisionRepository);
		this.divisionRepository = divisionRepository;
	}

	public Division findByName(String name) {
		return divisionRepository.findByName(name);
	}

	public Division findByDivId(Long divId) {
		return divisionRepository.findByDivId(divId);
	}
}
