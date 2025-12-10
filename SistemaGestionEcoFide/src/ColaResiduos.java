/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class ColaResiduos {
    private NodoResiduoCola inicio;
    private NodoResiduoCola fin;
    
    public ColaResiduos() {
        this.inicio = null;
        this.fin = null;
    }
    
    // Verifica si la cola está vacía
    public boolean vacia() {
        return inicio == null;
    }
    
    // Encolar un residuo (agregar al final)
    public void encolar(Residuo residuo) {
        NodoResiduoCola nuevo = new NodoResiduoCola(residuo);
        
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        System.out.println("Residuo encolado: " + residuo.getNombre());
    }
    
    // Desencolar un residuo (quitar del inicio)
    public Residuo desencolar() {
        if (vacia()) {
            System.out.println("Error: Cola vacía");
            return null;
        }
        Residuo dato = inicio.getElemento();
        inicio = inicio.getSiguiente();
        
        if (inicio == null) {
            fin = null;
        }
        return dato;
    }
    
    // Ver el primer elemento sin eliminarlo
    public Residuo verPrimero() {
        if (vacia()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return inicio.getElemento();
    }
    
    // Mostrar todos los elementos de la cola
    public void mostrar() {
        if (vacia()) {
            System.out.println("Error: Cola Vacía");
            return;
        }
        NodoResiduoCola actual = inicio;
        System.out.println("Contenido de la cola:");
        while (actual != null) {
            System.out.println(actual.getElemento());
            actual = actual.getSiguiente();
        }
    }
    
    // Obtener todos los residuos como String para mostrar en GUI
    public String obtenerContenido() {
        if (vacia()) {
            return "La cola está vacía";
        }
        String contenido = "=== COLA DE RECICLAJE (FIFO) ===\n\n";
        NodoResiduoCola actual = inicio;
        int posicion = 1;
        while (actual != null) {
            contenido += "Posición " + posicion + ":\n";
            contenido += actual.getElemento().toString() + "\n";
            contenido += "------------------------\n";
            actual = actual.getSiguiente();
            posicion++;
        }
        return contenido;
    }
    
    // Contar cuántos residuos hay en la cola
    public int contarElementos() {
        int contador = 0;
        NodoResiduoCola actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    void mostrarTodo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}