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
public class postre {
    int id;
    String nompostre;

    public postre(int id, String nompostre) {
        this.id = id;
        this.nompostre = nompostre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNompostre() {
        return nompostre;
    }

    public void setNompostre(String nompostre) {
        this.nompostre = nompostre;
    }
}