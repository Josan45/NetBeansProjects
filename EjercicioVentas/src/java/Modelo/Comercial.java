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
public class Comercial {
    int codigo;
    String nombre;

    public Comercial(int codigo, String nombre) {
        this.setCodigo(codigo);
        this.setNombre(nombre);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Comercial{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}