/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;

import com.example.doan.entity.QuanLyDT;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ADMIN
 */
public interface detairepository extends JpaRepository<QuanLyDT, Long>{
    @Query("SELECT DISTINCT d.Tendetai FROM detai d")
    List<String> findDistinctTendetai();
    
     // Thêm phương thức kiểm tra trùng mã đề tài
    boolean existsBymadetai(String madetai);
    Optional<QuanLyDT> findBymadetai(String madetai);
    void deleteBymadetai(String madetai);
    
    List<QuanLyDT> findByTrangthaiNot(String TrangthaiDT );
}

