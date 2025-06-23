/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.controller;



import com.example.doan.dto.PhanCongRequest;
import com.example.doan.dto.TrangThaiDTSVdto;
import com.example.doan.service.PhanCongService;
import com.example.doan.entity.GiangVien;
import com.example.doan.entity.KetQua;
import com.example.doan.entity.QuanLyDT;
import com.example.doan.repository.GiangVienRepository;
import com.example.doan.service.TrangThaiDTSVService;
import java.util.HashMap;


import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/phancong")
@CrossOrigin
public class PhanCongController {
    @Autowired private PhanCongService phanCongService;
    @Autowired private GiangVienRepository giangVienRepository;
        @Autowired private TrangThaiDTSVService chamDiemService;
        
         @Autowired private TrangThaiDTSVService Service;
    

    @PostMapping
    public ResponseEntity<?> phanCong(@RequestBody PhanCongRequest request) {
        Map<String, Object> result = phanCongService.phanCongGiangVien(request);
        if ("success".equals(result.get("status"))) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @GetMapping("/giangvien")
    public List<GiangVien> layDanhSachGiangVien() {
        return giangVienRepository.findAll();
    }
    



   

    @PostMapping("/chamdiem")
    public ResponseEntity<Map<String, Object>> chamDiem(@RequestBody TrangThaiDTSVdto request) {
        Map<String, Object> response = new HashMap<>();

        try {
            boolean result = chamDiemService.chamDiemVaLuuTrangThai(request);

            if (result) {
                response.put("status", "success");
                response.put("message", "Chấm điểm thành công");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "fail");
                response.put("message", "Chấm điểm thất bại");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Lỗi hệ thống: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
 @PutMapping("/capnhatdiem/{idDtsv}")
public ResponseEntity<?> sua(@PathVariable String idDtsv, @RequestBody KetQua dt) {
    try {
       KetQua dts = Service.suaDeTai(idDtsv, dt);
        return ResponseEntity.ok(Map.of(
            "status", "success",
            "message", "Cập nhật điểm thành công",
            "data", dts
        ));
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "status", "fail",
            "message", e.getMessage()
        ));
    }
}

}


   

