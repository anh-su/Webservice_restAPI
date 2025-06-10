/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.doan.entity;
import jakarta.persistence.*;
/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "quanlytk")
public class Quanlytk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Tendangnhap")
    private String tendangnhap;

    @Column(name = "Matkhau")
    private String matkhau;

    @Column(name = "Vaitro")
    private String vaitro;

    // Nếu có liên kết với GiangVien, Admin, SinhVien thì thêm ở đây

    // Getter - Setter
    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

    // thêm getter/setter khác nếu cần
}