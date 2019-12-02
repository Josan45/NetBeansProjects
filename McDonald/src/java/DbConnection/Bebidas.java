/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

/**
 *
 * @author José Antonio
 */
public class Bebidas {
    int id;
    String descripion;

    public Bebidas(int id, String descripion) {
        this.id = id;
        this.descripion = descripion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }
}