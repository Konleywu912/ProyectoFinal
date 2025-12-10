/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class ListaDistribuciones {
    private NodoDistribucion inicio;
    
    public ListaDistribuciones() {
        this.inicio = null;
    }
    
    // Verifica si la lista está vacía
    public boolean vacia() {
        return inicio == null;
    }
    
    // Insertar una distribución al final de la lista
    public void insertar(Distribucion distribucion) {
        NodoDistribucion nuevo = new NodoDistribucion(distribucion);
        
        if (vacia()) {
            inicio = nuevo;
        } else {
            NodoDistribucion actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        System.out.println("Distribución registrada: " + distribucion.getDestino());
    }
    
    // Mostrar todas las distribuciones
    public void mostrar() {
        if (vacia()) {
            System.out.println("No hay distribuciones registradas");
            return;
        }
        NodoDistribucion actual = inicio;
        System.out.println("=== DISTRIBUCIONES REGISTRADAS ===");
        while (actual != null) {
            Distribucion d = actual.getElemento();
            System.out.println("Producto: " + d.getProducto().getDescripcion());
            System.out.println("Destino: " + d.getDestino());
            System.out.println("Fecha: " + d.getFechaDistribucion());
            System.out.println("------------------------");
            actual = actual.getSiguiente();
        }
    }
    
    // Obtener todas las distribuciones como String para mostrar en GUI
    public String obtenerContenido() {
        if (vacia()) {
            return "No hay distribuciones registradas";
        }
        String contenido = "=== DISTRIBUCIONES REGISTRADAS ===\n\n";
        NodoDistribucion actual = inicio;
        int contador = 1;
        while (actual != null) {
            Distribucion d = actual.getElemento();
            contenido += "Distribución #" + contador + ":\n";
            contenido += "Producto: " + d.getProducto().getDescripcion() + "\n";
            contenido += "Material: " + d.getProducto().getMaterialBase() + "\n";
            contenido += "Destino: " + d.getDestino() + "\n";
            contenido += "Fecha: " + d.getFechaDistribucion() + "\n";
            contenido += "------------------------\n";
            actual = actual.getSiguiente();
            contador++;
        }
        return contenido;
    }
    
    // Contar cuántas distribuciones hay
    public int contarElementos() {
        int contador = 0;
        NodoDistribucion actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
}