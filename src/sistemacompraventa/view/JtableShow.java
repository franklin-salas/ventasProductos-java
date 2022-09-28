/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.view;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franklin
 * @param <T>
 */
public abstract class JtableShow<T> {

        private final JTable jTable;
        protected  List<T> lista;


    public JtableShow(JTable jTable,List<T> lista) {
        this.jTable = jTable;
        this.lista = lista;
    }
   public void showTable(){
        if (lista == null && jTable == null) {
           return;
       }
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos());      
       for (int i = 0; i < this.lista.size(); i++) {
            miTabla.addRow(registroTupla(i));
        }
        jTable.setModel(miTabla);
    }
    public void showTable(List<T> lista){
        this.lista = lista;
        showTable();
    }
    
    abstract String[] titulos();
    abstract String[] registroTupla(int i);   
}
