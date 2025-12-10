/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class NodoDistribucion 
{
    private Distribucion elemento;
    private NodoDistribucion siguiente;
    
    public NodoDistribucion() {
        this.siguiente = null;
    }
    
    public NodoDistribucion(Distribucion elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
    
    public Distribucion getElemento() {
        return elemento;
    }
    
    public void setElemento(Distribucion elemento) {
        this.elemento = elemento;
    }
    
    public NodoDistribucion getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoDistribucion siguiente) {
        this.siguiente = siguiente;
    }
}