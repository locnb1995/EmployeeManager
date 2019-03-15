package com.dev.employee.model;

public class Employee {

    private Long id_nhanvien;
    private String name;
    private int age;
    private String tinh;
    private String huyen;
    private String xa;

    public Employee(Long id_nhanvien, String name, int age, String tinh, String huyen, String xa) {
        this.id_nhanvien = id_nhanvien;
        this.name = name;
        this.age = age;
        this.tinh = tinh;
        this.huyen = huyen;
        this.xa = xa;
    }

    public Long getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(Long id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getHuyen() {
        return huyen;
    }

    public void setHuyen(String huyen) {
        this.huyen = huyen;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }
}
