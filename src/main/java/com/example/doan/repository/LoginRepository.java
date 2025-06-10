/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.doan.entity.Quanlytk;
/**
 *
 * @author ADMIN
 */
@Repository
public interface LoginRepository extends JpaRepository<Quanlytk, Long> {
    @Query(value = """
        SELECT q.vaitro, gv.hoten, gv.diachi,
               q.id_giangvien, gv.ngaysinh, gv.email, gv.sdt, gv.gioitinh
        FROM quanlytk q
        JOIN giangvien gv ON q.id_giangvien = gv.id_giangvien
        WHERE q.tendangnhap = :username AND q.matkhau = :password
        UNION
        SELECT q.vaitro, a.hoten, a.diachi,
               q.id_admin, a.ngaysinh, a.email, a.sdt, a.gioitinh
        FROM quanlytk q
        JOIN admin a ON q.id_admin = a.id_admin
        WHERE q.tendangnhap = :username AND q.matkhau = :password
        UNION
        SELECT q.vaitro, s.hoten, s.diachi,
               q.id_sinhvien, s.ngaysinh, s.email, s.sdt, s.gioitinh
        FROM quanlytk q
        JOIN sinhvien s ON q.id_sinhvien = s.id_sinhvien
        WHERE q.tendangnhap = :username AND q.matkhau = :password
        LIMIT 1
        """, nativeQuery = true)
    Object findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
