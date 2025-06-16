package com.example.doan.service;

import com.example.doan.dto.NhomSVDKDTRequest;
import com.example.doan.dto.ThanvienRequest;
import com.example.doan.entity.NhomSVDKDT;
import com.example.doan.entity.ThanhVienNhom;
import com.example.doan.repository.NhomSVDKDTRepository;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhomSVDKDTService {
    @Autowired
    private NhomSVDKDTRepository dtsvRepo;

    private NhomService nhomservice;
      @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
    @Autowired
    public NhomSVDKDTService(NhomService nhomService){
        this.nhomservice = nhomService;
    }
    public String dangKyDeTai(NhomSVDKDTRequest req) {
        // Kiểm tra các trường bắt buộc
        if (Stream.of(req.iddtsv, req.Tendetai, req.ID_Sinhvien, req.Hoten, req.Tenkhoa, req.Hotengv, req.Mota).anyMatch(str -> str == null || str.trim().isEmpty())) {
            return "empty_fields";
        }

        // Kiểm tra mã nhóm đã tồn tại chưa
        if (isMaNhomTrung(req.iddtsv)) {
            return "duplicate_iddtsv";
        }

        // Lưu đề tài chính
      // 1. Lưu người đại diện nhóm (người đăng ký chính)
NhomSVDKDT dtsv = new NhomSVDKDT();
dtsv.setID_DTSV(req.iddtsv);
dtsv.setTendetai(req.Tendetai);
dtsv.setID_Sinhvien(req.ID_Sinhvien);
dtsv.setHoten(req.Hoten);
dtsv.setTenkhoa(req.Tenkhoa);
dtsv.setHotengv(req.Hotengv);
dtsv.setMota(req.Mota);
dtsv.setTrangthaiDT("Chờ Duyệt");
dtsvRepo.save(dtsv);



String sql = "INSERT INTO lichsutrangthai (ID_DTSV, TrangthaiDT) VALUES (?, ?)";
jdbcTemplate.update(sql, req.iddtsv, "Chờ duyệt");


  // 2. Thêm người đại diện vào bảng nhóm
        ThanvienRequest truongnhom = new ThanvienRequest();
        truongnhom.setID_DTSV(req.getID_DTSV());
        truongnhom.setID_Sinhvien(req.getID_Sinhvien());
        truongnhom.setHoten(req.getHoten());
        truongnhom.setTenkhoa(req.getTenkhoa());
  nhomservice.themThanhVien(truongnhom);
       

// 2. Lưu các thành viên còn lại
List<ThanvienRequest> thanhviens = req.getThanhviens();
if (thanhviens != null) {
    for (ThanvienRequest tvreq : thanhviens) {
        // Bỏ qua nếu sinh viên là người đại diện
      if(tvreq.getID_Sinhvien().equals(req.getID_Sinhvien())) continue;;

       
        tvreq.setID_DTSV(req.iddtsv); // dùng cùng mã nhóm
       nhomservice.themThanhVien(tvreq);
    }
}

        return "success";
    }

    public boolean isMaNhomTrung(String iddtsv) {
        return dtsvRepo.existsByiddtsv(iddtsv);
    }
}
