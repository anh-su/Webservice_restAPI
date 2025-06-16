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
public class ThanvienRequest {
   public String ID_DTSV;
   public String ID_Sinhvien;
   public String Hoten;
   public String Tenkhoa;

   
   
     // Getters
    public String getID_DTSV() {
        return ID_DTSV;
    }

    public String getID_Sinhvien() {
        return ID_Sinhvien;
    }

    public String getHoten() {
        return Hoten;
    }

    public String getTenkhoa() {
        return Tenkhoa;
    }

    // Setters
    public void setID_DTSV(String ID_DTSV) {
        this.ID_DTSV = ID_DTSV;
    }

    public void setID_Sinhvien(String ID_Sinhvien) {
        this.ID_Sinhvien = ID_Sinhvien;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setTenkhoa(String Tenkhoa) {
        this.Tenkhoa = Tenkhoa;
    }
}
