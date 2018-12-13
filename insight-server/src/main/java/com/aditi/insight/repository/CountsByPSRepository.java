package com.aditi.insight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.insight.domain.CountsByPrimarySales;

public interface CountsByPSRepository extends JpaRepository<CountsByPrimarySales, Long>{

}
