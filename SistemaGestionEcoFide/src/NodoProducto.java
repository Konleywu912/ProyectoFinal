/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class NodoProducto {
    
      private ProductoReciclado elemento;
    private NodoProducto siguiente;
    
    public NodoProducto() {
        this.siguiente = null;
    }
    
    public NodoProducto(ProductoReciclado elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
    
    public ProductoReciclado getElemento() {
        return elemento;
    }
    
    public void setElemento(ProductoReciclado elemento) {
        this.elemento = elemento;
    }
    
    public NodoProducto getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }
}

