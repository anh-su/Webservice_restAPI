/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;

import com.example.doan.dto.DanhSachDTDK;
import com.example.doan.entity.detai;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ADMIN
 */
public interface DanhSachDTDKRepository extends JpaRepository<detai, Long> {

    @Query(
        value = "SELECT DISTINCT sv.ID_DTSV AS idDtsv, d.Madetai AS madetai, d.Tendetai AS tendetaiDetai," + 
                " sv.Hoten AS hoten, sv.Tendetai AS tendetaiDetaisinhvien," + 
                " sv.Hotengv AS hotengv, sv.TrangthaiDT AS trangthaiDT " + 
                " FROM nhom AS n " + 
                " JOIN detaisinhvien AS sv ON n.ID_DTSV = sv.ID_DTSV " + 
                " JOIN detai AS d ON d.Tendetai = sv.Tendetai",
        nativeQuery = true
    )
    List<DanhSachDTDK> layDanhSachDetai();

}