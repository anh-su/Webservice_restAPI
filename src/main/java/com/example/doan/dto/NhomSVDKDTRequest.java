/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.dto;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhomSVDKDTRequest {

    public String iddtsv;
    public String Tendetai;
    public String ID_Sinhvien;
    public String Hoten;
    public String Tenkhoa;
    public String Hotengv;
    public String Mota;

    private List<ThanvienRequest> thanhviens;

    public List<ThanvienRequest> getThanhviens() {
        return thanhviens;
    }
    // Getters
// Getters

    public String getID_DTSV() {
        return iddtsv;
    }

    public void setID_DTSV(String ID_DTSV) {
        this.iddtsv = iddtsv;
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

}
