/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.view;

import java.util.List;
import sistemacompraventa.proceso.ItemComponent;

/**
 *
 * @author Franklin
 */
public interface IUiCombo {
    void guardarCombo(List<ItemComponent> list ,String accion);
}
