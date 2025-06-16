/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import com.example.doan.dto.ThanvienRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class NhomService {

    @Autowired
    private JdbcTemplate jdbc;

    public boolean themThanhVien(ThanvienRequest req) {
        String sql = "INSERT INTO nhom (ID_DTSV, ID_Sinhvien, Hoten, Tenkhoa) VALUES (?, ?, ?, ?)";
        try {
            jdbc.update(sql, req.ID_DTSV, req.ID_Sinhvien, req.Hoten, req.Tenkhoa);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
