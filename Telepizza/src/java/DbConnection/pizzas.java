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
public class pizzas {
    int id,idpizza;
    String nompizzas;

    public pizzas(int id, String nompizzas, int idpizza) {
        this.id = id;
        this.idpizza = idpizza;
        this.nompizzas = nompizzas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpizza() {
        return idpizza;
    }

    public void setIdpizza(int idpizza) {
        this.idpizza = idpizza;
    }

    public String getNompizzas() {
        return nompizzas;
    }

    public void setNompizzas(String nompizzas) {
        this.nompizzas = nompizzas;
    }
}