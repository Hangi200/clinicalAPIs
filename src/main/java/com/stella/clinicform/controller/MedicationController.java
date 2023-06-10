package com.stella.clinicform.controller;

import com.stella.clinicform.model.Child;
import com.stella.clinicform.model.Medication;
import com.stella.clinicform.repository.ChildRepository;
import com.stella.clinicform.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/medication")
public class MedicationController {
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private ChildRepository childRepository;

    @PostMapping
    private Medication addMedication(@RequestBody Medication medication) {
        return medicationRepository.save(medication);
    }

    @PostMapping("/{cid}")
    private Child putMedication(@PathVariable String cid, @RequestBody Medication medication) {
        Child child = childRepository.findById(cid).orElse(null);
        if (child!=null) {
            Optional<Medication> medicationFound = medicationRepository.findByWeekAndChild(medication.getWeek(), child);
            if (medicationFound.isPresent()){
                return null;
            }
            medication.setChild(child);
            medicationRepository.save(medication);
            return child;
        }
        return null;
    }

    @PutMapping("/{id}")
    private Medication updateMedication(@PathVariable int id, @RequestBody Medication medication) {
        Medication m = medicationRepository.findById(id).orElse(null);
        medication.setId(m.getId());
        return medicationRepository.save(medication);
    }

    @DeleteMapping("/{id}")
    private List<Medication> deleteMedication(@PathVariable int id) {
        Medication medication = medicationRepository.findById(id).orElse(null);
        if (medication!=null) {
            medicationRepository.delete(medication);
            return medicationRepository.findAll();
        }
        return null;
    }

    @GetMapping
    private List<Medication> getMedications() {
        return medicationRepository.findAll();
    }

    @GetMapping("/child/{cid}")
    List<Medication> getAllByChild(@PathVariable String cid) {
        Child child = childRepository.findById(cid).orElse(null);
        if (child!=null) {
            return medicationRepository.findAllByChildOrderByWeek(child);
        }
        return new ArrayList<>();
    }
}
