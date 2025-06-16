/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.controller;

import com.example.doan.dto.ChiTietNhom;
import com.example.doan.dto.ThanvienRequest;
import com.example.doan.dto.TrangThaiDTSVdto;
import com.example.doan.repository.ChiTietNhomRepository;
import com.example.doan.service.DeTaiCuaSVService;
import com.example.doan.service.NhomService;
import com.example.doan.service.TrangThaiDTSVService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/nhom")
public class NhomController {

    @Autowired
    private NhomService nhomService;

    @PostMapping("/them-thanh-vien")
    public ResponseEntity<Map<String, String>> themThanhVien(@RequestBody ThanvienRequest req) {
        Map<String, String> response = new HashMap<>();

        if (Stream.of(req.ID_DTSV, req.ID_Sinhvien, req.Hoten, req.Tenkhoa)
                  .anyMatch(s -> s == null || s.trim().isEmpty())) {
            response.put("status", "error");
            response.put("message", "Thiếu thông tin");
            return ResponseEntity.badRequest().body(response);
        }

        boolean result = nhomService.themThanhVien(req);
        if (result) {
            response.put("status", "success");
            response.put("message", "Thêm thành viên thành công");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Lỗi khi thêm thành viên");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    
     @Autowired
    private ChiTietNhomRepository chitietrep;

    @GetMapping("/thanh-vien/{idDtsv}")
    public List<ChiTietNhom> layDanhSachThanhVien(@PathVariable("idDtsv") String idDtsv) {
        return chitietrep.layDanhSachThanhVien(idDtsv);
    }
    
     @Autowired
    private DeTaiCuaSVService rep;
    @PostMapping("/nopbaocao")
 public ResponseEntity<Map<String, Object>> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("idDtsv") String idDtsv) {
        Map<String, Object> response = new HashMap<>();

        try {
            rep.saveUploadedFile(file, idDtsv);
            response.put("success", true);
            response.put("message", "Nộp báo cáo thành công");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Nộp báo cáo thất bại: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
 
   @Autowired
    private TrangThaiDTSVService service;

    @GetMapping("/thongtinlichsu/{idDtsv}")
    public ResponseEntity<TrangThaiDTSVdto> layThongTinVaLichSu(@PathVariable String idDtsv) {
        TrangThaiDTSVdto response = service.layThongTinVaTrangThai(idDtsv);
        return ResponseEntity.ok(response);
    }
}
