/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;

import com.example.doan.entity.GiangVien;

import com.example.doan.entity.PhanCong;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ADMIN
 */
public interface PhanCongRepository extends JpaRepository<PhanCong, Long>{
    boolean existsByIdDtsvAndMadetaiAndIdgiangvien(String idDtsv, String madetai, GiangVien idgiangvien);

    
}

