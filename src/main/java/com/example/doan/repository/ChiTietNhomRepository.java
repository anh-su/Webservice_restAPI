/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;

import com.example.doan.dto.ChiTietNhom;
import com.example.doan.entity.NhomSVDKDT;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ADMIN
 */
public interface ChiTietNhomRepository extends JpaRepository<NhomSVDKDT, Long>  {
   

    @Query(
        value = "SELECT sv.ID_Sinhvien AS idSinhvien, sv.Hoten AS hoten, sv.Ngaysinh AS ngaysinh," + 
                " sv.Diachi AS diachi, sv.Email AS email, sv.Sdt AS sdt," + 
                " sv.Gioitinh AS gioitinh, n.Tenkhoa AS tenkhoa " + 
                " FROM nhom AS n JOIN sinhvien AS sv ON n.ID_Sinhvien = sv.ID_Sinhvien " + 
                " WHERE n.ID_DTSV = :idDtsv ",
        nativeQuery = true
    )
    List<ChiTietNhom> layDanhSachThanhVien(@Param("idDtsv") String idDtsv);
}


