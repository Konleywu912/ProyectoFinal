/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class NodoResiduoPila {
    private Residuo dato;
    private NodoResiduoPila siguiente;
    
    public NodoResiduoPila() {
        this.siguiente = null;
    }
    
    public NodoResiduoPila(Residuo dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    public Residuo getDato() {
        return dato;
    }
    
    public void setDato(Residuo dato) {
        this.dato = dato;
    }
    
    public NodoResiduoPila getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoResiduoPila siguiente) {
        this.siguiente = siguiente;
    }
}