/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import com.example.doan.entity.NhomSVDKDT;
import com.example.doan.entity.QuanLyDT;
import com.example.doan.repository.NhomSVDKDTRepository;

import com.example.doan.repository.detairepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class DetaiService {

    @Autowired
    private detairepository detaiRepository;

         @Autowired
         private NhomSVDKDTRepository dtsvRepo;
               @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    public String themDetai(QuanLyDT dt) {
        if (dt.getMadetai() == null || dt.getTendetai() == null || dt.getTieude() == null ||
            dt.getNgaybatdau() == null || dt.getNgayketthuc() == null || dt.getMota() == null) {
            return "empty_fields";
        }


        if (detaiRepository.existsBymadetai(dt.getMadetai())) {
            return "duplicate";
        }

        dt.setTrangthai("Đã Tạo");
        detaiRepository.save(dt);
        return "success";
    }
    
    
 // Sửa đề tài
    public QuanLyDT suaDeTai(String madetai, QuanLyDT dtMoi) {
        Optional<QuanLyDT> optional = detaiRepository.findBymadetai(madetai);
        if (optional.isPresent()) {
           QuanLyDT dt = optional.get();
            dt.setTendetai(dtMoi.getTendetai());
            dt.setMota(dtMoi.getMota());
            dt.setNgaybatdau(dtMoi.getNgaybatdau());
            dt.setNgayketthuc(dtMoi.getNgayketthuc());
            return detaiRepository.save(dt);
        } else {
            throw new RuntimeException("Không tìm thấy đề tài có mã: " + madetai);
        }
    }

    // Xoá đề tài
   @Transactional
    public void xoaDeTai(String madetai) {
        Optional<QuanLyDT> dt = detaiRepository.findBymadetai(madetai);
        if (dt.isEmpty()) {
            throw new RuntimeException("Không tìm thấy đề tài có mã: " + madetai);
        }
        detaiRepository.delete(dt.get());
    }
    
    
    
public boolean capNhatTrangThai(String iddtsv, String trangthaiduyet){
    Optional<NhomSVDKDT> optional = dtsvRepo.findByIddtsv(iddtsv);
    if(optional.isPresent()){
        NhomSVDKDT detai = optional.get();
        detai.setTrangthaiDT(trangthaiduyet);
        dtsvRepo.save(detai);
               String sql = "INSERT INTO lichsutrangthai (ID_DTSV, TrangthaiDT) VALUES (?, ?)";
jdbcTemplate.update(sql,iddtsv, trangthaiduyet);
        return true;
    }else{
          return false;  
            }
}
       
public boolean capNhatTrangThai1(String iddtsv, String trangthaituchoi){
    Optional<NhomSVDKDT> optional = dtsvRepo.findByIddtsv(iddtsv);
    if(optional.isPresent()){
        NhomSVDKDT detai = optional.get();
        detai.setTrangthaiDT(trangthaituchoi);
        dtsvRepo.save(detai);
               String sql = "INSERT INTO lichsutrangthai (ID_DTSV, TrangthaiDT) VALUES (?, ?)";
jdbcTemplate.update(sql,iddtsv, trangthaituchoi);
        return true;
    }else{
          return false;  
            }
}
}

