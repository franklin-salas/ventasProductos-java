/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.proceso;

import java.util.Objects;
import sistemacompraventa.persistencia.dato.Producto;



/**
 *
 * @author Franklin
 */
public abstract class ItemComponent implements Prototype{
    protected Producto producto;
    

    public ItemComponent() {
        this.producto = new Producto();
    }

    public ItemComponent(String codigo, String descripcion,float precio,String nota, int cantidad,EnumItem enumItem) {
        this.producto = new Producto(codigo, descripcion,precio, nota, cantidad, enumItem.toString());
    }
    
    public Integer getId() {
        return producto.id;
    }

    public void setId(Integer id) {
        this.producto.id = id;
    }

    public String getCodigo() {
        return producto.getCodigo();
    }

    public void setCodigo(String codigo) {
        this.producto.setCodigo(codigo);
    }

    public String getDescripcion() {
        return producto.getDescripcion();
    }

    public void setDescripcion(String descripcion) {
        this.producto.setDescripcion(descripcion);
    }

    public String getNota() {
        return producto.getNota();
    }

    public void setNota(String nota) {
        this.producto.setNota(nota);
    }

    public int getCantidad() {
        return producto.getCantidad();
    }

    public void setCantidad(int cantidad) {
        this.producto.setCantidad(cantidad);
    }

    public void setPrecio(float precio) {
        this.producto.setPrecio(precio);
    }
    public void setItem(Producto producto){
        this.producto = producto;
    }
    public Producto getItem(){
       return this.producto;
    }
    public abstract EnumItem type();
    public abstract float precioTotal();
    public abstract boolean add(ItemComponent itemComponent);
    public abstract boolean remove(ItemComponent itemComponent);
    public abstract ItemComponent get(int i);

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.producto);
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
        final ItemComponent other = (ItemComponent) obj;
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.producto !=null) {
            return producto.getCodigo() +" - "+producto.getDescripcion();
        }
        return "ItemComponent -1";
    }
    
    
}
