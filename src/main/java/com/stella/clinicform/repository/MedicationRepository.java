package com.stella.clinicform.repository;

import com.stella.clinicform.model.Child;
import com.stella.clinicform.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
    Optional<Medication> findByWeekAndChild(int week, Child child);

    List<Medication> findAllByChildOrderByWeek(Child child);

}
