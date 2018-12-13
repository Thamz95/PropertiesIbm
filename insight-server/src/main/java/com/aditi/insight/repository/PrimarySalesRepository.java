package com.aditi.insight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.insight.domain.Division;
import com.aditi.insight.domain.PrimarySales;

public interface PrimarySalesRepository extends JpaRepository<PrimarySales, Long> {

	PrimarySales findByName(String name);

	PrimarySales findByPrimarySalesId(Long psId);

}
