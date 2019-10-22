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
public class ListaActividades {
    String nom,lug,fec,hor,dest,curso,profe,texto;
    String oc;

    public ListaActividades(String nom, String lug, String fec, String hor, String dest, String curso, String profe, String texto, String oc) {
        this.nom = nom;
        this.lug = lug;
        this.fec = fec;
        this.hor = hor;
        this.dest = dest;
        this.curso = curso;
        this.profe = profe;
        this.texto = texto;
        this.oc = oc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLug() {
        return lug;
    }

    public void setLug(String lug) {
        this.lug = lug;
    }

    public String getFec() {
        return fec;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public String getHor() {
        return hor;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getProfe() {
        return profe;
    }

    public void setProfe(String profe) {
        this.profe = profe;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getOc() {
        return oc;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    @Override
    public String toString() {
        return "ListaActividades{" + "nom=" + nom + ", lug=" + lug + ", fec=" + fec + ", hor=" + hor + ", dest=" + dest + ", curso=" + curso + ", profe=" + profe + ", texto=" + texto + ", oc=" + oc + '}';
    }     
}
