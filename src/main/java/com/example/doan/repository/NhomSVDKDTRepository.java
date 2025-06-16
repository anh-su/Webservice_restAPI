/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;


import com.example.doan.entity.NhomSVDKDT;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ADMIN
 */
public interface NhomSVDKDTRepository extends JpaRepository<NhomSVDKDT, String>{
    boolean existsByiddtsv(String iddtsv);
    
     Optional<NhomSVDKDT> findByIddtsv(String iddtsv);  
     
  
}

