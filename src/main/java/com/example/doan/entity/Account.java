package com.example.doan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quanlytk")
public class Account {

    @Id
    @Column(name = "ID_TK")
    private String id;

    @Column(name = "Tendangnhap")
    private String username;

    @Column(name = "Matkhau")
    private String password;

    @Column(name = "Vaitro")
    private int role;

    @Column(name = "ID_Admin", nullable = true)
    private String adminId;

    @Column(name = "ID_Sinhvien", nullable = true)
    private String studentId;

    @Column(name = "ID_Giangvien", nullable = true)
    private String teacherId;

    // === GETTERS & SETTERS ===

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
