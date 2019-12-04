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
public class ensaladas {
    int id;
    String nomensaladas;

    public ensaladas(int id, String nomensaladas) {
        this.id = id;
        this.nomensaladas = nomensaladas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomensaladas() {
        return nomensaladas;
    }

    public void setNomensaladas(String nomensaladas) {
        this.nomensaladas = nomensaladas;
    }
}