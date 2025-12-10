
import java.util.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jorge
 */
public class GestionResiduos {
    
    
    ListaResiduos listaResiduos;
    PilaResiduos pilaResiduos;
    ColaResiduos colaReciclaje;
    ListaProductos listaProductos;
    ListaDistribuciones listaDistribuciones;
    private int contadorProductos;
    
    public GestionResiduos() {
        this.listaResiduos = new ListaResiduos();
        this.pilaResiduos = new PilaResiduos();
        this.colaReciclaje = new ColaResiduos();
        this.listaProductos = new ListaProductos();
        this.listaDistribuciones = new ListaDistribuciones();
        this.contadorProductos = 1;
    }
    
    
    public void registrarResiduos(String nombre, String tipo, double peso) {
        if (nombre == null || nombre.isEmpty() || tipo == null || tipo.isEmpty()) {
            System.out.println("Nombre y tipo de residuo son obligatorios");
            return;
        }
        if (peso <= 0) {
            System.out.println("La cantidad debe ser mayor que cero");
            return;
        }
        
        
        String[] categoriasPermitidas = {"Vidrio", "Plastico", "Papel", "Metal", "Organico"};
        boolean categoriaValida = false;
        for (String cat : categoriasPermitidas) {
            if (cat.equalsIgnoreCase(tipo)) {
                categoriaValida = true;
                break;
            }
        }
        
        if (!categoriaValida) {
            System.out.println("Categoría no válida. Debe ser: Vidrio, Plástico, Papel, Metal u Orgánico");
            return;
        }
        
        Residuo residuo = new Residuo(nombre, tipo, peso);
        listaResiduos.insertar(residuo);
        System.out.println("Residuo agregado correctamente: " + residuo.getNombre());
    }
    
    
    public void apilarResiduos(String nombre) {
        if (listaResiduos.vacia()) {
            System.out.println("No hay residuos para apilar.");
            return;
        }
        
        Residuo encontrado = listaResiduos.buscarPorNombre(nombre);
        
        if (encontrado != null) {
            pilaResiduos.push(encontrado);
            listaResiduos.eliminar(nombre);
            System.out.println("Residuo apilado correctamente: " + encontrado.getNombre());
        } else {
            System.out.println("No se encontró ningún residuo con ese nombre.");
        }
    }
    
    
    public void trasladarResiduosACola() {
        if (pilaResiduos.vacia()) {
            System.out.println("No hay residuos en la pila para trasladar.");
            return;
        }
        
        int contador = 0;
        while (!pilaResiduos.vacia()) {
            Residuo r = pilaResiduos.pop();
            colaReciclaje.encolar(r);
            System.out.println("Residuo trasladado a la cola: " + r.getNombre());
            contador++;
        }
        System.out.println("Total de residuos trasladados: " + contador);
    }
    
    
    public void convertirResiduosEnProductos() {
        if (colaReciclaje.vacia()) {
            System.out.println("No hay residuos en la cola para reciclar.");
            return;
        }
        
        int contador = 0;
        while (!colaReciclaje.vacia()) {
            Residuo r = colaReciclaje.desencolar();
            ProductoReciclado p = new ProductoReciclado(
                    contadorProductos++,
                    r.getNombre() + " reciclado",
                    r.getTipoResiduo(),
                    new Date()
            );
            listaProductos.insertar(p);
            System.out.println("Producto creado: " + p.getDescripcion());
            contador++;
        }
        System.out.println("Total de productos creados: " + contador);
    }
    
    
    public void registrarDistribucion(int idProducto, String destino, Date fechaDistribucion) {
        ProductoReciclado producto = listaProductos.buscarPorId(idProducto);
        
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        
        Distribucion d = new Distribucion();
        d.setProducto(producto);
        d.setDestino(destino);
        d.setFechaDistribucion(fechaDistribucion);
        
        listaDistribuciones.insertar(d);
        System.out.println("Distribución registrada: " + producto.getDescripcion() + " -> " + destino);
    }
    
    
    public void verResiduosRegistrados() {
        listaResiduos.mostrar();
    }
    
    public void verResiduosEnPila() {
        pilaResiduos.mostrar();
    }
    
    public void verResiduosEnCola() {
        colaReciclaje.mostrar();
    }
    
    public void verProductosReciclados() {
        listaProductos.mostrar();
    }
    
    public void verDistribuciones() {
        listaDistribuciones.mostrar();
    }
    
    
    public String filtrarResiduosPorCategoria(String categoria) {
        return listaResiduos.filtrarPorCategoria(categoria);
    }
}