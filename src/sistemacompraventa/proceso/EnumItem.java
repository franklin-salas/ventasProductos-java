/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.proceso;

/**
 *
 * @author Franklin
 */
public enum EnumItem {
    
      COMPUESTO {
                @Override
                public String toString() {
                    return "Compuesto";
                }
            },

    SIMPLE {
                @Override
                public String toString() {
                    return "Simple";
                }
            };
    
  
    public static EnumItem parseString(String Enum) {
        if (Enum.equalsIgnoreCase(COMPUESTO.toString())) {
            return EnumItem.COMPUESTO;
        }
        
        return EnumItem.SIMPLE;
    }
  
}
