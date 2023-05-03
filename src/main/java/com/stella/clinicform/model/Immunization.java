package com.stella.clinicform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String bcg;
    private String opv;
    private String ipv;
    private String dtp;
    private String pcv13;
    private String rotarix;
    private String rubella;
    @Column(name="birth_date", columnDefinition = "DATE")
    private String date;
    private int week;

}
