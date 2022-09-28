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
public class ConfiguracionMySQL implements ConfiguracionBD{

  

    @Override
    public String getNombreDeHost() {
    
        return "localhost";
    }

    @Override
    public String getNumeroDePuerto() {
        return "3306";
    }

    @Override
    public String getNombreDeBaseDeDato() {
        return "productosdb?zeroDateTimeBehavior=convertToNull";
        ///jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
    }

    @Override
    public String getNombreDeUsuario() {
        return "root";
    }

    @Override
    public String getPassword() {
        return "123456";
    }

    @Override
    public String getTipoBD() {
        return "jdbc:mysql://";
    }

    @Override
    public String getDrive() {
        //return "com.mysql.jdbc.Driver";
        return "com.mysql.cj.jdbc.Driver";
    }
    
}
