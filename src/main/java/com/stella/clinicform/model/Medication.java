package com.stella.clinicform.model;

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

}
