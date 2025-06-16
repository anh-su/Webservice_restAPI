/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.dto;



/**
 *
 * @author ADMIN
 */
public class DeTaiCuaSVdto {
 private String idDtsv;
    private String madetai;
    private String tenDetai;
    private String hotengv;
    private String trangthaiDT;

    public DeTaiCuaSVdto(String idDtsv, String madetai, String tenDetai, String hotengv, String trangthaiDT) {
        this.idDtsv = idDtsv;
        this.madetai = madetai;
        this.tenDetai = tenDetai;
        this.hotengv = hotengv;
        this.trangthaiDT = trangthaiDT;
    }
    
    
     // Getters & Setters
    public String getIdDtsv() { return idDtsv; }
    public void setIdDtsv(String idDtsv) { this.idDtsv = idDtsv; }

    public String getMadetai() { return madetai; }
    public void setMadetai(String madetai) { this.madetai = madetai; }

    public String getTenDetai() { return tenDetai; }
    public void setTenDetai(String tenDetai) { this.tenDetai = tenDetai; }

    public String getHotengv() { return hotengv; }
    public void setHotengv(String hotengv) { this.hotengv = hotengv; }

    public String getTrangthaiDT() { return trangthaiDT; }
    public void setTrangthaiDT(String trangthaiDT) { this.trangthaiDT = trangthaiDT; }
}
