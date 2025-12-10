/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class PilaResiduos {
    private NodoResiduoPila cima;
    
    public PilaResiduos() {
        this.cima = null;
    }
    
    // Verifica si la pila está vacía
    public boolean vacia() {
        return cima == null;
    }
    
    // Apilar un residuo (PUSH)
    public void push(Residuo residuo) {
        NodoResiduoPila nuevo = new NodoResiduoPila(residuo);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        System.out.println("Residuo apilado: " + residuo.getNombre());
    }
    
    // Desapilar un residuo (POP)
    public Residuo pop() {
        if (vacia()) {
            System.out.println("Error: Pila vacía");
            return null;
        }
        Residuo dato = cima.getDato();
        cima = cima.getSiguiente();
        return dato;
    }
    
    // Ver el elemento en la cima sin eliminarlo
    public Residuo peek() {
        if (vacia()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return cima.getDato();
    }
    
    // Mostrar todos los elementos de la pila
    public void mostrar() {
        if (vacia()) {
            System.out.println("Error: Pila Vacía");
            return;
        }
        NodoResiduoPila actual = cima;
        System.out.println("Contenido de la pila:");
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
    
    // Obtener todos los residuos como String para mostrar en GUI
    public String obtenerContenido() {
        if (vacia()) {
            return "La pila está vacía";
        }
        String contenido = "=== PILA DE RESIDUOS (LIFO) ===\n\n";
        NodoResiduoPila actual = cima;
        int posicion = 1;
        while (actual != null) {
            contenido += "Posición " + posicion + ":\n";
            contenido += actual.getDato().toString() + "\n";
            contenido += "------------------------\n";
            actual = actual.getSiguiente();
            posicion++;
        }
        return contenido;
    }
    
    // Contar cuántos residuos hay en la pila
    public int contarElementos() {
        int contador = 0;
        NodoResiduoPila actual = cima;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
}