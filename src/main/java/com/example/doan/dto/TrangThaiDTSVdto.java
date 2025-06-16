package com.example.doan.dto;

import java.util.List;

public class TrangThaiDTSVdto {
    private String idDtsv;
    private String hoten;
    private int diem;
    private String nhanxet;
    private List<TrangThai> lichSuTrangThai;

    // Getter & Setter
    public String getIdDtsv() {
        return idDtsv;
    }

    public void setIdDtsv(String idDtsv) {
        this.idDtsv = idDtsv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getNhanxet() {
        return nhanxet;
    }

    public void setNhanxet(String nhanxet) {
        this.nhanxet = nhanxet;
    }

    public List<TrangThai> getLichSuTrangThai() {
        return lichSuTrangThai;
    }

    public void setLichSuTrangThai(List<TrangThai> lichSuTrangThai) {
        this.lichSuTrangThai = lichSuTrangThai;
    }

    // Inner class để chứa từng trạng thái
    public static class TrangThai {
        private String trangthai;
        private String thoigian;

        public String getTrangthai() {
            return trangthai;
        }

        public void setTrangthai(String trangthai) {
            this.trangthai = trangthai;
        }

        public String getThoigian() {
            return thoigian;
        }

        public void setThoigian(String thoigian) {
            this.thoigian = thoigian;
        }
    }
}
