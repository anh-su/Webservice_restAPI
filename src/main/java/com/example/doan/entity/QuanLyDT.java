/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "detai")
public class QuanLyDT {
    @Id
    @Column(name = "Madetai", unique = true)
    private String madetai;

    @Column(name = "Tendetai")
    private String tendetai;

    @Column(name = "Tieude")
    private String tieude;

    @Column(name = "Trangthai")
    private String trangthai;

    @Column(name = "Ngaybatdau")
    private LocalDate ngaybatdau;

    @Column(name = "Ngayketthuc")
    private LocalDate ngayketthuc;

    @Column(name = "Mota")
    private String mota;

    // GETTER & SETTER cho tất cả các trường



    public String getMadetai() {
        return madetai;
    }

    public void setMadetai(String madetai) {
        this.madetai = madetai;
    }

    public String getTendetai() {
        return tendetai;
    }

    public void setTendetai(String tendetai) {
        this.tendetai = tendetai;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public LocalDate getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(LocalDate ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public LocalDate getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(LocalDate ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
