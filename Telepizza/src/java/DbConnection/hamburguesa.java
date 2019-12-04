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
public class hamburguesa {
    int id;
    String nomhamburguesa;

    public hamburguesa(int id, String nomhamburguesa) {
        this.id = id;
        this.nomhamburguesa = nomhamburguesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomhamburguesa() {
        return nomhamburguesa;
    }

    public void setNomhamburguesa(String nomhamburguesa) {
        this.nomhamburguesa = nomhamburguesa;
    }
}