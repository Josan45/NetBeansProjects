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
public class Producto {
    String referencia,nombre,descripcion;
    int descuento;
    double precio;

    public Producto(String referencia, String nombre, String descripcion, int descuento, double precio) {
        this.setReferencia(referencia);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setDescuento(descuento);
        this.setPrecio(precio);
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "referencia=" + referencia + ", nombre=" + nombre + ", descripcion=" + descripcion + ", descuento=" + descuento + ", precio=" + precio + '}';
    }
}