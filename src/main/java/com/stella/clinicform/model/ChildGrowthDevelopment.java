package com.stella.clinicform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String arrivalDate;
    private String commingDate;
    private String childWeight;

}
