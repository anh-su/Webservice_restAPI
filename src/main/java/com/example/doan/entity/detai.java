package com.example.doan.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detai")
public class detai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 
    @Column(name = "Tendetai")
    private String Tendetai;
}
