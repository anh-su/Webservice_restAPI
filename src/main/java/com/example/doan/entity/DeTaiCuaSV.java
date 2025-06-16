/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ADMIN
 */


@Entity
@Table(name = "detaisinhvien")
public class DeTaiCuaSV {

    @Id
    @Column(name = "ID_DTSV")
    private String idDtsv;

    @Column(name = "Tendetai")
    private String tenDetai;

    @Column(name = "Hotengv")
    private String hotengv;

    @Column(name = "TrangthaiDT")
    private String trangthaiDT;

    // Constructor rỗng
    public DeTaiCuaSV() {}

    // Getter và Setter
    public String getIdDtsv() { return idDtsv; }
    public void setIdDtsv(String idDtsv) { this.idDtsv = idDtsv; }

    public String getTenDetai() { return tenDetai; }
    public void setTenDetai(String tenDetai) { this.tenDetai = tenDetai; }

    public String getHotengv() { return hotengv; }
    public void setHotengv(String hotengv) { this.hotengv = hotengv; }

    public String getTrangthaiDT() { return trangthaiDT; }
    public void setTrangthaiDT(String trangthaiDT) { this.trangthaiDT = trangthaiDT; }
    
}