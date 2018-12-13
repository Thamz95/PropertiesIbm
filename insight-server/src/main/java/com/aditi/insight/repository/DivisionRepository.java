package com.aditi.insight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditi.insight.domain.Division;

public interface DivisionRepository extends JpaRepository<Division, Long> {

	Division findByName(String name);

	Division findByDivId(Long divId);

}
