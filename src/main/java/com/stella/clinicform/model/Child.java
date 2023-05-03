package com.stella.clinicform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name="father_name")
    private String fatherName;
    @Column(name="mother_name")
    private String motherName;
    @Column(name="birth_date", columnDefinition = "DATE")
    private String birthDate;
    private String gender;
    private String address;
    private int weight;
    @Column(name="phone_no")
    private String phoneNo;

}
