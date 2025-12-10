/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class ListaProductos {
    private NodoProducto inicio;
    
    public ListaProductos() {
        this.inicio = null;
    }
    
    // Verifica si la lista está vacía
    public boolean vacia() {
        return inicio == null;
    }
    
    // Insertar un producto al final de la lista
    public void insertar(ProductoReciclado producto) {
        NodoProducto nuevo = new NodoProducto(producto);
        
        if (vacia()) {
            inicio = nuevo;
        } else {
            NodoProducto actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        System.out.println("Producto agregado: " + producto.getDescripcion());
    }
    
    // Buscar un producto por ID
    public ProductoReciclado buscarPorId(int id) {
        if (vacia()) {
            return null;
        }
        NodoProducto actual = inicio;
        while (actual != null) {
            if (actual.getElemento().getIdProducto() == id) {
                return actual.getElemento();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    
    // Mostrar todos los productos
    public void mostrar() {
        if (vacia()) {
            System.out.println("No hay productos reciclados");
            return;
        }
        NodoProducto actual = inicio;
        System.out.println("=== PRODUCTOS RECICLADOS ===");
        while (actual != null) {
            System.out.println(actual.getElemento());
            System.out.println("------------------------");
            actual = actual.getSiguiente();
        }
    }
    
    // Obtener todos los productos como String para mostrar en GUI
    public String obtenerContenido() {
        if (vacia()) {
            return "No hay productos reciclados";
        }
        String contenido = "=== PRODUCTOS RECICLADOS ===\n\n";
        NodoProducto actual = inicio;
        int contador = 1;
        while (actual != null) {
            ProductoReciclado p = actual.getElemento();
            contenido += "Producto #" + contador + ":\n";
            contenido += "ID: " + p.getIdProducto() + "\n";
            contenido += "Descripción: " + p.getDescripcion() + "\n";
            contenido += "Material Base: " + p.getMaterialBase() + "\n";
            contenido += "Fecha Producción: " + p.getFechaProducion() + "\n";
            contenido += "------------------------\n";
            actual = actual.getSiguiente();
            contador++;
        }
        return contenido;
    }
    
    // Contar cuántos productos hay
    public int contarElementos() {
        int contador = 0;
        NodoProducto actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }
}