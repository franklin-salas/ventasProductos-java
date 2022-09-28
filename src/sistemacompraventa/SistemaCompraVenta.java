/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa;

import javax.swing.JFrame;
import sistemacompraventa.persistencia.Conector;
import sistemacompraventa.persistencia.ConfiguracionMySQL;
import sistemacompraventa.view.frmPrincipal;

/**
 *
 * @author Franklin
 */
public class SistemaCompraVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Datos misDatos = new Datos();
        
        //llamamos al formulario login
        //frmLogin miLogin = new frmLogin();
      //  miLogin.setDatos(misDatos);
       // miLogin.setLocationRelativeTo(null);
       // miLogin.setVisible(true);
        //-----------------------------------------
        frmPrincipal miPrincipal = new frmPrincipal();
        Conector c = Conector.getInstancia();
        c.setConfiguracionBD(new ConfiguracionMySQL());
        //this.setVisible(false);
        //miPrincipal.setDatos(misDatos);
//        miPrincipal.setPerfil(misDatos.getPerfil(txtUsuario.getText()));
//        miPrincipal.setClave(new String(txtPassword.getPassword()));
//        miPrincipal.setUsuario(txtUsuario.getText());
        miPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        miPrincipal.setVisible(true);
    }
    
}
