/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.persistencia;


/**
 *
 * @author Franklin
 */
public class ConfiguracionPostgreSQL implements ConfiguracionBD{



    @Override
    public String getNombreDeHost() {
    
        return "localhost";
    }

    @Override
    public String getNumeroDePuerto() {
        return "5432";
    }

    @Override
    public String getNombreDeBaseDeDato() {
        return "producto_db";
    }

    @Override
    public String getNombreDeUsuario() {
        return "postgres";
    }

    @Override
    public String getPassword() {
        return "postgre";
    }

    @Override
    public String getTipoBD() {
        return "jdbc:postgresql://";
    }

    @Override
    public String getDrive() {
        return "org.postgresql.Driver";
    }
    
}
