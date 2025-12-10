/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author leymanwu
 */
public class Residuo {

    private String nombre;
    private String tipoResiduo;
    private double peso;

    public Residuo(String nombre, String tipoResiduo, double peso) {
        this.nombre = nombre;
        this.tipoResiduo = tipoResiduo;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(String tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Residuo:\n" + "Nombre:" + nombre + "\nTipo de residuo:" + tipoResiduo + "\nPeso:" + peso;
    }

}
