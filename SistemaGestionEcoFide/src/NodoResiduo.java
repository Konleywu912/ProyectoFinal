/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class NodoResiduo{
    private Residuo elemento;
    private NodoResiduo siguiente;
    
    public NodoResiduo() {
        this.siguiente = null;
    }
    
    public NodoResiduo(Residuo elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
    
    public Residuo getElemento() {
        return elemento;
    }
    
    public void setElemento(Residuo elemento) {
        this.elemento = elemento;
    }
    
    public NodoResiduo getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoResiduo siguiente) {
        this.siguiente = siguiente;
    }
}