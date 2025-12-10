
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leymanwu
 */
public class ProductoReciclado {
    
    private int idProducto;
    private String descripcion;
    private String materialBase;
    private Date fechaProducion;

    public ProductoReciclado(int idProducto, String descripcion, String materialBase, Date fechaProducion) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.materialBase = materialBase;
        this.fechaProducion = fechaProducion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaterialBase() {
        return materialBase;
    }

    public void setMaterialBase(String materialBase) {
        this.materialBase = materialBase;
    }

    public Date getFechaProducion() {
        return fechaProducion;
    }

    public void setFechaProducion(Date fechaProducion) {
        this.fechaProducion = fechaProducion;
    }
    
    
    
}
