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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "lichsutrangthai")
public class LichSuTrangThai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idDtsv;
    private String trangthaiDT;
    @Column(name = "thoigian", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian;

 
    // Getters, setters
  public String getID_DTSV() {
        return idDtsv;
    }

    public void setID_DTSV(String idDtsv) {
        this.idDtsv = idDtsv;
    }
         public String gettrangthaiDT() {
        return trangthaiDT;
    }

    public void settrangthaiDT(String trangthaiDT) {
        this.trangthaiDT = trangthaiDT;
    }
    

    }

