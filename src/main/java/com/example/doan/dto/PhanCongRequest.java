/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.dto;

/**
 *
 * @author ADMIN
 */
public class PhanCongRequest {
    

    private String idDtsv;
    private String madetai;
    private String hoten;

   
    // getters, setters
     public String getIdDtsv() {
        return idDtsv;
    }

    public String getMadetai() {
        return madetai;
    }

    public String getHoten() {
        return hoten;
    }

   
    // Setters
    public void setIdDtsv(String idDtsv) {
        this.idDtsv = idDtsv;
    }

    public void setMadetai(String madetai) {
        this.madetai = madetai;
    }
     public void setHoten(String hoten) {
        this.hoten = hoten;
    }
}
