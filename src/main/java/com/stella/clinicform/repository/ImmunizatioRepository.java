package com.stella.clinicform.repository;

import com.stella.clinicform.model.Child;
import com.stella.clinicform.model.Immunization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImmunizatioRepository extends JpaRepository<Immunization, Integer> {
    Optional<Immunization> findByWeekAndChild(int week, Child child);
    List<Immunization> findAllByChild(Child child);
}
