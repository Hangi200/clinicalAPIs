package com.stella.clinicform.controller;

import com.stella.clinicform.model.Child;
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
        return childRepository.findAll();
    }

    @GetMapping("/child/{id}")
    public Child getChild(@PathVariable int id) {
        return childRepository.findById(id).orElse(null);
    }

    @PostMapping("/child")
    public Child addChild(@RequestBody Child child) {
        return childRepository.save(child);
    }

}
