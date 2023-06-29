package com.stella.clinicform.repository;

import com.stella.clinicform.model.ChildGrowthDevelopment;
import com.stella.clinicform.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GrowthRepository extends JpaRepository<ChildGrowthDevelopment, Integer> {
	List<ChildGrowthDevelopment> findAllByChild(Child child);
}
