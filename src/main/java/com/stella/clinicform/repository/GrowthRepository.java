package com.stella.clinicform.repository;

import com.stella.clinicform.model.ChildGrowthDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrowthRepository extends JpaRepository<ChildGrowthDevelopment, Integer> {
}
