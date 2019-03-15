package com.dev.employee.model;

public class EmployeeAddress {

    private Long id;
    private Long id_tinh;
    private Long id_huyen;
    private Long id_xa;
    private Long id_nhanvien;

    public EmployeeAddress(Long id, Long id_tinh, Long id_huyen, Long id_xa, Long id_nhanvien) {
        this.id = id;
        this.id_tinh = id_tinh;
        this.id_huyen = id_huyen;
        this.id_xa = id_xa;
        this.id_nhanvien = id_nhanvien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_tinh() {
        return id_tinh;
    }

    public void setId_tinh(Long id_tinh) {
        this.id_tinh = id_tinh;
    }

    public Long getId_huyen() {
        return id_huyen;
    }

    public void setId_huyen(Long id_huyen) {
        this.id_huyen = id_huyen;
    }

    public Long getId_xa() {
        return id_xa;
    }

    public void setId_xa(Long id_xa) {
        this.id_xa = id_xa;
    }

    public Long getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(Long id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }
}
