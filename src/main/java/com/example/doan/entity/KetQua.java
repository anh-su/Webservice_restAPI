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
import jakarta.persistence.Table;

/**
 *
 * @author ADMIN
 */
    @Entity
@Table(name = "ketqua")
public class KetQua {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Ketqua")
    private Long id;

    private String idDtsv;
    private String hoten;
    private Float diem;
    private String nhanxet;

    // Getters & Setters

     public Long getid() {
        return id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    
     public String getID_DTSV() {
        return idDtsv;
    }

    public void setID_DTSV(String idDtsv) {
        this.idDtsv = idDtsv;
    }
         public String gethoten() {
        return hoten;
    }

    public void sethoten(String hoten) {
        this.hoten = hoten;
    }
    
    
     public Float getdiem() {
        return diem;
    }

    public void setdiem(Float diem) {
        this.diem = diem;
    }
    
     public String getnhanxet() {
        return nhanxet;
    }

    public void setnhanxet(String nhanxet) {
        this.nhanxet = nhanxet;
    }
    }

