package com.example.diegotorres.puntosdeventa.Beans;

/**
 * Created by Diego Torres on 11/07/2018.
 */

public class Usuario {
    private String usuario;
    private String contraseña;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String email;

    public Usuario() {
    }

    public Usuario(String usuario, String contraseña, String nombre, String ap_paterno, String ap_materno, String email) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
