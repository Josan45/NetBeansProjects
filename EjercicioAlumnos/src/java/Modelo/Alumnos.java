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
public class Alumnos {
    String nombre,apellidos,dawes,dawec,diw,daw,fct,proyecto;

    public Alumnos(String nombre, String apellidos, String dawes, String dawec, String diw, String daw, String fct, String proyecto) {
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setDawes(dawes);
        this.setDawec(dawec);
        this.setDiw(diw);
        this.setDaw(daw);
        this.setFct(fct);
        this.setProyecto(proyecto);
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

    public String getDawes() {
        return dawes;
    }

    public void setDawes(String dawes) {
        this.dawes = dawes;
    }

    public String getDawec() {
        return dawec;
    }

    public void setDawec(String dawec) {
        this.dawec = dawec;
    }

    public String getDiw() {
        return diw;
    }

    public void setDiw(String diw) {
        this.diw = diw;
    }

    public String getDaw() {
        return daw;
    }

    public void setDaw(String daw) {
        this.daw = daw;
    }

    public String getFct() {
        return fct;
    }

    public void setFct(String fct) {
        this.fct = fct;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }
}