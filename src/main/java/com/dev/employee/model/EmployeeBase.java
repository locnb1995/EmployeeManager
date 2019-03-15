package com.dev.employee.model;

public class EmployeeBase {

    private Long id_nhanvien;
    private String name;
    private int age;

    public EmployeeBase(Long id_nhanvien, String name, int age) {
        this.id_nhanvien = id_nhanvien;
        this.name = name;
        this.age = age;
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
}
