package com.dev.employee.model;

public class Xa {

    private Long id_xa;
    private Long id_huyen;
    private String name;

    public Xa(Long id_xa, Long id_huyen, String name) {
        this.id_xa = id_xa;
        this.id_huyen = id_huyen;
        this.name = name;
    }

    public Long getId_xa() {
        return id_xa;
    }

    public void setId_xa(Long id_xa) {
        this.id_xa = id_xa;
    }

    public Long getId_huyen() {
        return id_huyen;
    }

    public void setId_huyen(Long id_huyen) {
        this.id_huyen = id_huyen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
