package com.dev.employee.model;

public class Tinh {

    private Long id_tinh;
    private String name;

    public Tinh(Long id_tinh, String name) {
        this.id_tinh = id_tinh;
        this.name = name;
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
