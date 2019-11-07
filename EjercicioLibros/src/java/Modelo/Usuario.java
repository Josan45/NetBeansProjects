/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Antonio
 */
public class Usuario {
    
    int idUsuario;
    String usuario,nombre,clave,tipo;

    public Usuario(int idUsuario, String usuario, String nombre, String clave, String tipo) {
        this.setIdUsuario(idUsuario);
        this.setUsuario(usuario);
        this.setNombre(nombre);
        this.setClave(clave);
        this.setTipo(tipo);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "usuarios{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", nombre=" + nombre + ", clave=" + clave + ", tipo=" + tipo + '}';
    }
}