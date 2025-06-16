/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import com.example.doan.dto.PhanCongRequest;
import com.example.doan.entity.GiangVien;
import com.example.doan.entity.NhomSVDKDT;
import com.example.doan.entity.PhanCong;
import com.example.doan.repository.GiangVienRepository;
import com.example.doan.repository.NhomSVDKDTRepository;
import com.example.doan.repository.PhanCongRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class PhanCongService {
    @Autowired private PhanCongRepository phanCongRepo;
    @Autowired private GiangVienRepository giangVienRepo;
    @Autowired private NhomSVDKDTRepository nhomRepo;
              @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

   public Map<String, Object> phanCongGiangVien(PhanCongRequest req) {
    Map<String, Object> response = new HashMap<>();
    Optional<GiangVien> optionalGiangVien = giangVienRepo.findByHoten(req.getHoten());

    if (!optionalGiangVien.isPresent()) {
        response.put("status", "error");
        response.put("message", "Không tìm thấy giảng viên.");
        return response;
    }
    GiangVien gv = optionalGiangVien.get();

    boolean exists = phanCongRepo.existsByIdDtsvAndMadetaiAndIdgiangvien(req.getIdDtsv(), req.getMadetai(), gv);
    if (exists) {
        response.put("status", "error");
        response.put("message", "Phân công đã tồn tại.");
        return response;
    }
  
    // Tìm đề tài theo idDtsv
    Optional<NhomSVDKDT> detai = nhomRepo.findByIddtsv(req.getIdDtsv()); 
    if (detai.isEmpty()) {
        response.put("status", "error");
        response.put("message", "Không tìm thấy nhóm đăng ký đề tài.");
        return response;
    }
    NhomSVDKDT d = detai.get();

    PhanCong pc = new PhanCong();
    pc.setID_DTSV(req.getIdDtsv()); // <- Nếu chưa khớp, kiểm lại getters/setters
    pc.setMadetai(req.getMadetai()); 
    pc.setID_Giangvien(gv);
    pc.setHoten(req.getHoten());

    phanCongRepo.save(pc);

    // Cập nhật trạng thái đề tài
    d.setTrangthaiDT("Đã Duyệt / Đã Phân Công");

    nhomRepo.save(d);
           String sql = "INSERT INTO lichsutrangthai (ID_DTSV, TrangthaiDT) VALUES (?, ?)";
jdbcTemplate.update(sql,req.getIdDtsv(), d.getTrangthaiDT());

    response.put("status", "success");
     response.put("message", "Đã phân công chấm bài");

    return response;
}

}
