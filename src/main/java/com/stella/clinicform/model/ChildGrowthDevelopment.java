package com.stella.clinicform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(columnDefinition = "DATE NOT NULL")
    private String arrivalDate;
    @Column(columnDefinition = "DATE NOT NULL")
    private String commingDate;
    private int childWeight;

    @JsonIgnoreProperties({"developments"})
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Child.class)
    @JoinColumn(name = "regno", referencedColumnName = "regno", nullable = false)
    private Child child;

}
