package com.stella.clinicform.controller;

import com.stella.clinicform.model.Child;
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

    @Autowired
    private ChildRepository childRepository;

    @GetMapping("/child/{cid}")
    private List<ChildGrowthDevelopment> getChildDevelopment(@PathVariable String cid) {
    	Child child = childRepository.findById(cid).orElse(null);
        if (child!=null) {
            return growthRepository.findAllByChild(child);
        }
        return null;
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

    @PostMapping("/child/{cid}")
    private ChildGrowthDevelopment addGrowthDevelopment(@PathVariable String cid,  @RequestBody ChildGrowthDevelopment d) {
        Child child = childRepository.findById(cid).orElse(null);
        if (child!=null) {
            d.setChild(child);
            return growthRepository.save(d);
        }

        return null;
    }

}
