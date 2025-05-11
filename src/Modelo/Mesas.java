/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ocasp
 */
public class Mesas {
    private int id;
    private String numero;
    private int capacida ;
    private String ubicacion;
    private String estado; 
    
    public Mesas(){
        
    }
    public Mesas(String numero,int capacida,String ubicacion,String estado){
        this.numero=numero;
        this.capacida=capacida;
        this.ubicacion=ubicacion;
        this.estado=estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacida() {
        return capacida;
    }

    public void setCapacida(int capacida) {
        this.capacida = capacida;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
