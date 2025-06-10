/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;

import com.example.doan.entity.detaisinhvien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ADMIN
 */
public interface detaisinhvienrepository extends JpaRepository<detaisinhvien, Long> {
     @Query("SELECT COUNT(d) FROM detaisinhvien d WHERE d.Tendetai = :Tendetai")
   long countByTendetai (@Param("Tendetai") String Tendetai);
}

