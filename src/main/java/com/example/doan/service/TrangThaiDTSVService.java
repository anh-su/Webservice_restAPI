/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.service;

import com.example.doan.dto.TrangThaiDTSVdto;
import com.example.doan.entity.KetQua;
import com.example.doan.entity.LichSuTrangThai;
import com.example.doan.entity.NhomSVDKDT;
import com.example.doan.entity.QuanLyDT;
import com.example.doan.repository.KetQuaRepository;
import com.example.doan.repository.LichSuTrangThaiRepository;
import com.example.doan.repository.NhomSVDKDTRepository;
import com.example.doan.repository.detairepository;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */


    @Service
public class TrangThaiDTSVService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TrangThaiDTSVdto layThongTinVaTrangThai(String idDtsv) {
        TrangThaiDTSVdto response = new TrangThaiDTSVdto();

        // 1. Lấy 4 thông tin chính
        String sqlInfo = "SELECT ID_DTSV, Hoten, Diem, Nhanxet FROM ketqua WHERE ID_DTSV = ?";
       List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlInfo, idDtsv);

    if (rows.isEmpty()) return null;
Map<String, Object> row = rows.get(0);


        response.setIdDtsv((String) row.get("ID_DTSV"));
        response.setHoten((String) row.get("Hoten"));
        response.setDiem((Float) row.get("Diem"));
        response.setNhanxet((String) row.get("Nhanxet"));

        // 2. Lấy danh sách trạng thái
        String sqlTrangThai = "SELECT TrangthaiDT, Thoigian FROM lichsutrangthai WHERE ID_DTSV = ? ORDER BY Thoigian ASC";
        List<TrangThaiDTSVdto.TrangThai> trangThaiList = jdbcTemplate.query(sqlTrangThai,
                new Object[]{idDtsv},
                (rs, rowNum) -> {
                    TrangThaiDTSVdto.TrangThai trangThai = new TrangThaiDTSVdto.TrangThai();
                    trangThai.setTrangthai(rs.getString("TrangthaiDT"));
                    trangThai.setThoigian(rs.getString("Thoigian"));
                    return trangThai;
                });

        response.setLichSuTrangThai(trangThaiList);
        return response;
    }
    
    @Autowired
    private KetQuaRepository ketQuaRepo;

  @Autowired
    private LichSuTrangThaiRepository lichsuRepo;
 @Autowired
    private NhomSVDKDTRepository dtsv;
    @Transactional
    public boolean chamDiemVaLuuTrangThai(TrangThaiDTSVdto request) {
        try {
            // Insert/update bảng ketqua
            KetQua ketQua = new KetQua();
            ketQua.setID_DTSV(request.getIdDtsv());
            ketQua.sethoten(request.getHoten());
            ketQua.setdiem(request.getDiem());
            ketQua.setnhanxet(request.getNhanxet());
            ketQuaRepo.save(ketQua); // Tự động insert/update

            // Ghi vào bảng lịch sử trạng thái
            LichSuTrangThai lichSu = new LichSuTrangThai();
            lichSu.setID_DTSV(request.getIdDtsv());
            lichSu.settrangthaiDT("Đã Chấm");
 
            lichsuRepo.save(lichSu);
   // 3. Cập nhật trạng thái đề tài
        NhomSVDKDT deTai = dtsv.findByIddtsv(request.getIdDtsv()) 
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đề tài."));
        deTai.setTrangthaiDT("Đã Chấm"); 
        dtsv.save(deTai);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi chấm điểm hoặc lưu trạng thái", e);
        }
    }
    
        @Autowired
    private KetQuaRepository rep;
  // Sửa đề tài
    public KetQua suaDeTai(String idDtsv, KetQua dtMoi) {
        Optional<KetQua> optional = rep.findByIdDtsv(idDtsv);
        if (optional.isPresent()) {
           KetQua dt = optional.get();
            dt.setdiem(dtMoi.getdiem());
            dt.setnhanxet(dtMoi.getnhanxet());
           
            return rep.save(dt);
        } else {
            throw new RuntimeException("Không tìm thấy nhóm có mã: " + idDtsv);
        }
    }

    
}


