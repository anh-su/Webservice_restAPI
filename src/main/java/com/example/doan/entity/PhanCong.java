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
@Table(name = "phancong")
public class PhanCong {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
     @Column(name = "ID_Phancong")
     private Long idphancong;
@Column(name = "ID_DTSV")
    private String idDtsv;
    private String madetai;

    @ManyToOne
    @JoinColumn(name = "ID_Giangvien")
    private GiangVien idgiangvien;

    private String hoten;

    // getters, setters
    
    // getters, setters
     public String getID_DTSV() {
        return idDtsv;
    }

    public String getMadetai() {
        return madetai;
    }

    public String getHoten() {
        return hoten;
    }
public GiangVien getID_Giangvien() {
        return idgiangvien;
    }
   
    // Setters
    public void setID_DTSV(String iddtsv) {
        this.idDtsv = iddtsv;
    }

    public void setMadetai(String madetai) {
        this.madetai = madetai;
    }
     public void setID_Giangvien(GiangVien idgiangvien) {
        this.idgiangvien = idgiangvien;
    }
     public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
