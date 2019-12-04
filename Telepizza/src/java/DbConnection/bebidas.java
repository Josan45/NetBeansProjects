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
public class bebidas {
    int id;
    String nombebidas;

    public bebidas(int id, String nombebidas) {
        this.id = id;
        this.nombebidas = nombebidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombebidas() {
        return nombebidas;
    }

    public void setNombebidas(String nombebidas) {
        this.nombebidas = nombebidas;
    }
}