/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author José Antonio
 */
public class Venta {
    String nombreComercial,nombreProducto,fechaCompra;
    int cantidad,descuento;
    double precio,total,totalDescuento;

    public Venta(String nombreComercial, String nombreProducto, String fechaCompra, int cantidad, int descuento, double precio, double total, double totalDescuento) {
        this.setNombreComercial(nombreComercial);
        this.setNombreProducto(nombreProducto);
        this.setFechaCompra(fechaCompra);
        this.setCantidad(cantidad);
        this.setDescuento(descuento);
        this.setPrecio(precio);
        this.setTotal(total);
        this.setTotalDescuento(totalDescuento);
    }
    
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    @Override
    public String toString() {
        return "Venta{" + "nombreComercial=" + nombreComercial + ", nombreProducto=" + nombreProducto + ", fechaCompra=" + fechaCompra + ", cantidad=" + cantidad + ", descuento=" + descuento + ", precio=" + precio + ", total=" + total + ", totalDescuento=" + totalDescuento + '}';
    }
}