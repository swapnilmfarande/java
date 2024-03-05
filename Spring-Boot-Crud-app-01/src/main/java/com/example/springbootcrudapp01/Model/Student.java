package com.example.springbootcrudapp01.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Persion")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private int StudentId;

    @Column(name = "name")
    private String StudentName;

    @Column(name ="city")
    private String StudentCity;

    @Column(name = "phone")
    private int StudentPhone;
}
