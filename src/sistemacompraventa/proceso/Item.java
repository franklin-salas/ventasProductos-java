/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.proceso;

/**
 *
 * @author Franklin
 */
public class Item extends ItemComponent{

    public Item( String codigo, String descripcion,float precio, String nota, int cantidad) {
        super(codigo, descripcion,precio ,nota, cantidad,EnumItem.SIMPLE);
    }

    public Item() {
     super();
    }
    
    
    @Override
    public float precioTotal() {
    return this.producto.getPrecio();
    }

    @Override
    public boolean add(ItemComponent itemComponent) {
    return false;
    }

    @Override
    public boolean remove(ItemComponent itemComponent) {
    return false;
    }

    @Override
    public ItemComponent get(int i) {
    return  null;
    }

    @Override
    public Object clonar() {
         Item item =  new Item(producto.getCodigo(), producto.getDescripcion(), precioTotal(),producto.getNota(), 0);
         item.setPrecio(this.precioTotal());
         return item;
    }

    @Override
    public EnumItem type() {
        return EnumItem.SIMPLE;
    }

  
    
}
