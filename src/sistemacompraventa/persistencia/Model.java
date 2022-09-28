/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.persistencia;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemacompraventa.proceso.Sujeto;

/**
 *
 * @author Franklin
 */
public class Model extends Sujeto{
    
    public Integer id;
    
    public Integer final_Id(){
            Conector connector = Conector.getInstancia();
            String sql =  "SELECT MAX(id) as id FROM "+Utility.tableOf(this);
            ResultSet rs = connector.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     public boolean save(){
        try {
            Method[] mt = this.getClass().getDeclaredMethods();
            List<Field> fields = Utility.getFields(mt, this, false);
            Conector connector = Conector.getInstancia();
            
            String sql = "INSERT INTO " + Utility.tableOf(this) + " (";
            for (int i = 0; i < fields.size(); i++) {
                Field field = fields.get(i);
                
                sql += field.getNombre();
                
                if ((i + 1) < fields.size()) {
                    sql += ", ";
                }
            }
            
            sql += ") VALUES (";
            for (int i = 0; i < fields.size(); i++) {
                Field field = fields.get(i);
                
                sql += "'" + field.getValor()+ "'";
                
                if ((i + 1) != fields.size()) {
                    sql += ", ";
                }
            }
            
            sql += ")";
            
            connector.ejecutar(sql);
          
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE,"Modelo:: "+ this.getClass().getSimpleName()+" :: Registrar", ex);
            return false;
        }
          return  true;
    }


    public boolean update() {
        try {
            Method[] mt = this.getClass().getDeclaredMethods();
            List<Field> fields = Utility.getFields(mt, this, false);
            Conector connector = Conector.getInstancia();
            
            String sql = "UPDATE " + Utility.tableOf(this) + " SET ";
            for (int i = 0; i < fields.size(); i++) {
                Field field = fields.get(i);
                
                sql += field.getNombre()+ " = '" + field.getValor()+ "'";
                
                if ((i + 1) < fields.size()) {
                    sql += ", ";
                }
            }
            
            if (id == null) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "id cannot be null");
                return false;
            }
            
            sql += " WHERE id = " + id;
            
            connector.ejecutar(sql);
         
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "Modelo:: "+ this.getClass().getSimpleName()+" :: Editar", ex);
        return false;
        }
        
        return true;
    }

    public boolean delete(){
        try {
            String sql = "DELETE FROM " + Utility.tableOf(this);
            Conector connector = Conector.getInstancia();
            
            if (id == null) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "id cannot be null");
                return false ;
            }
            
            sql += " WHERE id = " + id;
            
            connector.ejecutar(sql);
            System.out.println(sql);
        } catch (Exception ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "Modelo:: "+ this.getClass().getSimpleName()+" :: Eliminar", ex);
             return false ;
        }
        return true;
    }

    public static void create(Model model)throws Exception {
        model.save();
    }

    public static void update(Model model) throws Exception{
        model.update();
    }
 
    public static <M extends Model> M find(int id, Supplier<M> constructor) {
        M instance = constructor.get();
        Method[] methods = instance.getClass().getDeclaredMethods();
        List<Method> setters = new ArrayList<>();
        List<Field> fields = Utility.getFields(methods, instance, true);
        Conector connector = Conector.getInstancia();

        for (Method m : methods) {
            if (m.getName().contains("set")) {
                setters.add(m);
            }
        }

        String sql = "SELECT * FROM " + Utility.tableOf(instance) + " WHERE id = " + id;

        try {
            ResultSet rs = connector.ejecutarQuery(sql);

            while (rs.next()) {
                instance.setId(id);
                for (int i = 0; i < setters.size(); i++) {
                    Method tempMethod = setters.get(i);
                    for (int j = 0; j < fields.size(); j++) {
                        Field tempField = fields.get(j);
                        if (tempMethod.getName().toLowerCase().contains(tempField.getNombre())) {
                            tempMethod.invoke(instance, connector.getResult(rs, tempField.getTipo(), tempField.getNombre()));
                        }
                    }
                }
            }

        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "Failed execute query", e);
            return null;
        } 
        System.out.println(sql);

        return instance;
    }

        public static <M extends Model> List<M> all(Supplier<M> constructor)  {
        M instance = constructor.get();
        List<M> models = new ArrayList<>();
        Method[] methods = instance.getClass().getDeclaredMethods();
        List<Method> setters = new ArrayList<>();
        List<Field> fields = Utility.getFields(methods, instance, true);
        Conector connector = Conector.getInstancia();

        for (Method m : methods) {
            if (m.getName().contains("set")) {
                setters.add(m);
            }
        }

        String sql = "SELECT * FROM " + Utility.tableOf(instance);
        try {
            ResultSet rs = connector.ejecutarQuery(sql);

            while (rs.next()) {
                M model = constructor.get();
                model.setId(rs.getInt("id"));

                for (int i = 0; i < setters.size(); i++) {
                    Method tempMethod = setters.get(i);
                    for (int j = 0; j < fields.size(); j++) {
                        Field tempField = fields.get(j);
                        if (tempMethod.getName().toLowerCase().contains(tempField.getNombre())) {
                            tempMethod.invoke(model, connector.getResult(rs, tempField.getTipo(), tempField.getNombre()));
                        }
                    }
                }
                models.add(model);
            }
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "Failed to execute query", e);
            return null;
        }  
        
        System.out.println(sql);

        return models;
    }
     public static <M extends Model> List<M> modelQuery(Supplier<M> constructor,String sql)  {
        M instance = constructor.get();
        List<M> models = new ArrayList<>();
        Method[] methods = instance.getClass().getDeclaredMethods();
        List<Method> setters = new ArrayList<>();
        List<Field> fields = Utility.getFields(methods, instance, true);
        Conector connector = Conector.getInstancia();

        for (Method m : methods) {
            if (m.getName().contains("set")) {
                setters.add(m);
            }
        }

        try {
            ResultSet rs = connector.ejecutarQuery(sql);

            while (rs.next()) {
                M model = constructor.get();
                model.setId(rs.getInt("id"));

                for (int i = 0; i < setters.size(); i++) {
                    Method tempMethod = setters.get(i);
                    for (int j = 0; j < fields.size(); j++) {
                        Field tempField = fields.get(j);
                        if (tempMethod.getName().toLowerCase().contains(tempField.getNombre())) {
                            tempMethod.invoke(model, connector.getResult(rs, tempField.getTipo(), tempField.getNombre()));
                        }
                    }
                }
                models.add(model);
            }
        } catch (SQLException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "Failed to execute query", e);
            return null;
        }  
        
        System.out.println(sql);

        return models;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getDato(Field field){
        switch (field.getTipo()) {
            case "int":
            case "Integer":
                return field.getValor().toString();
            case "double":
            case "Double":
                return field.getValor().toString();
            case "float":
            case "Float":
                return field.getValor().toString();
            case "String":
                return "'" + field.getValor()+ "'";
        }
        return null;
    }
    
}
