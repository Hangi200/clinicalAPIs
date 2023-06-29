package com.stella.clinicform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="growth_development")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChildGrowthDevelopment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "DATE")
    private String arrivalDate;
    @Column(columnDefinition = "DATE")
    private String commingDate;
    private double childWeight;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Child.class)
    @JoinColumn(name = "regno", referencedColumnName = "regno", nullable = false)
    private Child child;

}
