/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "nhom")
public class ThanhVienNhom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_dtsv")
    private String idDtsv;

    @Column(name = "id_sinhvien")
    private String idSinhvien;

    private String hoten;

    private String tenkhoa;
    



    // Getter và Setter cho id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter và Setter cho idDtsv
    public String getIdDtsv() {
        return idDtsv;
    }

    public void setIdDtsv(String idDtsv) {
        this.idDtsv = idDtsv;
    }

    // Getter và Setter cho idSinhvien
    public String getIdSinhvien() {
        return idSinhvien;
    }

    public void setIdSinhvien(String idSinhvien) {
        this.idSinhvien = idSinhvien;
    }

    // Getter và Setter cho hoten
    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    // Getter và Setter cho tenkhoa
    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }
}
