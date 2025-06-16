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
@Table(name = "detaisinhvien")
public class NhomSVDKDT {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY) // hoặc AUTO nếu dùng H2, PostgreSQL
    private Long id;
     @Column(name = "ID_DTSV", nullable = false)
    private String iddtsv;

    private String Tendetai;
    private String ID_Sinhvien;
    private String Hoten;
    private String Tenkhoa;
    private String Hotengv;
    private String Mota;
    private String TrangthaiDT;
    
    
    // GETTER & SETTER cho tất cả các trường



    public String getID_DTSV() {
        return iddtsv;
    }

    public void setID_DTSV(String iddtsv) {
        this.iddtsv = iddtsv;
    }

    public String getTendetai() {
        return Tendetai;
    }

    public void setTendetai(String Tendetai) {
        this.Tendetai = Tendetai;
    }

    public String getID_Sinhvien() {
        return ID_Sinhvien;
    }

    public void setID_Sinhvien(String ID_Sinhvien) {
        this.ID_Sinhvien = ID_Sinhvien;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getTenkhoa() {
        return Tenkhoa;
    }

    public void setTenkhoa(String Tenkhoa) {
        this.Tenkhoa = Tenkhoa;
    }
 

    public String getHotengv() {
        return Hotengv;
    }

    public void setHotengv(String Hotengv) {
        this.Hotengv = Hotengv;
    }
         public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }
         public String getTrangthaiDT() {
        return TrangthaiDT;
    }

    public void setTrangthaiDT(String TrangthaiDT) {
        this.TrangthaiDT = TrangthaiDT;
    }
}
