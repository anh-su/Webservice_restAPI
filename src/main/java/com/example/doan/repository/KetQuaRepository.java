/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;

import com.example.doan.entity.KetQua;
import com.example.doan.entity.NhomSVDKDT;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ADMIN
 */
public interface KetQuaRepository extends JpaRepository<KetQua, String> 
 {
      Optional<KetQua> findByIdDtsv(String idDtsv); 
}
