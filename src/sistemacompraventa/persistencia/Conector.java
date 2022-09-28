/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Franklin
 */
public class Conector {
    private static Conector conector;
    private Connection conexion;
    private ConfiguracionBD configuracionBD;
    private String driver;
    private String tipo;
    
    private Conector(){
    }
    public final static Conector getInstancia(){
        if (conector == null) {
            conector = new Conector();
        }
        return conector;
    }
    
    public Connection abrir(){
        try {
            Class.forName(driver);
            
            String url = tipo + configuracionBD.getNombreDeHost() + ":" +configuracionBD.getNumeroDePuerto()
                    + "/" + configuracionBD.getNombreDeBaseDeDato();
            conexion = DriverManager.getConnection(url,configuracionBD.getNombreDeUsuario(),configuracionBD.getPassword());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, "Error::Abrir Conexión BD", ex);
        }
          return conexion;
    }
    
    public void ejecutar(String sql) throws Exception{
        abrir();
        try {
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            
        } catch (SQLException ex) {
        Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, "Error::Ejecutar Statement BD", ex);
        throw new Exception("Error:: En ejecutar el proceso");
        }
        cerrar();
    }

    public ResultSet ejecutarQuery(String sql){
          abrir();
           ResultSet resultSet = null;
        try {
            Statement statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);
             return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE,"Error:Ejecutar Query", ex);  
        }
            cerrar();
            return null;
    }
    
    public void cerrar() { 
            try {
                if (conexion != null) 
                  conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conector.class.getName()).log(Level.SEVERE,"Error::Cerrar conexión", ex);
            }
    }
    
    
    public Object getResult(ResultSet rs, String type, String columna) throws SQLException {
        switch (type) {
            case "int":
            case "Integer":
                return rs.getInt(columna);
            case "double":
            case "Double":
                return rs.getDouble(columna);
            case "float":
            case "Float":
                return rs.getFloat(columna);
            case "char":
            case "Character":
                return rs.getString(columna).charAt(0);
            case "Array":
                return rs.getArray(columna);
            case "String":
                return rs.getString(columna);
        }
        return null;
    }
    
    public void setConfiguracionBD(ConfiguracionBD configuracionBD){
        this.configuracionBD = configuracionBD;
        setTipoBD();
    }

    private void setTipoBD() {
                driver = this.configuracionBD.getDrive();
                tipo = this.configuracionBD.getTipoBD();
    }
    
    public ConfiguracionBD getConfiguracionBD(){
        return configuracionBD;
    }

}
