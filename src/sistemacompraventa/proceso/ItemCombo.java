/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.proceso;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Franklin
 */
public class ItemCombo extends ItemComponent{
    private List<ItemComponent> listaItem;

    public ItemCombo() {
        super();
        this.listaItem = new LinkedList<>();
    }

    public ItemCombo( String codigo, String descripcion,float precio ,String nota, int cantidad) {
        super(codigo, descripcion,precio ,nota, cantidad,EnumItem.COMPUESTO);
        this.listaItem = new LinkedList<>();
    }
    
    @Override
    public float precioTotal() {
        float v = 0;
        for (ItemComponent listaItem1 : listaItem) {
            v += listaItem1.precioTotal(); 
        }
        return v;
    }

    @Override
    public boolean add(ItemComponent itemComponent) {
        return listaItem.add(itemComponent);
    }

    @Override
    public boolean remove(ItemComponent itemComponent) {
        return listaItem.remove(itemComponent);
    }

    @Override
    public ItemComponent get(int i) {
     return listaItem.get(i);
    }

    @Override
    public Object clonar() {
     ItemCombo item = new ItemCombo(producto.getCodigo(), producto.getDescripcion(),producto.getPrecio(),producto.getNota(), 0);
          item.setPrecio(this.precioTotal());
          item.listaItem.addAll(this.listaItem);
    
        return item;
    }

    @Override
    public EnumItem type() {
        return EnumItem.COMPUESTO;
    }

    public List<ItemComponent> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<ItemComponent> listaItem) {
        this.listaItem = listaItem;
    }


    
}
