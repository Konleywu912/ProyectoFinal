
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leymanwu
 */
public class Distribucion {
    ProductoReciclado producto;
    private String destino;
    private Date fechaDistribucion;

    public ProductoReciclado getProducto() {
        return producto;
    }

    public void setProducto(ProductoReciclado producto) {
        this.producto = producto;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaDistribucion() {
        return fechaDistribucion;
    }

    public void setFechaDistribucion(Date fechaDistribucion) {
        this.fechaDistribucion = fechaDistribucion;
    }
    
    
}

