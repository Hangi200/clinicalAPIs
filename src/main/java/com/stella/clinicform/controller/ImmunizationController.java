package com.stella.clinicform.controller;

import com.stella.clinicform.model.Child;
import com.stella.clinicform.model.Immunization;
import com.stella.clinicform.repository.ChildRepository;
import com.stella.clinicform.repository.ImmunizatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/immunization")
public class ImmunizationController {
    @Autowired
    private ImmunizatioRepository repo;

    @Autowired
    private ChildRepository childRepository;

    @GetMapping("/child/{cid}")
    public List<Immunization> getImmunizationList(@PathVariable String cid) {
        Child child = childRepository.findById(cid).orElse(null);
        if (child!=null) {
            return repo.findAllByChild(child);
        }
        return new ArrayList<>();
    }

    @PostMapping
    private Immunization addImmunization(@RequestBody Immunization immunization) {
        Optional<Immunization> foundImmunization = repo.findByWeekAndChild(immunization.getWeek(), immunization.getChild());
        if (foundImmunization.isPresent()) {
            return null;
        }
        return repo.save(immunization);
    }

    @PutMapping("/{id}")
    private Immunization updateImmunization(@PathVariable int id, @RequestBody Immunization immunization) {
        Immunization i = repo.findById(id).orElse(null);
        if (i!=null) {
            immunization.setId(i.getId());
            return repo.save(immunization);
        }
        return null;
    }

    @DeleteMapping
    private List<Immunization> delete(@PathVariable int id) {
        Immunization i = repo.findById(id).orElse(null);
        if (i!=null) {
            repo.delete(i);
            return repo.findAll();
        }
        return null;
    }

}
