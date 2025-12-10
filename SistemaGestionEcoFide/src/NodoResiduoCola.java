/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class NodoResiduoCola {
    private Residuo elemento;
    private NodoResiduoCola siguiente;
    
    public NodoResiduoCola() {
        this.siguiente = null;
    }
    
    public NodoResiduoCola(Residuo elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
    
    public Residuo getElemento() {
        return elemento;
    }
    
    public void setElemento(Residuo elemento) {
        this.elemento = elemento;
    }
    
    public NodoResiduoCola getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoResiduoCola siguiente) {
        this.siguiente = siguiente;
    }
}