package com.stella.clinicform.controller;

import com.stella.clinicform.model.ChildGrowthDevelopment;
import com.stella.clinicform.repository.ChildRepository;
import com.stella.clinicform.repository.GrowthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/growth")
public class GrowthController {
    @Autowired
    private GrowthRepository growthRepository;

    @GetMapping
    private List<ChildGrowthDevelopment> getChildDevelopment() {
        return growthRepository.findAll();
    }

    @PutMapping("/{id}")
    private ChildGrowthDevelopment updateDevelopment(@PathVariable int id, @RequestBody ChildGrowthDevelopment dev) {
        ChildGrowthDevelopment c = growthRepository.findById(id).orElse(null);
        if (c!=null) {
            dev.setId(c.getId());
            return growthRepository.save(dev);
        }
        return null;
    }

    @PostMapping
    private ChildGrowthDevelopment addGrowthDevelopment(@RequestBody ChildGrowthDevelopment d) {
        return growthRepository.save(d);
    }

}
