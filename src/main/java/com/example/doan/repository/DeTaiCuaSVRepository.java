package com.example.doan.repository;

import com.example.doan.entity.DeTaiCuaSV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DeTaiCuaSVRepository extends JpaRepository<DeTaiCuaSV, Long>  {

    @Query(value = """
        SELECT 
            sv.ID_DTSV, 
            d.Madetai, 
            d.Tendetai AS Tendetai_Detai, 
            sv.Tendetai AS Tendetai_Detaisinhvien, 
            sv.Hotengv, 
            sv.TrangthaiDT 
        FROM nhom AS n
        JOIN detaisinhvien AS sv ON n.ID_DTSV = sv.ID_DTSV
        JOIN detai AS d ON d.Tendetai = sv.Tendetai
        WHERE n.ID_Sinhvien = :idSinhvien
        LIMIT 25
    """, nativeQuery = true)
    List<Object[]> findDeTaiBySinhVienId(@Param("idSinhvien") String idSinhvien);
}
