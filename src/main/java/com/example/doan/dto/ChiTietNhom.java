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
@JsonPropertyOrder({"idSinhvien", "hoten", "tendetaiDetai", "hoten", "ngaysinh", "dichi", "email", "sdt", "gioitinh", "tenkhoa"})
public interface ChiTietNhom {
    String getIdSinhvien();
    
    String getHoten();
    
    String getNgaysinh();
    
    String getDiachi();
    
    String getEmail();
    
    String getSdt();
    
    String getGioitinh();
    
    String getTenkhoa();
}
