/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.vo;

/**
 *
 * @author Labing
 */
public class recoleccion {
    
    private String fecha;
    private String recolector;
    private int id_colmena;
    private int kilosMiel;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRecolector() {
        return recolector;
    }

    public void setRecolector(String recolector) {
        this.recolector = recolector;
    }

    public int getId_colmena() {
        return id_colmena;
    }

    public void setId_colmena(int id_colmena) {
        this.id_colmena = id_colmena;
    }

    public int getKilosMiel() {
        return kilosMiel;
    }

    public void setKilosMiel(int kilosMiel) {
        this.kilosMiel = kilosMiel;
    }
    
}
