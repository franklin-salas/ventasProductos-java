/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.persistencia.dato;

import sistemacompraventa.persistencia.Model;

/**
 *
 * @author Franklin
 */
public class Combo extends Model{
    private int id_producto;
    private int id_compuesto;

    public Combo(int id_producto, int id_compuesto) {
        this.id_producto = id_producto;
        this.id_compuesto = id_compuesto;
    }

    public Combo() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_compuesto() {
        return id_compuesto;
    }

    public void setId_compuesto(int id_compuesto) {
        this.id_compuesto = id_compuesto;
    }
    
}
