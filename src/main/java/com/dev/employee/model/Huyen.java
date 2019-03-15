package com.dev.employee.model;

public class Huyen {

    private Long id_huyen;
    private Long id_tinh;
    private String name;

    public Huyen(Long id_huyen, Long id_tinh, String name) {
        this.id_huyen = id_huyen;
        this.id_tinh = id_tinh;
        this.name = name;
    }

    public Long getId_huyen() {
        return id_huyen;
    }

    public void setId_huyen(Long id_huyen) {
        this.id_huyen = id_huyen;
    }

    public Long getId_tinh() {
        return id_tinh;
    }

    public void setId_tinh(Long id_tinh) {
        this.id_tinh = id_tinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
