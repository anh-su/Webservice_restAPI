/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.controller;

import com.example.doan.dto.DanhSachDTDK;
import com.example.doan.dto.DeTaiCuaSVdto;
import com.example.doan.dto.NhomSVDKDTRequest;
import com.example.doan.entity.DeTaiCuaSV;
import com.example.doan.entity.GiangVien;
import com.example.doan.entity.Khoa;
import com.example.doan.entity.QuanLyDT;
import com.example.doan.repository.DanhSachDTDKRepository;
import com.example.doan.repository.DeTaiCuaSVRepository;
import com.example.doan.repository.GiangVienRepository;
import com.example.doan.repository.KhoaRepository;

import com.example.doan.repository.detairepository;
import com.example.doan.service.DeTaiCuaSVService;
import com.example.doan.service.DetaiService;
import com.example.doan.service.NhomSVDKDTService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/detai")
public class DetaiController {

    @Autowired
    private DetaiService detaiService;

//tạo đề tài 
    @PostMapping("/themdetai")
    public ResponseEntity<?> themDetai(@RequestBody QuanLyDT dt) {
        String result = detaiService.themDetai(dt);

        switch (result) {
            case "empty_fields":
                return ResponseEntity.badRequest().body(Map.of("status", "fail", "message", "Vui lòng điền đầy đủ thông tin"));

            case "duplicate":
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("status", "fail", "message", "Mã đề tài đã tồn tại"));

            case "success":
                dt.setTrangthai("Đã tạo");
                return ResponseEntity.ok(Map.of("status", "success", "message", "Thêm đề tài thành công"));

            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "fail", "message", "Lỗi không xác định"));
        }
    }
    //sửa thông tin đề tài

    @PutMapping("/suadetai/{madetai}")
    public ResponseEntity<?> sua(@PathVariable String madetai, @RequestBody QuanLyDT dt) {
        try {
            QuanLyDT dts = detaiService.suaDeTai(madetai, dt);
            return ResponseEntity.ok(Map.of(
                    "status", "update_success",
                    "message", "Cập nhật đề tài thành công",
                    "data", dts
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "status", "update_fail",
                    "message", e.getMessage()
            ));
        }
    }

    // Xoá đề tài
    @DeleteMapping("/xoadetai/{madetai}")
    public ResponseEntity<?> xoa(@PathVariable String madetai) {
        try {
            detaiService.xoaDeTai(madetai);
            return ResponseEntity.ok(Map.of(
                    "status", "delete_success",
                    "message", "Đã xoá đề tài " + madetai
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                    "status", "delete_fail",
                    "message", e.getMessage()
            ));
        }
    }

    @Autowired
    private detairepository detaiRepo;

    @Autowired
    private GiangVienRepository gvRepo;

    @Autowired
    private KhoaRepository khoaRepo;

    @Autowired
    private NhomSVDKDTService dangKyService;

    // Lấy danh sách đề tài chưa kết thúc
    @GetMapping("/danhsach-detai")
    public List<QuanLyDT> layTenDeTai() {
        return detaiRepo.findByTrangthaiNot("Đã Kết Thúc");
    }

    // Lấy danh sách giảng viên
    @GetMapping("/danhsach-giangvien")
    public List<GiangVien> layTenGiangVien() {
        return gvRepo.findAll();
    }

    // ✅ Lấy danh sách tên khoa
    @GetMapping("/danhsach-khoa")
    public List<Khoa> layTenKhoa() {
        return khoaRepo.findAll();
    }

    // Đăng ký đề tài
    @PostMapping("/dangky")
    public ResponseEntity<Map<String, String>> dangKyDeTai(@RequestBody NhomSVDKDTRequest req) {
        Map<String, String> response = new HashMap<>();

        // Kiểm tra thiếu thông tin
        if (Stream.of(req.iddtsv, req.Tendetai, req.ID_Sinhvien, req.Hoten, req.Tenkhoa, req.Hotengv, req.Mota)
                .anyMatch(s -> s == null || s.trim().isEmpty())) {
            response.put("status", "error");
            response.put("message", "Thiếu thông tin đăng ký đề tài!");
            return ResponseEntity.badRequest().body(response);
        }

        // Kiểm tra trùng mã nhóm
        if (dangKyService.isMaNhomTrung(req.iddtsv)) {
            response.put("status", "error");
            response.put("message", "Mã nhóm đã tồn tại, vui lòng chọn mã khác!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        String result = dangKyService.dangKyDeTai(req);
        if ("success".equals(result)) {
            response.put("status", "success");
            response.put("message", "Đăng ký đề tài thành công!");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Lỗi khi đăng ký đề tài!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/duyet/{iddtsv}")
    public ResponseEntity<?> duyetdetai(@RequestBody Map<String, String> req) {
        String iddtsv = req.get("id_dtsv");
        boolean success = detaiService.capNhatTrangThai(iddtsv, "Đã Duyệt");
        if (success) {

            return ResponseEntity.ok().body(Map.of("status", "success", "message", "Đề tài đã được duyệt"));

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "error", "message", "Không thể duyệt đề tài"));
        }
    }

    @PostMapping("/tuchoi/{iddtsv}")
    public ResponseEntity<?> tuchoidetai(@RequestBody Map<String, String> req) {
        String iddtsv = req.get("id_dtsv");
        boolean success = detaiService.capNhatTrangThai1(iddtsv, "Từ Chối");
        if (success) {
            return ResponseEntity.ok().body(Map.of("status", "success", "message", "Đã từ chối đề tài"));

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("status", "error", "message", "Không thể từ chối đề tài"));
        }
    }

    @Autowired
    private DanhSachDTDKRepository danhsachrep;

    @GetMapping("/danhsachdtdk")
    public List<DanhSachDTDK> layDanhSachDetai() {
        return danhsachrep.layDanhSachDetai();
    }

    //DS đề tài của sinh viên đã đang ký
    @Autowired
    private DeTaiCuaSVService service;

    @GetMapping("/detaicua/{idSinhvien}")
    public List<DeTaiCuaSVdto> getDetai(
            @PathVariable("idSinhvien") String idSinhVien,
            @RequestParam(defaultValue = "all") String TrangthaiDT) {

        List<DeTaiCuaSVdto> detais = service.getDeTaiBySinhVienId(idSinhVien, TrangthaiDT);

        if (detais.isEmpty()) {
            return List.of();
        }

        return detais;
    }

}
