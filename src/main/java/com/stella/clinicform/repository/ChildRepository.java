package com.stella.clinicform.repository;

import com.stella.clinicform.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, String> {

    List<Child> findAllByOrderByName();

    List<Child> findAllByNameContaining(String text);

}
