package com.stella.clinicform.controller;

import com.stella.clinicform.model.Child;
import com.stella.clinicform.model.Medication;
import com.stella.clinicform.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ChildController {

    @Autowired
    private ChildRepository childRepository;

    @GetMapping("/child")
    public List<Child> getChildren() {
        return childRepository.findAllByOrderByName();
    }

    @GetMapping("/child/{id}")
    public Child getChild(@PathVariable String id) {
        return childRepository.findById(id).orElse(null);
    }
    @PostMapping("/child")
    public Child addChild(@RequestBody Child child) {
        return childRepository.save(child);
    }

    @GetMapping("/child/name/{name}")
    private List<Child> getChildrenWithName(@PathVariable String name) {
        if (name.equals("")) {
            return childRepository.findAll();
        }
        return childRepository.findAllByNameContaining(name);
    }

    @PutMapping("/child/{id}/medication")
    public Child setMedication(@PathVariable String id, @RequestBody Medication medication) {
        Child child = childRepository.findById(id).orElse(null);
        if (child!=null) {
            child.getMedications().add(medication);
            return childRepository.save(child);
        }
        return null;
    }

}
