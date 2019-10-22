package Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author José Antonio
 */
public class ListaPedidos {
    private String nombre,apellidos,texto,ing,masa;

    public ListaPedidos(String nombre, String apellidos, String texto, String ing, String masa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.texto = texto;
        this.ing = ing;
        this.masa = masa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    @Override
    public String toString() {
        return nombre +";"+ apellidos + ";"+masa +";"+ ing +";"+ texto;
    }
}