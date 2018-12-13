package com.aditi.insight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.insight.domain.CountsByDivision;
import com.aditi.insight.repository.CountsByDivisionRepository;

@Service
public class CountsByDivisionService extends AbstractService<CountsByDivision, Long> {

	private CountsByDivisionRepository countsByDivRepository;

	@Autowired
	public CountsByDivisionService(CountsByDivisionRepository countsByDivRepository) {
		super(countsByDivRepository);
		this.countsByDivRepository = countsByDivRepository;
	}
}
