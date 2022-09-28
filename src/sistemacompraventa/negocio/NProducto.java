/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.negocio;

import java.util.LinkedList;
import java.util.List;
import sistemacompraventa.persistencia.dato.Combo;
import sistemacompraventa.persistencia.dato.Producto;
import sistemacompraventa.proceso.EnumItem;
import sistemacompraventa.proceso.Item;
import sistemacompraventa.proceso.ItemCombo;
import sistemacompraventa.proceso.ItemComponent;
import sistemacompraventa.view.frmInventario;

/**
 *
 * @author Franklin
 */
public class NProducto {
    
    public List<ItemComponent> indexALL(){
        List<ItemComponent> lista = new LinkedList<>();
        List<Producto> productos = Producto.all(()->new Producto());
        for (Producto producto1 : productos) {
            insert(producto1, lista);
        }
        return lista;
    }
    private void insert(Producto producto,List<ItemComponent> lista ){
        if (EnumItem.SIMPLE.toString().equals(producto.getType())) {
              Item item = new Item();
                        item.setItem(producto);
                        lista.add(item);
            }else{
                ItemCombo item = new ItemCombo();
                          item.setItem(producto);
                List<Producto> simples = producto.itemCombo();
                for (Producto simple : simples) {
                    insert(simple,item.getListaItem());
                    }
                      lista.add(item);
            }
    }
    public  boolean  registrar(ItemComponent itemp){
        
        if (EnumItem.SIMPLE.toString().equals(itemp.type().toString())) {
              Producto p = itemp.getItem();
              p.save();
                       
            }else{
              Producto p = itemp.getItem();
              p.save();
              Integer id = p.final_Id();
              List<ItemComponent> list = ((ItemCombo)itemp).getListaItem();
              for (ItemComponent item : list) {
                Combo combo = new Combo(item.getId(),id);
                combo.save();
            }
            
            }
        Producto p = itemp.getItem();
        Integer i = p.final_Id();
        p.id = i;
        p.addObservador(frmInventario.getInstancia());
        p.notificar("registrar");
        return true;
    };
    
    public  boolean  moditar(ItemComponent itemp){
            if (EnumItem.SIMPLE.toString().equals(itemp.type().toString())) {
              Producto p = itemp.getItem();
              p.update();
                       
            }else{
              Producto p = itemp.getItem();
              List<Combo> combos = p.combos();
                for (Combo combo : combos) {
                    combo.delete();
                }
              List<ItemComponent> list = ((ItemCombo)itemp).getListaItem();
              for (ItemComponent item : list) {
                Combo combo = new Combo(item.getId(),p.getId());
                combo.save();
            }
              p.update();
            }
            Producto p = itemp.getItem();
        p.addObservador(frmInventario.getInstancia());
        p.notificar("modificar");
        return true;
    };
    
    public  boolean  eliminar(int id){
        Producto p = Producto.find(id, ()->new Producto());
        p.delete();
        
         List<Combo> combos = p.combos();
                for (Combo combo : combos) {
                    combo.delete();
                }
          List<Combo> simplecombos = p.simpleCombos();
                for (Combo combo : simplecombos) {
                    combo.delete();
                }
                
        p.addObservador(frmInventario.getInstancia());
        p.notificar("eliminar");  

        return true;
    };
    
    public static List<Producto> all(){
       //  List<Producto> lista = new LinkedList<>();
        return Producto.all(()->new Producto());
      //  return lista;
    }

}
