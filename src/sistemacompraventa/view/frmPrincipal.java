package sistemacompraventa.view;



public class frmPrincipal extends javax.swing.JFrame {

    //private Datos misDatos;
    private int perfil;
    private String clave;
    private String usuario;
    
    public frmPrincipal() {
        initComponents();
    }
//    public void setDatos(Datos misDatos) {
//        this.misDatos = misDatos;
//    }
    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpnEscritorio = new DesktopConFondo();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuArchivoClientes = new javax.swing.JMenuItem();
        mnuArchivoProductos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuArchivoCambioClave = new javax.swing.JMenuItem();
        mnuArchivoSalir = new javax.swing.JMenuItem();
        mnuMovimientos = new javax.swing.JMenu();
        mnuMovimientosNuevaFactura = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Facturación");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        dpnEscritorio.setBackground(java.awt.Color.lightGray);

        mnuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/archivo24x24.png"))); // NOI18N
        mnuArchivo.setText("Archivo");

        mnuArchivoClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/clientes24x24.png"))); // NOI18N
        mnuArchivoClientes.setText("Clientes");
        mnuArchivoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoClientesActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoClientes);

        mnuArchivoProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/producto24x24.png"))); // NOI18N
        mnuArchivoProductos.setText("Productos");
        mnuArchivoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoProductosActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoProductos);
        mnuArchivo.add(jSeparator1);

        mnuArchivoCambioClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/password24x24.png"))); // NOI18N
        mnuArchivoCambioClave.setText("Base de Dato");
        mnuArchivoCambioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoCambioClaveActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoCambioClave);

        mnuArchivoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/salir24x24.png"))); // NOI18N
        mnuArchivoSalir.setText("Salir");
        mnuArchivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuArchivoSalir);

        jMenuBar1.add(mnuArchivo);

        mnuMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/movimientos24x24.png"))); // NOI18N
        mnuMovimientos.setText("Movimientos");

        mnuMovimientosNuevaFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/facturaNuevo24x24.png"))); // NOI18N
        mnuMovimientosNuevaFactura.setText("Nueva Factura");
        mnuMovimientosNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosNuevaFacturaActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosNuevaFactura);
        mnuMovimientos.add(jSeparator2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemacompraventa/imagen/facturaReporte24x24.png"))); // NOI18N
        jMenuItem1.setText("Inventario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuMovimientos.add(jMenuItem1);

        jMenuBar1.add(mnuMovimientos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpnEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // establece imagen de fondo
        ((DesktopConFondo) dpnEscritorio).setImagen("/sistemacompraventa/imagen/fondo.jpg");
        
        // establece permisos
     
    }//GEN-LAST:event_formWindowOpened
    private void mnuMovimientosNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosNuevaFacturaActionPerformed
        frmFactura miFactura = new frmFactura();
//        miFactura.setDatos(misDatos);
        dpnEscritorio.add(miFactura);
        miFactura.show();
    }//GEN-LAST:event_mnuMovimientosNuevaFacturaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
          frmInventario misInventario = frmInventario.getInstancia();
 //         misProductos.setDatos(misDatos);
          dpnEscritorio.add(misInventario);
          misInventario.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnuArchivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoSalirActionPerformed
        //        misDatos.grabarTodo();
        //        System.exit(0);
    }//GEN-LAST:event_mnuArchivoSalirActionPerformed

    private void mnuArchivoCambioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoCambioClaveActionPerformed
        frmConectarDB database = new frmConectarDB();
        dpnEscritorio.add(database);
        database.show();
    }//GEN-LAST:event_mnuArchivoCambioClaveActionPerformed

    private void mnuArchivoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoProductosActionPerformed
        frmProductos misProductos = new frmProductos();
        //        misProductos.setDatos(misDatos);
        dpnEscritorio.add(misProductos);
        misProductos.show();
    }//GEN-LAST:event_mnuArchivoProductosActionPerformed

    private void mnuArchivoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoClientesActionPerformed
        //        frmClientes misClientes = new frmClientes();
        //        misClientes.setDatos(misDatos);
        //        dpnEscritorio.add(misClientes);
        //        misClientes.show();
    }//GEN-LAST:event_mnuArchivoClientesActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenuItem mnuArchivoCambioClave;
    private javax.swing.JMenuItem mnuArchivoClientes;
    private javax.swing.JMenuItem mnuArchivoProductos;
    private javax.swing.JMenuItem mnuArchivoSalir;
    private javax.swing.JMenu mnuMovimientos;
    private javax.swing.JMenuItem mnuMovimientosNuevaFactura;
    // End of variables declaration//GEN-END:variables
}
