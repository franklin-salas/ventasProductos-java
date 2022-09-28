/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacompraventa.proceso;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Franklin
 */
public abstract class Sujeto {
    private final LinkedList<Observador> Observadores;
	public Observador m_Observador;

    public Sujeto() {
        this.Observadores = new LinkedList<>();
    }
    
    public void addObservador(Observador obs){
        Observadores.add(obs);
    }
    
    public void removerObservador(Observador obs){
        Observadores.remove(obs);
    }
    
    public void notificar(String accion){
        for (Observador obs : Observadores) {
            obs.actualizar(this,accion);
        }
    }
    
}
