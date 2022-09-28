/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.persistencia.dato;

import java.util.List;
import java.util.Objects;
import sistemacompraventa.persistencia.Model;

/**
 *
 * @author Franklin
 */
public class Producto extends Model{
    private String codigo;
    private String descripcion;
    private float precio;
    private String nota;
    private int cantidad;
    private String type;

    public Producto() {
    }

    public Producto(String codigo, String descripcion, float precio, String nota, int cantidad, String type) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nota = nota;
        this.cantidad = cantidad;
        this.type = type;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Combo> combos() {
     return Combo.modelQuery(()-> new Combo(),"SELECT combo.id as id, combo.id_producto as id_producto,combo.id_compuesto as id_compuesto"
                + "                     FROM combo"
                + "                     WHERE "+this.id+"=combo.id_compuesto");

    }

    public List<Combo> simpleCombos() {
         return Combo.modelQuery(()-> new Combo(),"SELECT combo.id as id, combo.id_producto as id_producto,combo.id_compuesto as id_compuesto"
                + "                     FROM combo"
                + "                     WHERE "+this.id+"=combo.id_producto");
    }

    public List<Producto> itemCombo() {
        
     return Producto.modelQuery(()-> new Producto(),"SELECT producto.id as id, producto.codigo as codigo,"
             + "                                    producto.descripcion as descripcion,producto.precio as precio,"
             + "                                    producto.nota as nota,producto.cantidad as cantidad,producto.type as type"
                + "                     FROM producto,combo"
                + "                     WHERE "+this.id+"= combo.id_compuesto AND producto.id = combo.id_producto");

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;

        return Objects.equals(this.id, other.id);
    }

   
   
  
    
}
