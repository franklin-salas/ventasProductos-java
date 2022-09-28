package sistemacompraventa.view;


import java.awt.Point;
import java.util.List;
import sistemacompraventa.utils.Utilidades;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemacompraventa.negocio.NProducto;
import sistemacompraventa.proceso.EnumItem;
import sistemacompraventa.proceso.Item;
import sistemacompraventa.proceso.ItemCombo;
import sistemacompraventa.proceso.ItemComponent;

public class frmProductos extends javax.swing.JInternalFrame implements IUiCombo{

//    private Datos misDatos;
    private int posicion = 0;
    private int proActual = 0;
    private boolean nuevo = false;
    private boolean copiado = false;
    private boolean editCombo =false;
    private  jTableItem jItem;
    private NProducto nProducto;
    private List<ItemComponent> listaItem; 
    private ItemComponent item;
    public frmProductos() {
        initComponents();
        nProducto = new NProducto();
        jItem = new jTableItem(tblProducto, null);
    }
//    public void setDatos(Datos misDatos) {
//        this.misDatos = misDatos;
//    }
    
       @Override
    public void guardarCombo(List<ItemComponent> list, String accion) {
   
           if (this.nuevo) {
               this.item = new ItemCombo();
               for (ItemComponent ob : list) {
                   item.add(ob);
               }
           }else{
              ItemCombo itemCombo = (ItemCombo)item;
                  itemCombo.getListaItem().clear();
                  itemCombo.setListaItem(list);
                  
           }
           item.getItem();
           txtPrecio.setText("0");
           txtPrecio.setEnabled(false);
    }
    private void mostrarResgistro() {
        txtIdProducto.setText(listaItem.get(posicion).getCodigo());
        txtDescripcion.setText(listaItem.get(posicion).getDescripcion());
        txtPrecio.setText("" + listaItem.get(posicion).precioTotal());
        txtCantidadProducto.setText(""+ listaItem.get(posicion).getCantidad());
        txtNota.setText(listaItem.get(posicion).getNota());
        item =listaItem.get(posicion);
        if (item.type().toString().equals(EnumItem.SIMPLE.toString())) {
            jButton1.setEnabled(false);
        }else{
            jButton1.setEnabled(true);
        }

    }
    private void llenarTabla() {
        listaItem = nProducto.indexALL();
        jItem.showTable(listaItem);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnCopy = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        txtCantidadProducto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Productos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setText("ID Producto *");

        txtIdProducto.setEnabled(false);

        jLabel2.setText("Descripción *");

        txtDescripcion.setEnabled(false);

        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecio.setEnabled(false);

        jLabel3.setText("Nota");

        jLabel4.setText("Cantidad *");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/nuevo24x24.png"))); // NOI18N
        btnNuevo.setToolTipText("Nuevo registro");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/guardar24x24.png"))); // NOI18N
        btnGuardar.setToolTipText("Guardar registro");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/cancelar24x24.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar registro");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/editar24x24.png"))); // NOI18N
        btnEditar.setToolTipText("Editar registro");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/borrar24x24.png"))); // NOI18N
        btnBorrar.setToolTipText("Borrar registro");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnCopy.setText("copy");
        btnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(25, 25, 25)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(26, 26, 26)
                .addComponent(btnBorrar)
                .addGap(18, 18, 18)
                .addComponent(btnCopy)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel7.setForeground(java.awt.Color.blue);
        jLabel7.setText("* Campos Obligatorios");

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        jLabel5.setText("Precio *");

        txtNota.setColumns(20);
        txtNota.setRows(5);
        txtNota.setEnabled(false);
        jScrollPane2.setViewportView(txtNota);

        txtCantidadProducto.setEnabled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/producto24x24.png"))); // NOI18N
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDescripcion)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(jButton1)))
                                        .addGap(0, 269, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //habilitar botones
        
        btnNuevo.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnEditar.setEnabled(false);
        
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        
        //habilitar campos
        txtIdProducto.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtPrecio.setEnabled(true);
        txtCantidadProducto.setEnabled(true);
        txtNota.setEnabled(true);
        
        //limpiar campos
        txtCantidadProducto.setText("0");
        txtIdProducto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtNota.setText("");
        jButton1.setEnabled(true);
        editCombo =false;
        //activamos el flag de registro nuevo
        nuevo = true;
        
        txtIdProducto.requestFocusInWindow();
        
    }//GEN-LAST:event_btnNuevoActionPerformed
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        //validaciones
        if (txtIdProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un ID");
            txtIdProducto.requestFocusInWindow();
            return;
        }
        if (txtDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar una Descripcion");
            txtDescripcion.requestFocusInWindow();
            return;
        }
        
        if (txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un Precio");
            txtPrecio.requestFocusInWindow();
            return;
        }
        if (!Utilidades.isFloat(txtPrecio.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un valor numerico");
            txtPrecio.requestFocusInWindow();
            return;
        }
        float precio = 0;
        if (txtPrecio.isEnabled()) {
            precio = Float.parseFloat(txtPrecio.getText());
        if (precio <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un valor mayor a 0");
            txtPrecio.requestFocusInWindow();
            return;
        }  
        }

        if (txtCantidadProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un cantidad");
            txtPrecio.requestFocusInWindow();
            return;
        }
        if (!Utilidades.isNumeric(txtCantidadProducto.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Debe digitar un valor numerico");
            txtPrecio.requestFocusInWindow();
            return;
        }
 String msg = "----";
        if (this.nuevo && item == null) {
            item = new Item(txtIdProducto.getText(),txtDescripcion.getText(),precio,
                    txtNota.getText(),Integer.valueOf(txtCantidadProducto.getText()));
            nProducto.registrar(item);
            this.nuevo = false;
            msg = "producto simple creado";
        }else
        if (this.nuevo && item != null) {
            item.setCodigo(txtIdProducto.getText());
            item.setDescripcion(txtDescripcion.getText());
            item.setPrecio(precio);
            item.setNota(txtNota.getText());
            item.setCantidad(Integer.valueOf(txtCantidadProducto.getText()));
            nProducto.registrar(item);
            this.nuevo = false;
            msg = "producto compuesto creado";
        }else
            if (this.copiado && item != null) {
            item.setCodigo(txtIdProducto.getText());
            item.setDescripcion(txtDescripcion.getText());
            txtPrecio.setText(Float.toString(item.precioTotal()));
            item.setPrecio(item.precioTotal());
            item.setNota(txtNota.getText());
            item.setCantidad(Integer.valueOf(txtCantidadProducto.getText()));
            nProducto.registrar(item);
            msg = "producto creado";
            this.copiado = false;
        }else
        if (!this.nuevo && item != null) {
            item.setCodigo(txtIdProducto.getText());
            item.setDescripcion(txtDescripcion.getText());
            txtPrecio.setText(Float.toString(item.precioTotal()));
            item.setPrecio(item.precioTotal());
            item.setNota(txtNota.getText());
            item.setCantidad(Integer.valueOf(txtCantidadProducto.getText()));
            nProducto.moditar(item);
            msg = "producto modificado";
        }
         item = null;
        JOptionPane.showMessageDialog(rootPane, msg);
        
        
        btnNuevo.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnEditar.setEnabled(true);
        
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        
        //deshabilitar campos
        txtIdProducto.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtPrecio.setEnabled(false);
        txtCantidadProducto.setEnabled(false);
        txtNota.setEnabled(false);
        
        //limpiar campos
        txtCantidadProducto.setText("");
        txtIdProducto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtNota.setText("");
        //actualizamos los cambios en la tabla
        llenarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        
        btnNuevo.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnEditar.setEnabled(true);
        
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(false);
        
        //deshabilitar campos
        txtIdProducto.setEnabled(false);
        txtDescripcion.setEnabled(false);
        txtPrecio.setEnabled(false);
        txtCantidadProducto.setEnabled(false);
        txtNota.setEnabled(false);
        
        txtCantidadProducto.setText("0");
        txtIdProducto.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtNota.setText("");
        jButton1.setEnabled(false);
        this.nuevo =false;
        item = null;
        this.copiado =false;
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //habilitar botones
        if (item == null) {
            return;
        }
        btnNuevo.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnEditar.setEnabled(false);
        
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        
        //habilitar campos
        txtIdProducto.setEnabled(false);
        txtDescripcion.setEnabled(true);
        txtPrecio.setEnabled(true);
        txtCantidadProducto.setEnabled(true);
        txtNota.setEnabled(true);
        editCombo =true;
          //desactivamos el flag de registro nuevo
        nuevo = false;
        
        txtDescripcion.requestFocusInWindow();
    }//GEN-LAST:event_btnEditarActionPerformed
    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

      llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int rta = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro de borrar el Producto?");
        if (rta !=  0) {
            return;
        }
        if (listaItem.get(this.posicion) == null) {
            return;
        }
        String msg = "Producto Eliminado";
        proActual = listaItem.get(this.posicion).getId();
        nProducto.eliminar(proActual);
        JOptionPane.showMessageDialog(rootPane, msg);
         proActual = 0;
         posicion = 0;
        mostrarResgistro();
        
          //actualizamos los cambios en la tabla
        llenarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tblProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMousePressed
        // TODO add your handling code here:
                if (evt.getClickCount() > 1) {
        Point point = evt.getPoint();
        this.posicion  = tblProducto.rowAtPoint(point);
   
        this.mostrarResgistro();
        
        }
    }//GEN-LAST:event_tblProductoMousePressed

    private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
        // TODO add your handling code here:
         int []filasselec  = tblProducto.getSelectedRows();
        if (filasselec.length == 0) {
            return;
        }
        this.posicion  = filasselec[0];
        this.mostrarResgistro();
        this.item =  (ItemComponent) item.clonar();
        this.copiado = true;
                //habilitar botones
        btnNuevo.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnEditar.setEnabled(false);

        
        btnCancelar.setEnabled(true);
        btnGuardar.setEnabled(true);
        
        //habilitar campos
        txtIdProducto.setEnabled(true);
        txtDescripcion.setEnabled(true);
        txtPrecio.setEnabled(true);
        txtCantidadProducto.setEnabled(true);
        txtNota.setEnabled(true);
          //desactivamos el flag de registro nuevo
        nuevo = false;
        
        txtIdProducto.requestFocusInWindow();
        
    }//GEN-LAST:event_btnCopyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

          frmCombo frmcombo = new frmCombo();
          this.getDesktopPane().add(frmcombo);
          frmcombo.setEventIUiCombo(this);
          if(item != null && item.type().toString().equals(EnumItem.COMPUESTO.COMPUESTO.toString())){
              frmcombo.LLenartabla(((ItemCombo)item).getListaItem());
          }
          if (nuevo || editCombo ||copiado) {
            frmcombo.enableBtrn();
        }else{
              frmcombo.disableBtrn();
          }

          
 //         misProductos.setDatos(misDatos);
          //.add(misInventario);
          frmcombo.show();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCopy;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextArea txtNota;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

 
}
