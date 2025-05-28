/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.a9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class BDVeiculos {
    private List<Passeio> listaPasseio = new ArrayList<Passeio>();
    private List<Carga> listaCarga = new ArrayList<Carga>();
    
    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public void setListaPasseio(List<Passeio> listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public List<Carga> getListaCarga(){
        return listaCarga;
    }

    public void setListaCarga(List<Carga> listaCarga) {
        this.listaCarga = listaCarga;
    }
    
}
