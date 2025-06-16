/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.controller;

import com.example.doan.dto.PhanCongRequest;
import com.example.doan.service.PhanCongService;
import com.example.doan.entity.GiangVien;
import com.example.doan.repository.GiangVienRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
