/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class ListaResiduos {
    
    private NodoResiduo inicio;
    
    public ListaResiduos() {
        this.inicio = null;
    }
    
    // Verifica si la lista está vacía
    public boolean vacia() {
        return inicio == null;
    }
    
    // Insertar un residuo al final de la lista
    public void insertar(Residuo residuo) {
        NodoResiduo nuevo = new NodoResiduo(residuo);
        
        if (vacia()) {
            inicio = nuevo;
        } else {
            NodoResiduo actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        System.out.println("Residuo agregado: " + residuo.getNombre());
    }
    
    // Buscar un residuo por nombre
    public Residuo buscarPorNombre(String nombre) {
        if (vacia()) {
            return null;
        }
        NodoResiduo actual = inicio;
        while (actual != null) {
            if (actual.getElemento().getNombre().equalsIgnoreCase(nombre.trim())) {
                return actual.getElemento();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    // Eliminar un residuo por nombre
    public boolean eliminar(String nombre) {
        if (vacia()) {
            return false;
        }
        
        // Si es el primero
        if (inicio.getElemento().getNombre().equalsIgnoreCase(nombre.trim())) {
            inicio = inicio.getSiguiente();
            return true;
        }
        
        // Si está en medio o al final
        NodoResiduo actual = inicio;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getElemento().getNombre().equalsIgnoreCase(nombre.trim())) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    // Mostrar todos los residuos
    public void mostrar() {
        if (vacia()) {
            System.out.println("No hay residuos registrados");
            return;
        }
        NodoResiduo actual = inicio;
        System.out.println("=== RESIDUOS REGISTRADOS ===");
        while (actual != null) {
            System.out.println(actual.getElemento());
            System.out.println("------------------------");
            actual = actual.getSiguiente();
        }
    }
    
    // Filtrar por categoría
    public String filtrarPorCategoria(String categoria) {
        if (vacia()) {
            return "No hay residuos registrados";
        }
        String resultado = "=== RESIDUOS DE CATEGORÍA: " + categoria.toUpperCase() + " ===\n\n";
        NodoResiduo actual = inicio;
        int contador = 0;
        
        while (actual != null) {
            if (actual.getElemento().getTipoResiduo().equalsIgnoreCase(categoria)) {
                resultado += actual.getElemento().toString() + "\n";
                resultado += "------------------------\n";
                contador++;
            }
            actual = actual.getSiguiente();
        }
        
        if (contador == 0) {
            return "No hay residuos de la categoría: " + categoria;
        }
        resultado += "\nTotal encontrados: " + contador;
        return resultado;
    }
    
    // Contar cuántos residuos hay
    public int contarElementos() {
        int contador = 0;
        NodoResiduo actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
    
    // Obtener el primer nodo (para iterar externamente)
    public NodoResiduo getInicio() {
        return inicio;
    }
}