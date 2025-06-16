/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import com.example.doan.dto.TrangThaiDTSVdto;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */


    @Service
public class TrangThaiDTSVService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TrangThaiDTSVdto layThongTinVaTrangThai(String idDtsv) {
        TrangThaiDTSVdto response = new TrangThaiDTSVdto();

        // 1. Lấy 4 thông tin chính
        String sqlInfo = "SELECT ID_DTSV, Hoten, Diem, Nhanxet FROM ketqua WHERE ID_DTSV = ?";
       List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlInfo, idDtsv);

    if (rows.isEmpty()) return null;
Map<String, Object> row = rows.get(0);


        response.setIdDtsv((String) row.get("ID_DTSV"));
        response.setHoten((String) row.get("Hoten"));
        response.setDiem((int) row.get("Diem"));
        response.setNhanxet((String) row.get("Nhanxet"));

        // 2. Lấy danh sách trạng thái
        String sqlTrangThai = "SELECT TrangthaiDT, Thoigian FROM lichsutrangthai WHERE ID_DTSV = ? ORDER BY Thoigian ASC";
        List<TrangThaiDTSVdto.TrangThai> trangThaiList = jdbcTemplate.query(sqlTrangThai,
                new Object[]{idDtsv},
                (rs, rowNum) -> {
                    TrangThaiDTSVdto.TrangThai trangThai = new TrangThaiDTSVdto.TrangThai();
                    trangThai.setTrangthai(rs.getString("TrangthaiDT"));
                    trangThai.setThoigian(rs.getString("Thoigian"));
                    return trangThai;
                });

        response.setLichSuTrangThai(trangThaiList);
        return response;
    }
}


