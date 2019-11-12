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
public class Altas {
    int codigo,cantidad;
    String referencia,fecha;

    public Altas(int codigo, int cantidad, String referencia, String fecha) {
        this.setCodigo(codigo);
        this.setCantidad(cantidad);
        this.setReferencia(referencia);
        this.setFecha(fecha);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Altas{" + "codigo=" + codigo + ", cantidad=" + cantidad + ", referencia=" + referencia + ", fecha=" + fecha + '}';
    }
}