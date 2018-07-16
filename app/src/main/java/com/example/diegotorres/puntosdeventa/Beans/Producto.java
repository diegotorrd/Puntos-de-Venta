package com.example.diegotorres.puntosdeventa.Beans;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public class Producto {
    private int id;
    private String descripcion;
    private int stock;

    public Producto() {
    }

    public Producto(int id, String descripcion, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
