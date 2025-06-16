package com.example.doan.service;

import com.example.doan.dto.DeTaiCuaSVdto;
import com.example.doan.repository.DeTaiCuaSVRepository;
import com.example.doan.repository.DeTaiCuaSVRepository;
import java.io.File;


import java.io.IOException;

import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;









@Service
public class DeTaiCuaSVService {

    @Autowired
    private DeTaiCuaSVRepository deTaiRepository;

    public List<DeTaiCuaSVdto> getDeTaiBySinhVienId(String idSinhvien) {
        List<Object[]> results = deTaiRepository.findDeTaiBySinhVienId(idSinhvien);
        return results.stream().map(row -> new DeTaiCuaSVdto(
                (String) row[0], // ID_DTSV
                (String) row[1], // Madetai
                (String) row[2], // Tendetai_Detai
                (String) row[4], // Hotengv
                (String) row[5]  // TrangthaiDT
        )).collect(Collectors.toList());
    }
    
    @Autowired
private JdbcTemplate jdbcTemplate;

    public void saveUploadedFile(MultipartFile file, String idDtsv) throws IOException, java.io.IOException {
    // Tạo thư mục nếu chưa có
    String uploadDir = "uploads/";
    File dir = new File(uploadDir);
    if (!dir.exists()) dir.mkdirs();

    // Tạo tên file duy nhất
    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
    Path filePath = Paths.get(uploadDir, fileName);
    Files.write(filePath, file.getBytes());

    // Lưu đường dẫn vào bảng detaisinhvien (chỉ lưu tên file)
    String sql = "UPDATE detaisinhvien SET Filebaitap = ? WHERE ID_DTSV = ?";
    jdbcTemplate.update(sql, uploadDir + fileName, idDtsv);
}

}
