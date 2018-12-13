package com.aditi.insight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.insight.domain.CountsByPrimarySales;
import com.aditi.insight.repository.CountsByPSRepository;

@Service
public class CountsByPSService extends AbstractService<CountsByPrimarySales, Long> {

	private CountsByPSRepository countsByPSRepository;

	@Autowired
	public CountsByPSService(CountsByPSRepository countsByPSRepository) {
		super(countsByPSRepository);
		this.countsByPSRepository = countsByPSRepository;
	}
}
