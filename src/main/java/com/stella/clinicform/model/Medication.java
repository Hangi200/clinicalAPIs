package com.stella.clinicform.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="medication")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int week;
    @Column(name = "mouth_drop")
    private int mouthDrop;
    @Column(name = "mouth_pill")
    private int mouthPill;

//    @JsonIgnoreProperties({"medications"})
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Child.class)
    @JoinColumn(name = "regno", referencedColumnName = "regno", nullable = false)
    private Child child;

}
