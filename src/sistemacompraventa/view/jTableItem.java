/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.view;

import java.util.List;
import javax.swing.JTable;
import sistemacompraventa.proceso.ItemComponent;

/**
 *
 * @author Franklin
 */
public class jTableItem extends JtableShow<ItemComponent>{

    public jTableItem(JTable jTable, List<ItemComponent> lista) {
        super(jTable, lista);
    }
    

    @Override
    String[] titulos() {
        String titulos[] = { "Codigo", "Descripcion", "Precio", "Nota" };
        return titulos;
    }

    @Override
    String[] registroTupla(int i) {
       String codigo = this.lista.get(i).getCodigo();
       String descripcion = this.lista.get(i).getDescripcion();
       String precio = String.valueOf(this.lista.get(i).precioTotal());
       String nota = this.lista.get(i).getNota();    
       String registro[] = {codigo ,descripcion, precio, nota };
       return registro;
    }
    
}
