/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.view;

import java.util.List;
import javax.swing.JTable;
import sistemacompraventa.persistencia.dato.Producto;

/**
 *
 * @author Franklin
 */
public class jTableProducto extends JtableShow<Producto>{

    public jTableProducto(JTable jTable, List<Producto> lista) {
        super(jTable, lista);
    }

    @Override
    String[] titulos() {
       String titulos[] = { "Codigo", "Descripcion", "Precio", "Cantidad" };
        return titulos;
    }

    @Override
    String[] registroTupla(int i) {
       String codigo = this.lista.get(i).getCodigo();
       String descripcion = this.lista.get(i).getDescripcion();
       String precio = String.valueOf(this.lista.get(i).getPrecio());
       String cantidad = String.valueOf(this.lista.get(i).getCantidad());
       String registro[] = {codigo ,descripcion, precio, cantidad };
       return registro;
    }
    
}
