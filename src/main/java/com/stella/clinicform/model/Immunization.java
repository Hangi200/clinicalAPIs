package com.stella.clinicform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="immunization")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Immunization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "DATE")
    private String bcg;
    @Column(columnDefinition = "DATE")
    private String opv;
    @Column(columnDefinition = "DATE")
    private String ipv;
    @Column(columnDefinition = "DATE")
    private String dtp;
    @Column(columnDefinition = "DATE")
    private String pcv13;
    @Column(columnDefinition = "DATE")
    private String rotarix;
    @Column(columnDefinition = "DATE")
    private String rubella;
    private int week;

    @JsonIgnoreProperties({"immunizations"})
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Child.class)
    @JoinColumn(name = "regno", referencedColumnName = "regno", nullable = false)
    private Child child;

}
