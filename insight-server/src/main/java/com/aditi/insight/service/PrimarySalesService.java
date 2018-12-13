package com.aditi.insight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.insight.domain.PrimarySales;
import com.aditi.insight.repository.PrimarySalesRepository;

@Service
public class PrimarySalesService extends AbstractService<PrimarySales, Long> {

	private PrimarySalesRepository primarySalesRepository;

	@Autowired
	public PrimarySalesService(PrimarySalesRepository primarySalesRepository) {
		super(primarySalesRepository);
		this.primarySalesRepository = primarySalesRepository;
	}

	public PrimarySales findByName(String name) {
		return primarySalesRepository.findByName(name);
	}

	public PrimarySales findByPrimarySalesId(Long psId) {
		return primarySalesRepository.findByPrimarySalesId(psId);
	}
}
