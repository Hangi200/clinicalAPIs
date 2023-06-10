package com.stella.clinicform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="child")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Child {

    @Id
    @Column(name = "regno")
    private String regNo;

    @Column(name="cname")
    private String name;

    @Column(name="father_fname")
    private String fatherFirstName;

    @Column(name="father_mname")
    private String fatherMiddleName;

    @Column(name="father_sname")
    private String fatherSurName;

    @Column(name="father_phone")
    private String fatherPhone;

    @Column(name="mother_fname")
    private String motherFirstName;

    @Column(name="mother_mname")
    private String motherMiddleName;

    @Column(name="mother_sname")
    private String motherSurName;

    @Column(name="mother_phone")
    private String motherPhone;

    @Column(name="birth_date", columnDefinition = "DATE")
    private String birthDate;

    private String gender;
    private int weight;

    @Column(name = "birth_place")
    private String birthPlace;
    private String ward;
    private String district;
    private String region;

    @OneToMany(mappedBy = "child")
    private List<Immunization> immunizations;

    @OneToMany(mappedBy = "child")
    private List<ChildGrowthDevelopment> developments;

    //@JsonIgnoreProperties({"child"})
    @OneToMany(mappedBy = "child")
    private List<Medication> medications;


}
