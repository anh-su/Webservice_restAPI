/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 *
 * @author ADMIN
 */
@JsonPropertyOrder({"idDtsv", "madetai", "tendetaiDetai", "hoten", "hotengv", "trangthaiDT"})
public interface DanhSachDTDK {
    String getIdDtsv();
     String getMadetai();
      String getTendetaiDetai();
       String getHoten();
        String getHotengv();
         String getTrangthaiDT();
                  
}
